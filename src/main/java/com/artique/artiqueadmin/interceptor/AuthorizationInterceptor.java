package com.artique.artiqueadmin.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthorizationInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    Object o = request.getSession().getAttribute("LOGIN_MEMBER");
    if(o==null) {
      response.sendRedirect("/login");
      return false;
    }
    return HandlerInterceptor.super.preHandle(request, response, handler);
  }
}
