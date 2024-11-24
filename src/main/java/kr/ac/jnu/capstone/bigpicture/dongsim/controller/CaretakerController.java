package kr.ac.jnu.capstone.bigpicture.dongsim.controller;

import kr.ac.jnu.capstone.bigpicture.dongsim._common.api.ApiResponse;
import kr.ac.jnu.capstone.bigpicture.dongsim._common.api.ApiResponseBody;
import kr.ac.jnu.capstone.bigpicture.dongsim.dto.request.CaretakerUpdateRequest;
import kr.ac.jnu.capstone.bigpicture.dongsim.dto.response.CaretakerResponse;
import kr.ac.jnu.capstone.bigpicture.dongsim.service.CaretakerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/caretaker")
@RequiredArgsConstructor
public class CaretakerController {

    private final CaretakerService caretakerService;

    // 보호자 정보 확인
    @GetMapping
    public ResponseEntity<ApiResponseBody<CaretakerResponse>> getCaretaker(@RequestParam Long id) {
        return ApiResponse.ok(caretakerService.getCaretaker(id));
    }

    // 보호자 수정
    @PutMapping
    public ResponseEntity<ApiResponseBody<CaretakerResponse>> updateCaretaker(@RequestParam Long id, @RequestBody CaretakerUpdateRequest updateRequest) {
        return ApiResponse.ok(caretakerService.updateCaretaker(id, updateRequest));
    }
}
