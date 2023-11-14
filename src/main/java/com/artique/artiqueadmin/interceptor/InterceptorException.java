package com.artique.artiqueadmin.interceptor;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class InterceptorException extends RuntimeException{
  private final String interceptorName;
  public InterceptorException(String message,String name){
    super(message);
    this.interceptorName=name;
  }
}
