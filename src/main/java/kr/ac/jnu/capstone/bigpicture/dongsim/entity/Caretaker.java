package kr.ac.jnu.capstone.bigpicture.dongsim.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;
import java.util.List;
import kr.ac.jnu.capstone.bigpicture.dongsim.dto.request.CaretakerUpdateRequest;
import kr.ac.jnu.capstone.bigpicture.dongsim.dto.response.CaretakerResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder
@RequiredArgsConstructor
// 보호자
public class Caretaker extends EntityBase {

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
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

    // 인형 사용자화 문장
    @OneToMany(mappedBy = "caretaker")
    private List<DollPersonalize> dollPersonalizes;

    // 인형 요구사항
    @OneToMany(mappedBy = "caretaker")
    private List<DollRequirement> dollRequirements;

    // 채팅
    @OneToMany(mappedBy = "caretaker")
    private List<Chat> chats;

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
