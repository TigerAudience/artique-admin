package com.artique.artiqueadmin.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class AuthorizationController {
  @PostMapping
  @ResponseBody
  public String login(HttpServletRequest request){
    HttpSession session = request.getSession();
    session.setAttribute("LOGIN_MEMBER",null);
    return "ok";
  }
}
