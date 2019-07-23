package com.chendehe.controller;

import com.chendehe.exception.ResultUtil;
import com.chendehe.service.impl.UserService;
import com.chendehe.service.remote.RestService;
import com.chendehe.vo.Page;
import com.chendehe.vo.UserVo;
import com.chendehe.websocket.ServerMessage;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UserController {

  private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

  private UserService service;

  @Autowired
  private RestService restService;

  @Autowired
  private SimpMessagingTemplate messagingTemplate;

  @Autowired
  public UserController(UserService service) {
    this.service = service;
  }

  /**
   * 查找列表. 成功返回200.
   */
  @GetMapping("/list")
  ResponseEntity findAll(Page page) {
    LOGGER.info("[UserController] id is:{}", page);
    return ResultUtil.success(service.findAll(page), HttpStatus.OK);
  }

  /**
   * 查找详情. 成功返回200.
   */
  @GetMapping("/{id}")
  ResponseEntity findOne(@PathVariable String id) {
    LOGGER.info("[UserController] id is:{}", id);
//    return ResultUtil.success(restService.findOne(id), HttpStatus.OK);
    return ResultUtil.success(service.findOne(id), HttpStatus.OK);
  }

  /**
   * 新建. 成功返回201.
   */
  @PostMapping("/")
  ResponseEntity save(@RequestBody UserVo userVo) {
    LOGGER.info("[UserController] user is:{}", new Gson().toJson(userVo));
//    return ResultUtil.success(restService.save(userVo), HttpStatus.CREATED);
    return ResultUtil.success(service.save(userVo), HttpStatus.CREATED);
  }

  /**
   * 更新. 成功返回201.
   */
  @PutMapping("/{id}")
  ResponseEntity update(@RequestBody UserVo userVo, @PathVariable String id) {
    LOGGER.info("[UserController] user is:{}, id is:{}", new Gson().toJson(userVo), id);
    userVo.setId(id);
//    return ResultUtil.success(restService.update(userVo), HttpStatus.CREATED);
    return ResultUtil.success(service.update(userVo), HttpStatus.CREATED);
  }

  /**
   * 删除. 成功返回204.
   */
  @DeleteMapping("/{id}")
  ResponseEntity delete(@PathVariable String id) {
    LOGGER.info("[UserController] id is:{}", id);
//    restService.delete(id);
    service.delete(id);
    return ResultUtil.success(HttpStatus.NO_CONTENT);
  }


  /**
   * Excel上传. 成功返回201.
   */
  @PostMapping("/upLoad")
  ResponseEntity upLoad(@RequestParam("file") MultipartFile file) {
    LOGGER.info("[UserController] file path:{}", file.isEmpty());

    if (!file.isEmpty()) {
      try {
        service.upload(file);
      } catch (IOException | InvalidFormatException e) {
        return ResultUtil.exception(e, HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }

    JsonObject json = new JsonObject();
    json.addProperty("status", "success");
    return ResultUtil.success(json.toString(), HttpStatus.CREATED);

  }

  /**
   * Excel下载. 成功返回200.
   *
   * @param id   id
   * @param path 下载文件本地存放路径
   * @return 状态
   */
  @GetMapping("/downLoad")
  public ResponseEntity downLoad(@RequestParam String id, @RequestParam String path) {
    LOGGER.info("[UserController] id:{},{}", id, path);
    service.downLoad(id, path);
    JsonObject json = new JsonObject();
    json.addProperty("status", "success");
    return ResultUtil.success(json.toString(), HttpStatus.NO_CONTENT);
  }

  //客户端只要订阅了/topic/subscribeTest主题，调用这个方法即可
  @PostMapping("/push/{msg}")
  public void pushMsg(@PathVariable String msg) {
    String s = "服务器主动推的数据";
    messagingTemplate.convertAndSend("/topic/subscribeTest", new ServerMessage(s + msg));
  }
}