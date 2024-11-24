package kr.ac.jnu.capstone.bigpicture.dongsim.repository;

import kr.ac.jnu.capstone.bigpicture.dongsim.entity.Doll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DollRepository extends JpaRepository<Doll, Long> {

}
