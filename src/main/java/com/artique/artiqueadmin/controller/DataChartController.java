package com.artique.artiqueadmin.controller;

import com.artique.artiqueadmin.dto.musical.MusicalChart;
import com.artique.artiqueadmin.service.MusicalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/data")
@RequiredArgsConstructor
public class DataChartController {

  private final MusicalService musicalService;
  @GetMapping
  public String chart(Model model){
    List<MusicalChart> musicals = musicalService.getMusicals();
    model.addAttribute("musicals_info",musicals);
    return "home/data-chart";
  }

  @GetMapping("/detail")
  public String detail(Model model, @RequestParam(value = "musical-id") String musicalId){
    model.addAttribute("musical_detail",musicalService.getDetail(musicalId));
    return "home/detail/data-edit";
  }
}
