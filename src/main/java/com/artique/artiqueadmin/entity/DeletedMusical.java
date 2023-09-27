package com.artique.artiqueadmin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "musical_deleted")
public class DeletedMusical {
  @Id
  private String id;
  private String name;
  private LocalDate beginDate;
  private LocalDate endDate;
  private String placeName;
  private String genre;
  private String casting;
  private String runningTime;
  @Column(columnDefinition = "TEXT")
  private String plot;
  private String posterUrl;
  private String musicalStatus;

  public static DeletedMusical of(Musical m){
    return new DeletedMusical(m.getId(),m.getName(),m.getBeginDate(),m.getEndDate()
            ,m.getPlaceName(),m.getGenre(),m.getCasting(),m.getRunningTime(),m.getPlot()
            ,m.getPosterUrl(),m.getMusicalStatus());
  }
}
