package kr.ac.jnu.capstone.bigpicture.dongsim.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
// 하루 채팅 요약
public class ChatSummaryOfDay extends EntityBase {

    // 질의응답 일자
    @Column
    private LocalDate chatsDate;

    // 요약 내용
    @Column
    private String summary;
}
