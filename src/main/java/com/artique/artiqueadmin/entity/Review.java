package com.artique.artiqueadmin.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.ZonedDateTime;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Review {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Double starRating;
  @Column(columnDefinition = "TEXT")
  private String shortReview;
  @Column(columnDefinition = "TEXT")
  private String longReview;
  private String casting;
  private LocalDate viewDate;
  private String seat;
  private Long thumbsUp;
  @ManyToOne
  private Member member;
  @ManyToOne
  private Musical musical;
  private ZonedDateTime createdAt;
  private boolean shortSpoiler;
  private boolean longSpoiler;

  public void changeSpoiler(){
    this.shortSpoiler=true;
    this.longSpoiler=true;
  }
}