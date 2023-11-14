package com.artique.artiqueadmin.repository;

import com.artique.artiqueadmin.entity.Thumbs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ThumbsRepository extends JpaRepository<Thumbs,Long> {
  @Modifying
  @Query("delete from Thumbs t where t.review.id=:review_id")
  void deleteAllByReviewIds(@Param("review_id")Long reviewId);
}
