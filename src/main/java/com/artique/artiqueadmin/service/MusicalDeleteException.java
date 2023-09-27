package com.artique.artiqueadmin.service;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MusicalDeleteException extends RuntimeException{
  private String message;
}
