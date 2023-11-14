package com.artique.artiqueadmin.service;

import com.artique.artiqueadmin.dto.login.AdminSession;
import com.artique.artiqueadmin.dto.login.LoginRequest;
import com.artique.artiqueadmin.dto.login.LoginRequest.LoginReq;
import com.artique.artiqueadmin.entity.AdminMember;
import com.artique.artiqueadmin.repository.AdminMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
  private final AdminMemberRepository adminMemberRepository;
  public AdminSession login(LoginReq loginReq){
    AdminMember member = adminMemberRepository.findById(loginReq.getId())
            .orElseThrow(()->new ServiceException("유효하지 않은 계정 입니다.",this.getClass().getName()));
    if(!member.validatePassword(loginReq.getPassword()))
      throw new ServiceException("유효하지 않은 계정 입니다.",this.getClass().getName());
    return AdminSession.of(member);
  }
}
