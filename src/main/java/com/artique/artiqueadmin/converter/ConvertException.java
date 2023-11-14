package com.artique.artiqueadmin.converter;

import lombok.Getter;

@Getter
public class ConvertException extends RuntimeException{
  private final String enumName;
  public ConvertException(String message,String enumName){
    super(message);
    this.enumName=enumName;
  }
}
