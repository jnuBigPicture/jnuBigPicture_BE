package kr.ac.jnu.capstone.bigpicture.dongsim._common.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiResponse {

    public static <T> ResponseEntity<ApiResponseBody<T>> ok(T data) {
        return ResponseEntity.ok(ApiResponseBody.<T>builder()
            .status("success")
            .data(data)
            .build());
    }

    public static <T> ResponseEntity<ApiResponseBody<T>> created(T data) {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(ApiResponseBody.<T>builder()
                .status("success")
                .data(data)
                .build());
    }

    public static ResponseEntity<Void> noContent() {
        return ResponseEntity.noContent().build();
    }

    public static class fail {

            public static ResponseEntity<FailApiResponseBody> badRequest(String message) {
                return ResponseEntity.badRequest()
                    .body(FailApiResponseBody.builder()
                        .status("fail")
                        .message(message)
                        .build());
            }

            public static ResponseEntity<FailApiResponseBody> notFound(String message) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(FailApiResponseBody.builder()
                        .status("fail")
                        .message(message)
                        .build());
            }

            public static ResponseEntity<FailApiResponseBody> internalServerError(String message) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(FailApiResponseBody.builder()
                        .status("fail")
                        .message(message)
                        .build());
            }
    }

}
