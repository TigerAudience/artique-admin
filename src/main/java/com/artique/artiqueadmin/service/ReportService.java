package com.artique.artiqueadmin.service;

import com.artique.artiqueadmin.entity.Member;
import com.artique.artiqueadmin.entity.Report;
import com.artique.artiqueadmin.entity.ReportType;
import com.artique.artiqueadmin.entity.Review;
import com.artique.artiqueadmin.repository.MemberRepository;
import com.artique.artiqueadmin.repository.ReportRepository;
import com.artique.artiqueadmin.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReportService {
  private final ReportRepository reportRepository;
  private final ReviewRepository reviewRepository;
  private final MemberRepository memberRepository;

  @Transactional
  public void reportSuccess(Long reportId, ReportType reportType){
    //report 성공 시, member 제제 처리(member count 증가, 제제 대상일 때 정지기간 설정), report 삭제 처리
    Report report = reportRepository.findById(reportId)
            .orElseThrow(()->new RuntimeException("invalid report id"));
    Review review = reviewRepository.findById(report.getId())
            .orElseThrow(()->new RuntimeException("invalid review id"));
    Member member = memberRepository.findById(review.getMember().getId())
            .orElseThrow(()->new RuntimeException("invalid member id"));

    if(reportType.warnMember())
      restrictMember(member);
    else
      spoiler(review);

    deleteReport(report);
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
}
