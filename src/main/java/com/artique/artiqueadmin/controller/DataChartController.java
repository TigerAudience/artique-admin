package com.artique.artiqueadmin.controller;

import com.artique.artiqueadmin.dto.musical.MusicalChart;
import com.artique.artiqueadmin.dto.musical.MusicalDatas;
import com.artique.artiqueadmin.dto.musical.MusicalDetail;
import com.artique.artiqueadmin.dto.musical.MusicalForm;
import com.artique.artiqueadmin.service.MusicalDeleteException;
import com.artique.artiqueadmin.service.MusicalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/data")
@RequiredArgsConstructor
public class DataChartController {

  private final MusicalService musicalService;
  @GetMapping
  public String chart(Model model,@RequestParam(value = "page",required = false) Integer page,
                      @RequestParam(value = "size",required = false) Integer size,
                      @RequestParam(value = "key-word",required = false)String keyWord){
    if(page==null||size==null)
      return "redirect:/data?page=1&size=10";
    page-=1;
    MusicalDatas musicals = musicalService.getMusicals(page, size,keyWord);
    model.addAttribute("musicals_info",musicals.getMusicals());
    model.addAttribute("total_page",createPages(musicals.getTotalPage()));
    model.addAttribute("page",musicals.getPage());
    model.addAttribute("size",musicals.getSize());
    model.addAttribute("now_key_word",keyWord);
    return "home/data-chart";
  }
  private List<Integer> createPages(int page){
    List<Integer> pages = new ArrayList<>();
    for(int i=0;i<page;i++)
      pages.add(i+1);
    return pages;
  }

  @GetMapping("/detail")
  public String detail(Model model, @RequestParam(value = "musical-id") String musicalId){
    MusicalDetail detail = musicalService.getDetail(musicalId);
    model.addAttribute("musical_detail",detail);
    model.addAttribute("musical_form", MusicalForm.of(detail));
    return "home/detail/data-edit";
  }
  @PostMapping("/edit")
  public String edit(MusicalForm form, @RequestParam(value = "musical-id") String musicalId){
    musicalService.update(form,musicalId);
    return "redirect:/data";
  }

  @PostMapping("/delete")
  public String delete(@RequestParam(value = "musical-id")String musicalId){
    try {
      musicalService.delete(musicalId);
    }catch (Exception e){
      throw new MusicalDeleteException("리뷰가 있는 공연은 삭제할 수 없습니다");
    }
    return "redirect:/data";
  }
}
