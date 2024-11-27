package kr.ac.jnu.capstone.bigpicture.dongsim.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import kr.ac.jnu.capstone.bigpicture.dongsim.dto.response.DollResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder
@RequiredArgsConstructor
// 인형
public class Doll extends EntityBase {

    // 모델명
    @Column
    private String modelName;

    // 인형 이름
    @Column
    private String dollName;

    // 볼륨 잔량
    @Column
    private Long volumeLevel;

    // 배터리 잔량
    @Column
    private Long batteryLevel;

    // IPv4 주소
    @Column
    private String ipv4Address;

    public DollResponse toDollResponse() {
        return DollResponse.builder()
            .modelName(modelName)
            .dollName(dollName)
            .volumeLevel(volumeLevel)
            .batteryLevel(batteryLevel)
            .ipv4Address(ipv4Address)
            .build();
    }
}
