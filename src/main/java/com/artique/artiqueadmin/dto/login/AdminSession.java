package com.artique.artiqueadmin.dto.login;

import com.artique.artiqueadmin.entity.AdminMember;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AdminSession {
  private String id;
  private String email;
  private String name;
  public static AdminSession of(AdminMember m){
    return new AdminSession(m.getId(),m.getEmail(),m.getName());
  }
}
