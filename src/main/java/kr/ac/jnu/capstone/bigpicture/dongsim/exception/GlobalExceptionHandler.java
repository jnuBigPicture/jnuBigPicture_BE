package kr.ac.jnu.capstone.bigpicture.dongsim.exception;

import kr.ac.jnu.capstone.bigpicture.dongsim._common.api.ApiResponse;
import kr.ac.jnu.capstone.bigpicture.dongsim._common.api.FailApiResponseBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<FailApiResponseBody> handleBusinessException(BusinessException e) {
        return ApiResponse.fail.notFound(e.getMessage());
    }
}
