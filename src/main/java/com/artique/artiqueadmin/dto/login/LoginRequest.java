package com.artique.artiqueadmin.dto.login;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class LoginRequest {
  @AllArgsConstructor
  @NoArgsConstructor
  @Getter
  public static class LoginReq{
    private String id;
    private String password;
  }
}
