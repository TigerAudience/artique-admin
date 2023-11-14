package com.artique.artiqueadmin.service;

import com.artique.artiqueadmin.entity.*;
import com.artique.artiqueadmin.repository.MemberRepository;
import com.artique.artiqueadmin.repository.ReportRepository;
import com.artique.artiqueadmin.repository.ReviewRepository;
import com.artique.artiqueadmin.repository.ThumbsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.artique.artiqueadmin.dto.report.ReportResponse.*;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReportService {
  private final ReportRepository reportRepository;
  private final ReviewRepository reviewRepository;
  private final MemberRepository memberRepository;
  private final ThumbsRepository thumbsRepository;

  public ReportDetail getDetail(Long reportId){
    Report report = reportRepository.findById(reportId)
            .orElseThrow(()->new RuntimeException("invalid report id"));
    return ReportDetail.of(report,report.getReview());
  }

  public ReportViewList getReports(int page,int size,String keyword){
    PageRequest pageRequest = PageRequest.of(page,size);
    Slice<Report> reports;
    if(keyword==null)
      reports = reportRepository.getReportSlice(pageRequest);
    else
      reports = reportRepository.getReportSliceWithKeyword(keyword,pageRequest);
    return ReportViewList.of(reports);
  }
  public Long getReportCount(){
    return reportRepository.count();
  }

  @Transactional
  public void reportSuccess(Long reportId, ReportType reportType){
    //report 성공 시, member 제제 처리(member count 증가, 제제 대상일 때 정지기간 설정), report 삭제 처리
    Report report = reportRepository.findById(reportId)
            .orElseThrow(()->new RuntimeException("invalid report id"));
    Review review = report.getReview();
    Member member = memberRepository.findById(review.getMember().getId())
            .orElseThrow(()->new RuntimeException("invalid member id"));

    if(reportType.warnMember()) {
      restrictMember(member);
      deleteReviewAndReports(review);
    }
    else {
      spoiler(review);
      deleteReport(report);
    }
  }

  @Transactional
  public void reportFail(Long reportId){
    //report 실패 시, report 만 삭제 처리
    Report report = reportRepository.findById(reportId)
            .orElseThrow(()->new RuntimeException("invalid report id"));

    deleteReport(report);
  }
  private void spoiler(Review review){
    review.changeSpoiler();
  }
  private void restrictMember(Member member){
    member.increaseBanCount();
    long banDays = 30L;
    if(member.mustBan())
      member.ban(banDays);
  }

  private void deleteReport(Report report){
    reportRepository.delete(report);
  }
  private void deleteReviewAndReports(Review review){
    thumbsRepository.deleteAllByReviewIds(review.getId());
    reportRepository.deleteAllByReviewIds(review.getId());
    reviewRepository.delete(review);
  }
}
