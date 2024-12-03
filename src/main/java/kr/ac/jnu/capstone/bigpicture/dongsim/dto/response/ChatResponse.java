package kr.ac.jnu.capstone.bigpicture.dongsim.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import kr.ac.jnu.capstone.bigpicture.dongsim.entity.Chat;
import kr.ac.jnu.capstone.bigpicture.dongsim.enumurate.ChatSenderType;
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
public class ChatResponse {

    @Schema(description = "채팅 ID", example = "5")
    private final Long id;

    @Schema(description = "채팅 생성 일시", example = "2024-10-20 17:39:21", type = "string")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private final LocalDateTime createdAt;

    @Schema(description = "채팅 생성자 유형", example = "child")
    private final ChatSenderType senderType;

    @Schema(description = "채팅 생성자 이름", example = "빵빵이")
    private final String senderName;

    @Schema(description = "채팅 내용", example = "밝은 제가 되고 싶어요.")
    private final String content;

    public static ChatResponse from(Chat chat) {

        var builder = ChatResponse.builder()
            .id(chat.getId())
            .createdAt(chat.getCreatedAt())
            .senderType(chat.getSenderType())
            .content(chat.getContent());

        switch(chat.getSenderType()) {
            case child:
                return builder
                    .senderName(chat.getCaretaker().getChildName())
                    .build();
            case caretaker:
                return builder
                    .senderName(chat.getCaretaker().getNickname())
                    .build();
            case doll:
                return builder
                    .senderName(chat.getCaretaker().getDoll().getDollName())
                    .build();
            default:
                throw new RuntimeException("채팅 생성자 유형이 올바르지 않습니다.");
        }
    }
}
