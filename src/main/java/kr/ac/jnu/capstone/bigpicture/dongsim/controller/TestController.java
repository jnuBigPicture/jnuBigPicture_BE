package kr.ac.jnu.capstone.bigpicture.dongsim.controller;

import kr.ac.jnu.capstone.bigpicture.dongsim.entity.Caretaker;
import kr.ac.jnu.capstone.bigpicture.dongsim.repository.CaretakerRepository;
import kr.ac.jnu.capstone.bigpicture.dongsim.entity.Doll;
import kr.ac.jnu.capstone.bigpicture.dongsim.repository.DollRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor
public class TestController {

    private final CaretakerRepository caretakerRepository;
    private final DollRepository dollRepository;

    @GetMapping
    public ResponseEntity<String> test() {
        log.info("Dongsim application started - info");
        log.debug("Dongsim application started - debug");
        log.info("Dongsim application ended - info");
        return ResponseEntity.ok("/api/test called");
    }

    @GetMapping("/1")
    public ResponseEntity<String> test1() {
        Doll doll = Doll.builder()
            .modelName("model1")
            .dollName("doll1")
            .volumeLevel(100L)
            .batteryLevel(100L)
            .ipv4Address("192.168.0.1")
            .build();
        dollRepository.save(doll);
        Caretaker caretaker = Caretaker.builder()
            .nickname("nickname1")
            .businessModelInfo("businessModelInfo1")
            .theme("theme1")
            .emotionAnalysisInterval("emotionAnalysisInterval1")
            .childName("childName1")
            .childBirthDate(null)
            .doll(doll)
            .build();
        caretakerRepository.save(caretaker);

        return ResponseEntity.ok("/api/test/1 called");
    }
}
