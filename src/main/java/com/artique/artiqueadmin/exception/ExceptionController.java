package com.artique.artiqueadmin.exception;

import com.artique.artiqueadmin.service.MusicalDeleteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

  @ExceptionHandler(MusicalDeleteException.class)
  public ResponseEntity<ErrorResponse> deleteException(MusicalDeleteException e){
    return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
  }
}
