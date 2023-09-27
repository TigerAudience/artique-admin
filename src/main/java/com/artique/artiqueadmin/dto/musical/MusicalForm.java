package com.artique.artiqueadmin.dto.musical;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MusicalForm {
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

  public static MusicalForm of(MusicalDetail det){
    return new MusicalForm(det.getId(),det.getName(),det.getBeginDate(),det.getEndDate(),det.getPlaceName(),det.getGenre(),
            det.getCasting(),det.getRunningTime(),det.getPlot(),det.getPosterUrl(),det.getMusicalStatus());
  }
}
