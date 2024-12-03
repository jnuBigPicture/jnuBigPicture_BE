package kr.ac.jnu.capstone.bigpicture.dongsim.controller;

import kr.ac.jnu.capstone.bigpicture.dongsim._common.api.ResponseEntityBuilder;
import kr.ac.jnu.capstone.bigpicture.dongsim._common.api.body.ApiResponseBody;
import kr.ac.jnu.capstone.bigpicture.dongsim.dto.request.DialogRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class DialogController {

    @PostMapping("/dialog")
    public ResponseEntity<ApiResponseBody<String>> createDialog(@RequestBody DialogRequest request) {
        log.warn("#### request = {}", request);
        return ResponseEntityBuilder.ok("");
    }

}
