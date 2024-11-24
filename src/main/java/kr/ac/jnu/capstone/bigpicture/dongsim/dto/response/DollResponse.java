package kr.ac.jnu.capstone.bigpicture.dongsim.dto.response;

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
public class DollResponse {

    private final String modelName;
    private final String dollName;
    private final Long volumeLevel;
    private final Long batteryLevel;
    private final String ipv4Address;
}

