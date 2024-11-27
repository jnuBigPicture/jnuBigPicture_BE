package kr.ac.jnu.capstone.bigpicture.dongsim.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder
@RequiredArgsConstructor
// 인형 사용자화
public class DollPersonalize extends EntityBase {

    // 인형 사용자화 문장
    @Column
    private String sentence;

    // 보호자
    @ManyToOne
    private Caretaker caretaker;
}
