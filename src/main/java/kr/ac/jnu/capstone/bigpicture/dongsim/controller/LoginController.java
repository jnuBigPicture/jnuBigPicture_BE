package kr.ac.jnu.capstone.bigpicture.dongsim.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.ac.jnu.capstone.bigpicture.dongsim._common.api.ResponseEntityBuilder;
import kr.ac.jnu.capstone.bigpicture.dongsim._common.api.body.ApiResponseBody;
import kr.ac.jnu.capstone.bigpicture.dongsim.dto.request.LoginRequest;
import kr.ac.jnu.capstone.bigpicture.dongsim.dto.response.LoginResponse;
import kr.ac.jnu.capstone.bigpicture.dongsim.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
@RequiredArgsConstructor
@Tag(name = "Auth", description = "로그인 API")
public class LoginController {

    private final LoginService loginService;

    @Operation(
        summary = "로그인",
        responses = @ApiResponse(
            responseCode = "200",
            headers = @Header(
                name = "Authorization",
                description = "생성된 토큰 반환, \"Bearer { JWT }\" 형식",
                schema = @Schema(
                    type = "string",
                    format = "jwt"
                )
            )
        )
    )
    @PostMapping
    public ResponseEntity<ApiResponseBody<LoginResponse>> login(
        @Parameter(description = "로그인 정보")
            @RequestBody LoginRequest request)
    {
        LoginResponse response = loginService.login(request);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + response.getToken());
        return ResponseEntityBuilder.okWithHeaders(response, headers);
    }
}
