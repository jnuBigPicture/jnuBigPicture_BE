package kr.ac.jnu.capstone.bigpicture.dongsim.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import kr.ac.jnu.capstone.bigpicture.dongsim.enumurate.ChatSenderType;
import kr.ac.jnu.capstone.bigpicture.dongsim.enumurate.ChatType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder
@RequiredArgsConstructor
// 채팅
public class Chat extends EntityBase {

    // 채팅 생성자
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ChatSenderType senderType;

    // 채팅 유형
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ChatType chatType;

    @Column(nullable = false)
    private String content;

    // 관련 보호자 (필수 사항)
    @ManyToOne(optional = false)
    private Caretaker caretaker;

    // 감정 (선택 사항)
    @OneToOne
    private Emotion emotion;
}
