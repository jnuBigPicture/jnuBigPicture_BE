package kr.ac.jnu.capstone.bigpicture.dongsim._common.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@JsonNaming(SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class ApiResponseBody<T> {

    private final String status;
    private final T data;
}
