package com.artique.artiqueadmin.dto.report;

import com.artique.artiqueadmin.entity.Member;
import com.artique.artiqueadmin.entity.Report;
import com.artique.artiqueadmin.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Slice;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ReportResponse {
  @AllArgsConstructor
  @Getter
  public static class ReportViewList{
    private List<ReportView> reportViews;
    private int page;
    private int size;
    private boolean hasNext;
    public static ReportViewList of(Slice<Report> reports){
      List<ReportView> reportViews = reports.getContent().stream().map((r)->ReportView.of(r,r.getReview())).toList();
      int size = reports.getSize();
      int page = reports.getPageable().getPageNumber();
      boolean hasNext = reports.hasNext();
      return new ReportViewList(reportViews,page,size,hasNext);
    }
  }
  @AllArgsConstructor
  @Getter
  public static class ReportView{
    /**
     * 1) 신고 리뷰 정보
     *  - 리뷰 기본 정보 (한줄평, 별점, 긴줄평, 공감 수, 리뷰 작성일)
     * 2) 리뷰 작성자 정보
     *  - 닉네임
     *  - 누적 신고 당한 횟수
     * 3) 신고자 정보
     *  - 닉네임
     *  - 누적 신고 횟수
     *  - 신고 일시
     *  - 신고 사유
     */
    private Long reportId;
    private String type;
    private String reportCreatedAt;

    //review
    private Long reviewId;
    private String shortReview;
    private Double starRating;
    private Long thumbsUp;
    private String reviewCreatedAt;

    //member
    private String memberId;
    private String memberNickname;
    private Integer warningCount;

    //report member
    private String reportMemberId;
    private String reportMemberNickname;
    private Integer reportCount;

    public static ReportView of(Report r, Review re){
      Member m = re.getMember();
      Member rm = r.getReportMember();
      String reviewCreatedAt = re.getCreatedAt().format(DateTimeFormatter.ofPattern("MM-dd HH:mm"));
      String reportCreatedAt = r.getCreatedAt().format(DateTimeFormatter.ofPattern("MM-dd HH:mm"));
      return new ReportView(r.getId(),r.getType().getType(),reportCreatedAt,re.getId(),re.getShortReview(),
              re.getStarRating(),re.getThumbsUp(), reviewCreatedAt,m.getId(),m.getNickname(),m.getWarningCount(),
              rm.getId(),rm.getNickname(),rm.getReportCount());
    }
  }
}
