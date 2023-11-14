package com.artique.artiqueadmin.repository;

import com.artique.artiqueadmin.entity.Report;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReportRepository extends JpaRepository<Report,Long> {
  @Query(value = "select re from Report re join fetch re.review r join fetch re.reportMember mem " +
          "order by re.createdAt")
  Slice<Report> getReportSlice(Pageable pageable);

  @Query(value = "select re from Report re join fetch re.review r join fetch re.reportMember mem " +
          "where (mem.nickname like %:keyword%) order by re.createdAt")
  Slice<Report> getReportSliceWithKeyword(@Param(value = "keyword")String keyword, Pageable pageable);

}
