package com.artique.artiqueadmin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
  private ZonedDateTime createdAt;
}
