package com.artique.artiqueadmin.entity;

import com.artique.artiqueadmin.converter.ConvertException;
import lombok.Getter;

@Getter
public enum ReportType {

  SPOILER("spoiler"),INAPPROPRIATE("inappropriate"),PROMOTION("promotion"),SPAM("spam");

  private final String type;
  ReportType(String type){
    this.type=type;
  }

  public static ReportType of(String str){
    if(str==null)
      throw new ConvertException("report type can't be null","ReportType");
    for(ReportType r : ReportType.values()){
      if(r.getType().equals(str))
        return r;
    }
    throw new ConvertException("invalid report type name","ReportType");
  }
  public boolean warnMember(){
    return !this.equals(ReportType.SPOILER);
  }
}

