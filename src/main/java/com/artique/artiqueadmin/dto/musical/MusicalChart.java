package com.artique.artiqueadmin.dto.musical;

import com.artique.artiqueadmin.entity.Musical;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MusicalChart {
  private String id;
  private String name;
  private String beginDate;
  private String endDate;
  private String placeName;
  private String casting;
  private String plot;
  private String posterUrl;
  private String musicalStatus;
  private Integer reviewCount;

  private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

  public static MusicalChart of(Musical m){
    return new MusicalChart(m.getId(),m.getName(),m.getBeginDate().format(formatter),m.getEndDate().format(formatter),
            m.getPlaceName(),m.getCasting(),m.getPlot(),m.getPosterUrl(),m.getMusicalStatus(),m.calculateReviewCount());
  }
}
