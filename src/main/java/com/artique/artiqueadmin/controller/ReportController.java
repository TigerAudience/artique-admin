package com.artique.artiqueadmin.controller;

import com.artique.artiqueadmin.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/report")
@RequiredArgsConstructor
public class ReportController {
  private final ReportService reportService;
  @GetMapping
  public String reports(Model model, @RequestParam(value = "page",required = false) Integer page,
                        @RequestParam(value = "size",required = false) Integer size,
                        @RequestParam(value = "key-word",required = false)String keyWord){
    return null;
  }
  @PostMapping
  public String reports(@RequestParam(value = "report-id")Long reportId){

    return "redirect:/report";
  }
}
