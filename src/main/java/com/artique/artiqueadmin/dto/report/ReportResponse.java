package com.artique.artiqueadmin.dto.report;

import com.artique.artiqueadmin.entity.Member;
import com.artique.artiqueadmin.entity.ReportType;
import com.artique.artiqueadmin.entity.Review;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class ReportResponse {
  public static class ReportViewList{

  }
  public static class ReportView{
    private Long id;
    private String type;
    private String memberId;
    private String memberNickname;
    private Integer warningCount;

    private LocalDateTime createdAt;
    private Long thumbsUp;
    private String shortReview;
  }
}
