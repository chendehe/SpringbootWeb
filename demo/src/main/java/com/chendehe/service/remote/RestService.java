package com.chendehe.service.remote;

import com.chendehe.vo.UserVo;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestService {

  private static final String URI = "http://localhost:1112";

  // AsyncRestTemplate
  private RestTemplate restTemplate;

  public RestService(RestTemplateBuilder restTemplateBuilder) {
    // 加密：restTemplateBuilder.basicAuthentication("user", "password").build();
    this.restTemplate = restTemplateBuilder.build();
  }

  public UserVo findOne(String id) {
    return this.restTemplate.getForObject(URI.concat("/{id}"), UserVo.class, id);
  }

  public UserVo save(UserVo userVo) {
    return this.restTemplate.postForObject(URI, userVo, UserVo.class);
  }

  public UserVo update(UserVo userVo) {
    this.restTemplate.put(URI.concat("/{id}"), userVo, userVo.getId());
    return userVo;
  }

  public void delete(String id) {
    this.restTemplate.delete(URI.concat("/{id}"), id);
  }

}
