package com.artique.artiqueadmin.exception;

import com.artique.artiqueadmin.converter.ConvertException;
import com.artique.artiqueadmin.interceptor.InterceptorException;
import com.artique.artiqueadmin.service.MusicalDeleteException;
import com.artique.artiqueadmin.service.ServiceException;
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
  @ExceptionHandler(ConvertException.class)
  public ResponseEntity<ErrorResponse> converterException(ConvertException e){
    return new ResponseEntity<>(new ErrorResponse("convert failed["+e.getEnumName()+"]"),HttpStatus.BAD_REQUEST);
  }
  @ExceptionHandler(InterceptorException.class)
  public ResponseEntity<ErrorResponse> interceptorException(InterceptorException e){
    return new ResponseEntity<>(new ErrorResponse("blocked by interceptor["+e.getInterceptorName()+"]"),HttpStatus.BAD_REQUEST);
  }
  @ExceptionHandler(ServiceException.class)
  public ResponseEntity<ErrorResponse> serviceException(ServiceException e){
    return new ResponseEntity<>(new ErrorResponse("service exception["+e.getServiceName()+"]"),HttpStatus.BAD_REQUEST);
  }
}
