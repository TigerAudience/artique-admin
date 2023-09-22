package com.artique.artiqueadmin.repository;

import com.artique.artiqueadmin.entity.Musical;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicalRepository extends JpaRepository<Musical,String> {
}
