package kr.ac.jnu.capstone.bigpicture.dongsim.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class CaretakerUpdateRequest {

    @Schema(description = "소셜 ID", example = "92981000192")
    private String socialId;

    @Schema(description = "비즈니스 모델 구독정보", example = "Premium")
    private String businessModelInfo;

    @Schema(description = "앱 테마", example = "Light")
    private String theme;

    @Schema(description = "현재 감정분석 날짜 범위", example = "1Day(형식 추후 변경예정)")
    private String emotionAnalysisInterval;
}
