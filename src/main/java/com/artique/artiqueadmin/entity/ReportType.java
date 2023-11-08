package com.artique.artiqueadmin.entity;

import lombok.Getter;

@Getter
public enum ReportType {

  SPOILER("spoiler"),INAPPROPRIATE("inappropriate-review");

  private final String type;
  ReportType(String type){
    this.type=type;
  }
}

