package com.artique.artiqueadmin.repository;

import com.artique.artiqueadmin.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report,Long> {
}
