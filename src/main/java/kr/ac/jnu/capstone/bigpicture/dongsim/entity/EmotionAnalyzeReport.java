package kr.ac.jnu.capstone.bigpicture.dongsim.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder
@RequiredArgsConstructor
// 감정분석 리포트
public class EmotionAnalyzeReport extends EntityBase {

    // 감정 분석 날짜범위
    @Column
    private String emotionAnalysisInterval;

    // 분석 시작일
    @Column
    private LocalDate analyzeStartDate;


    // 분석 종료일
    @Column
    private LocalDate analyzeEndDate;

    // 감정 통계
    @Column
    private String emotionStatistics;

    // 심리상태 분석 통계
    @Column
    private String mentalStatistics;

    // 보호자 조언
    @Column
    private String caretakerAdvice;

    @ManyToOne
    private Caretaker caretaker;

}
