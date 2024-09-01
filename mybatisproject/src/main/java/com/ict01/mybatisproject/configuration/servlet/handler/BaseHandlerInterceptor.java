package com.ict01.mybatisproject.configuration.servlet.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class BaseHandlerInterceptor implements HandlerInterceptor {

  /**
   * preHandle은 현재 URL에 mapping된 Controller의 method가 실행되기 전에 먼저 실행된다.
   */
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    // 만약 Login 체크를 Interceptor를 활용하는 경우 session을 체크한다.
    // 그러나 session 정보 중 회원 id를 Controller, View(Thymeleaf)에서도 사용하는 경우라면,
    // requestAttribute를 활용해서 값을 받을 수도 있다.
    log.info("preHandle requestURI : {}", request.getRequestURI());
    return true;
  }

  /**
   * postHandle은 현재 URL에 mapping된 Controller의 method가 실행된 후에 먼저 실행된다.
   */
  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    log.info("postHandle requestURI : {}", request.getRequestURI());
  }
}
