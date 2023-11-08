package com.artique.artiqueadmin.repository;

import com.artique.artiqueadmin.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}
