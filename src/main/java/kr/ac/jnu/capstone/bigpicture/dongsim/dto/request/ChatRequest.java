package kr.ac.jnu.capstone.bigpicture.dongsim.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
@RequiredArgsConstructor
@Builder
public class ChatRequest {

    @Schema(description = "채팅 내용", example = "밝은 제가 되고 싶어요.")
    private final String content;
}
