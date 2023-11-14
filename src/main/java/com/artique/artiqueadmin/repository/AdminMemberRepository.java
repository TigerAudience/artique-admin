package com.artique.artiqueadmin.repository;

import com.artique.artiqueadmin.entity.AdminMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminMemberRepository extends JpaRepository<AdminMember,String> {
}
