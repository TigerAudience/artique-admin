package com.artique.artiqueadmin.controller;

import com.artique.artiqueadmin.dto.login.AdminSession;
import com.artique.artiqueadmin.dto.login.LoginRequest;
import com.artique.artiqueadmin.dto.login.LoginRequest.LoginReq;
import com.artique.artiqueadmin.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class AuthorizationController {
  private final LoginService loginService;
  @PostMapping
  @ResponseBody
  public String login(HttpServletRequest request, @RequestBody LoginReq loginReq){
    HttpSession session = request.getSession();
    AdminSession adminInfo = loginService.login(loginReq);
    session.setAttribute("LOGIN_MEMBER",adminInfo);
    return "ok";
  }
  @GetMapping
  public String loginForm(Model model){
    model.addAttribute("login_form",new LoginReq());
    return "home/main/login";
  }
}
