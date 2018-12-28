package com.yk.iworkgo.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lenovo on 2017/8/3.
 */
@Slf4j
@Component
public class UrlInterceptor extends HandlerInterceptorAdapter {


  @Value("${appKey}")
  private String appKey;

  @Value("${appSecret}")
  private String appSecret;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    request.setAttribute("appKey",appKey);
    request.setAttribute("appSecret",appSecret);
    return true;
  }

}
