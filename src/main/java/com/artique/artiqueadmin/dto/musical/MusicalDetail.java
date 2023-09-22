package com.artique.artiqueadmin.dto.musical;

import com.artique.artiqueadmin.entity.Musical;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MusicalDetail {
  private String id;
  private String name;
  private LocalDate beginDate;
  private LocalDate endDate;
  private String placeName;
  private String genre;
  private String casting;
  private String runningTime;
  private String plot;
  private String posterUrl;
  private String musicalStatus;
  public static MusicalDetail of(Musical m){
    return new MusicalDetail(m.getId(),m.getName(),m.getBeginDate(),m.getEndDate()
            ,m.getPlaceName(),m.getGenre(),m.getCasting(),m.getRunningTime(),m.getPlot()
            ,m.getPosterUrl(),m.getMusicalStatus());
  }
}
