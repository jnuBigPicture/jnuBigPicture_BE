package kr.ac.jnu.capstone.bigpicture.dongsim.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;

@MappedSuperclass
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class EntityBase {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @CreationTimestamp
    @Column
    private LocalDateTime createdAt;
}
