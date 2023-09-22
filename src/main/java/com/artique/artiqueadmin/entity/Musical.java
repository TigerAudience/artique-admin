package com.artique.artiqueadmin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Musical {
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
  @OneToMany(mappedBy = "musical")
  private List<Review> reviews;

  public int calculateReviewCount(){
    return reviews.size();
  }
}
