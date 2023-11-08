package com.artique.artiqueadmin.service;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ServiceException extends RuntimeException{
  private String serviceName;
  public ServiceException(String message,String name){
    super(message);
    this.serviceName=name;
  }
}
