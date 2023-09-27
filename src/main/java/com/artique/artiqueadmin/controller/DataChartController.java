package com.artique.artiqueadmin.controller;
import com.artique.artiqueadmin.dto.musical.MusicalDatas;
import com.artique.artiqueadmin.dto.musical.MusicalDetail;
import com.artique.artiqueadmin.dto.musical.MusicalForm;
import com.artique.artiqueadmin.repository.MusicalRepository;
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
  private final MusicalRepository musicalRepository;
  @GetMapping
  public String chart(Model model,@RequestParam(value = "page",required = false) Integer page,
                      @RequestParam(value = "size",required = false) Integer size,
                      @RequestParam(value = "key-word",required = false)String keyWord){
    if(page==null||size==null)
      return "redirect:/data?page=1&size=20";
    page-=1;
    int totalPage = musicalRepository.countMusical();
    if(totalPage/size<page)
      return "redirect:/data?page="+(totalPage/size+1)+"&size=20";
    if(page<0)
      return "redirect:/data?page=1&size=20";
    MusicalDatas musicals = musicalService.getMusicals(page, size,keyWord);
    model.addAttribute("musicals_info",musicals.getMusicals());
    model.addAttribute("total_page",createPages(10,page,musicals.getTotalPage()));
    model.addAttribute("page",musicals.getPage());
    model.addAttribute("size",musicals.getSize());
    model.addAttribute("now_page_number",page+1);
    model.addAttribute("now_key_word",keyWord);
    model.addAttribute("total_page_count",totalPage);
    return "home/data-chart";
  }
  private List<Integer> createPages(int pageHalfSize,int page,int totalPage){
    List<Integer> pages = new ArrayList<>();
    for(int i=page-pageHalfSize;i<page;i++){
      if(i<0)
        continue;
      pages.add(i+1);
    }
    for(int i=page;i<page+pageHalfSize;i++) {
      if(i>=totalPage)
        break;
      pages.add(i + 1);
    }
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
