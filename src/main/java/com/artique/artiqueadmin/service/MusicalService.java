package com.artique.artiqueadmin.service;

import com.artique.artiqueadmin.dto.musical.MusicalChart;
import com.artique.artiqueadmin.dto.musical.MusicalDatas;
import com.artique.artiqueadmin.dto.musical.MusicalDetail;
import com.artique.artiqueadmin.dto.musical.MusicalForm;
import com.artique.artiqueadmin.entity.Musical;
import com.artique.artiqueadmin.repository.MusicalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MusicalService {
  private final MusicalRepository musicalRepository;
  public MusicalDatas getMusicals(int page, int size,String keyWord){
    List<MusicalChart> musicals = new ArrayList<>();
    PageRequest pageRequest = PageRequest.of(page,size);
    Page<Musical> musicalEntities = keyWord==null ?
            musicalRepository.findAll(pageRequest) : musicalRepository.findAllInPage(pageRequest,keyWord);
    for(Musical m : musicalEntities){
      musicals.add(MusicalChart.of(m));
    }
    return new MusicalDatas(musicals,musicalEntities.getPageable().getPageNumber(),
            musicalEntities.getTotalPages(),musicalEntities.getSize());
  }

  public MusicalDetail getDetail(String id){
    return MusicalDetail.of(musicalRepository.findById(id).orElseThrow(()->new RuntimeException("invalid id")));
  }

  @Transactional
  public void update(MusicalForm form,String musicalId){
    Musical musical = musicalRepository.findById(musicalId).orElseThrow(()->new RuntimeException("invalid id"));
    musical.update(form);
  }
  @Transactional
  public void delete(String musicalId){
    Musical musical = musicalRepository.findById(musicalId).orElseThrow(()->new RuntimeException("invalid id"));
    musicalRepository.delete(musical);
  }
}
