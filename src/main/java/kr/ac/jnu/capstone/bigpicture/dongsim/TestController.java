package kr.ac.jnu.capstone.bigpicture.dongsim;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping
    public ResponseEntity<String> test() {
        log.info("Dongsim application started - info");
        log.debug("Dongsim application started - debug");
        log.info("Dongsim application ended - info");
        return ResponseEntity.ok("/api/test called");
    }
}
