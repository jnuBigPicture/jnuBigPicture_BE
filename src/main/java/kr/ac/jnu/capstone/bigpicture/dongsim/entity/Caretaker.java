package kr.ac.jnu.capstone.bigpicture.dongsim.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;
import kr.ac.jnu.capstone.bigpicture.dongsim.dto.request.CaretakerUpdateRequest;
import kr.ac.jnu.capstone.bigpicture.dongsim.dto.response.CaretakerResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@JsonNaming(SnakeCaseStrategy.class)
@Getter
@Setter
@SuperBuilder
@RequiredArgsConstructor
public class Caretaker extends EntityBase {

    @Column
    private String nickname;

    @Column
    private String socialId;

    // 비즈니스 모델 구독정보
    @Column
    private String businessModelInfo;

    // 앱 테마
    @Column
    private String theme;

    // 현재 감정분석 날짜 범위
    @Column
    private String emotionAnalysisInterval;

    @Column
    private String childName;

    @Column
    private LocalDate childBirthDate;

    @OneToOne
    private Doll doll;

    public CaretakerResponse toCaretakerResponse() {
        return CaretakerResponse.builder()
            .socialId(socialId)
            .businessModelInfo(businessModelInfo)
            .theme(theme)
            .emotionAnalysisInterval(emotionAnalysisInterval)
            .build();
    }

    public void update(CaretakerUpdateRequest updateRequest) {
        this.socialId = updateRequest.getSocialId();
        this.businessModelInfo = updateRequest.getBusinessModelInfo();
        this.theme = updateRequest.getTheme();
        this.emotionAnalysisInterval = updateRequest.getEmotionAnalysisInterval();
    }
}
