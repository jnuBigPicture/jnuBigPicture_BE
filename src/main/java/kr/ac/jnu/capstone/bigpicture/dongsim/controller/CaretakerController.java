package kr.ac.jnu.capstone.bigpicture.dongsim.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.ac.jnu.capstone.bigpicture.dongsim._common.api.ResponseEntityBuilder;
import kr.ac.jnu.capstone.bigpicture.dongsim._common.api.body.ApiResponseBody;
import kr.ac.jnu.capstone.bigpicture.dongsim._common.auth.AuthorizedEndpoint;
import kr.ac.jnu.capstone.bigpicture.dongsim._common.auth.AuthorizedEndpointContext;
import kr.ac.jnu.capstone.bigpicture.dongsim._common.swagger.FailApiResponses;
import kr.ac.jnu.capstone.bigpicture.dongsim.dto.request.CaretakerUpdateRequest;
import kr.ac.jnu.capstone.bigpicture.dongsim.dto.response.CaretakerResponse;
import kr.ac.jnu.capstone.bigpicture.dongsim.exception.ErrorCode;
import kr.ac.jnu.capstone.bigpicture.dongsim.service.CaretakerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/caretaker")
@RequiredArgsConstructor
@Tag(name = "Caretaker", description = "보호자 정보를 조회하고 수정하는 API")
public class CaretakerController {

    private final CaretakerService caretakerService;

    @Operation(
        summary = "보호자 정보 확인",
        responses = @ApiResponse(responseCode = "200", useReturnTypeSchema = true))
    @FailApiResponses({
        ErrorCode.AUTHORIZATION_FAILED,
        ErrorCode.ENTITY_NOT_FOUND})
    @GetMapping
    public ResponseEntity<ApiResponseBody<CaretakerResponse>> getCaretaker(
        @Parameter(hidden = true) @AuthorizedEndpoint AuthorizedEndpointContext authorizedEndpointContext)
    {
        return ResponseEntityBuilder.ok(caretakerService.getCaretaker(authorizedEndpointContext));
    }

    @Operation(
        summary = "보호자 정보 수정",
        responses = @ApiResponse(responseCode = "200", useReturnTypeSchema = true))
    @FailApiResponses({
        ErrorCode.AUTHORIZATION_FAILED,
        ErrorCode.ENTITY_NOT_FOUND})
    @PutMapping
    public ResponseEntity<ApiResponseBody<CaretakerResponse>> updateCaretaker(
        @Parameter(hidden = true) @AuthorizedEndpoint AuthorizedEndpointContext authorizedEndpointContext,
        @Parameter(description = "보호자 업데이트 정보")
            @RequestBody CaretakerUpdateRequest updateRequest)
    {
        return ResponseEntityBuilder.ok(caretakerService.updateCaretaker(authorizedEndpointContext, updateRequest));
    }
}
