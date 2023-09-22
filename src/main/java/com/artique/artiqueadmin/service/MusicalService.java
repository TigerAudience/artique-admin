package com.artique.artiqueadmin.service;

import com.artique.artiqueadmin.dto.musical.MusicalChart;
import com.artique.artiqueadmin.dto.musical.MusicalDetail;
import com.artique.artiqueadmin.entity.Musical;
import com.artique.artiqueadmin.repository.MusicalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MusicalService {
  private final MusicalRepository musicalRepository;
  public List<MusicalChart> getMusicals(){
    List<MusicalChart> musicals = new ArrayList<>();
    List<Musical> musicalEntities = musicalRepository.findAll();
    for(int i=0;i<5;i++){
      musicals.add(createMockMusical(i%2));
    }
    for(Musical m : musicalEntities){
      musicals.add(MusicalChart.of(m));
    }
    return musicals;
  }
  public MusicalChart createMockMusical(int idx){
    return new MusicalChart("id","title title title","2023/09/01",
            "2023/09/30","place","castingsgsg",
            idx==0?"plotplotplotplotplotplotplotplotplotplotplotplotplotplotplotplotplotplotplotplotplotplotplot":null
            ,"http://www.kopis.or.kr/upload/pfmPoster/PF_PF218497_230516_112335.jpg"
            ,"start",30);
  }

  public MusicalDetail getDetail(String id){
    return MusicalDetail.of(musicalRepository.findById(id).orElseThrow(()->new RuntimeException("invalid id")));
  }
}
