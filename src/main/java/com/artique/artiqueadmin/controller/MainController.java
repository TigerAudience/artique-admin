package com.artique.artiqueadmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

  @GetMapping("/")
  public String mainPage(){
    return "home/main/home";
  }
}
