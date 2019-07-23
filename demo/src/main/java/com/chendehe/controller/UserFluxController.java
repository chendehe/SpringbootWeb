package com.chendehe.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;
import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.ServerResponse.created;
import static org.springframework.web.reactive.function.server.ServerResponse.noContent;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import com.chendehe.service.UserService;
import com.chendehe.vo.Page;
import com.chendehe.vo.UserVo;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Configuration
public class UserFluxController {

  @Bean
  public RouterFunction<ServerResponse> monoRouterFunction(UserFluxController userHandler) {
    return RouterFunctions
        .route(GET("/flux/list").and(accept(APPLICATION_JSON)), userHandler::findAll)
        .andRoute(GET("/flux/{id}").and(accept(APPLICATION_JSON)), userHandler::findOne)
        .andRoute(POST("/flux").and(accept(APPLICATION_JSON)), userHandler::save)
        .andRoute(PUT("/flux/{id}").and(accept(APPLICATION_JSON)), userHandler::update)
        .andRoute(DELETE("/flux/{id}").and(accept(APPLICATION_JSON)), userHandler::delete);
  }

  private UserService service;

  @Autowired
  public UserFluxController(UserService service) {
    this.service = service;
  }

  /**
   * 查找列表. 成功返回200.
   */
  Mono<ServerResponse> findAll(ServerRequest request) {
    Object currentPage = request.attribute("currentPage").orElse(1);
    Object pageSize = request.attribute("pageSize").orElse(10);
    Page page = new Page((Integer) currentPage, (Integer) pageSize);

    return ok().body(fromObject(service.findAll(page)));
  }

  /**
   * 查找详情. 成功返回200.
   */
  Mono<ServerResponse> findOne(ServerRequest request) {
    return ok().body(fromObject(service.findOne(request.pathVariable("id"))));
  }

  /**
   * 新建. 成功返回201.
   */
  Mono<ServerResponse> save(ServerRequest request) {
    return request.bodyToMono(UserVo.class).flatMap(user -> created(URI.create("")).body(fromObject(service.save(user))));
  }

  /**
   * 更新. 成功返回201.
   */
  Mono<ServerResponse> update(ServerRequest request) {
    String id = request.pathVariable("id");
    return request.bodyToMono(UserVo.class).flatMap(user -> {
      user.setId(id);
      return created(URI.create("")).body(fromObject(service.update(user)));
    });
  }

  /**
   * 删除. 成功返回204.
   */
  Mono<ServerResponse> delete(ServerRequest request) {
    service.delete(request.pathVariable("id"));
    return noContent().build();
  }
}