package com.artique.artiqueadmin.entity;

import com.artique.artiqueadmin.dto.musical.MusicalForm;
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

  public void update(MusicalForm form){
    if(form.getName()!=null)
      this.name=form.getName();
    if(form.getBeginDate()!=null)
      this.beginDate=form.getBeginDate();
    if(form.getEndDate()!=null)
      this.endDate=form.getEndDate();
    if(form.getPlaceName()!=null)
      this.placeName=form.getPlaceName();
    if(form.getGenre()!=null)
      this.genre=form.getGenre();
    if(form.getCasting()!=null)
      this.casting=form.getCasting();
    if(form.getPlot()!=null)
      this.plot=form.getPlot();
    if(form.getPosterUrl()!=null)
      this.posterUrl=form.getPosterUrl();
    if(form.getMusicalStatus()!=null)
      this.musicalStatus=form.getMusicalStatus();
  }
}
