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
// 인형 요구사항
public class DollRequirement extends EntityBase {

    // 요구사항
    @Column
    private String requirement;

    // 요구사항 전달 여부
    @Column
    private Boolean isSent;

    @ManyToOne
    private Caretaker caretaker;
}