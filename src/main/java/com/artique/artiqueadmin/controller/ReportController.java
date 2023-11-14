package com.artique.artiqueadmin.controller;

import com.artique.artiqueadmin.dto.report.ReportResponse;
import com.artique.artiqueadmin.dto.report.ReportResponse.ReportViewList;
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
    if(page==null||size==null)
      return "redirect:/report?page=1&size=200";
    page-=1;
    if(page<0)
      return "redirect:/report?page=1&size=200";

    Long reportCount = reportService.getReportCount();
    ReportViewList reportList = reportService.getReports(page,size,keyWord);
    model.addAttribute("reports_info",reportList.getReportViews());
    model.addAttribute("page",reportList.getPage()+1);
    model.addAttribute("size",reportList.getSize());
    model.addAttribute("hasNext",reportList.isHasNext());
    model.addAttribute("now_key_word",keyWord);
    model.addAttribute("total_report_count",reportCount);
    return "report/report-chart";
  }
  @GetMapping("/detail")
  public String detail(Model model,@RequestParam(value = "report-id") Long reportId){
    ReportResponse.ReportDetail reportDetail = reportService.getDetail(reportId);
    model.addAttribute("report",reportDetail);
    return "report/report-detail";
  }
  @PostMapping
  public String reportsProcess(@RequestParam(value = "report-id")Long reportId,
                        @RequestParam(value = "type")ReportType reportType){
    reportService.reportSuccess(reportId,reportType);
    return "redirect:/report";
  }
  @DeleteMapping
  @ResponseBody
  public String reject(@RequestParam(value = "report-id")Long reportId){
    reportService.reportFail(reportId);
    return "ok";
  }
}
