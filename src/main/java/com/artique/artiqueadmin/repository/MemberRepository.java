package com.artique.artiqueadmin.repository;

import com.artique.artiqueadmin.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,String> {
}
