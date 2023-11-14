package com.artique.artiqueadmin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Member {
  @Id
  private String id;
  private String nickname;
  private String profileUrl;
  private String introduce;
  private String password;
  private Integer warningCount;
  private Integer reportCount;
  private ZonedDateTime banDate;
  private ZonedDateTime createdAt;
  private static final int banThreshold=3;
  public void increaseBanCount(){
    this.warningCount+=1;
  }
  public void ban(long days){
    banDate=ZonedDateTime.now(ZoneId.of("Asia/Seoul")).plusDays(days);
  }
  public boolean mustBan(){
    return this.warningCount>=banThreshold;
  }
}
