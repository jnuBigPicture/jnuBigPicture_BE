package kr.ac.jnu.capstone.bigpicture.dongsim.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@JsonNaming(SnakeCaseStrategy.class)
@Getter
@RequiredArgsConstructor
@Builder
public class CaretakerUpdateRequest {


    private final String socialId;
    private final String businessModelInfo;
    private final String theme;
    private final String emotionAnalysisInterval;
}
