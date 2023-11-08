package com.artique.artiqueadmin.controller;

import com.artique.artiqueadmin.entity.ReportType;
import com.artique.artiqueadmin.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
  public String reports(@RequestParam(value = "report-id")Long reportId,
                        @RequestParam(value = "type")ReportType reportType){
    reportService.reportSuccess(reportId,reportType);
    return "redirect:/report";
  }
  @DeleteMapping
  public String reject(@RequestParam(value = "report-id")Long reportId){
    reportService.reportFail(reportId);
    return "redirect:/report";
  }
}
