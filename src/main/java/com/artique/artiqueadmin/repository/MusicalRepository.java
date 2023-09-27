package com.artique.artiqueadmin.repository;

import com.artique.artiqueadmin.entity.Musical;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MusicalRepository extends JpaRepository<Musical,String> {
  @Query("select m from Musical m where m.name like %:key_word%")
  Page<Musical> findAllInPage(Pageable pageable, @Param("key_word")String keyWord);
  @Query("select m from Musical m")
  Page<Musical> findAll(Pageable pageable);

  @Query(value = "select COUNT(*) from musical m",nativeQuery = true)
  Integer countMusical();
}
