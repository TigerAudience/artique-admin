package com.artique.artiqueadmin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class AdminMember {
  @Id
  private String id;
  private String name;
  private String password;
  private String email;

  public boolean validatePassword(String password){
    return this.password.equals(password);
  }
}
