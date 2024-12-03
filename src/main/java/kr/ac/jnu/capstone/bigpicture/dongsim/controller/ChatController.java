package kr.ac.jnu.capstone.bigpicture.dongsim.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.time.LocalDate;
import java.util.List;
import kr.ac.jnu.capstone.bigpicture.dongsim._common.api.ResponseEntityBuilder;
import kr.ac.jnu.capstone.bigpicture.dongsim._common.api.body.ApiResponseBody;
import kr.ac.jnu.capstone.bigpicture.dongsim._common.auth.AuthorizedEndpoint;
import kr.ac.jnu.capstone.bigpicture.dongsim._common.auth.AuthorizedEndpointContext;
import kr.ac.jnu.capstone.bigpicture.dongsim._common.swagger.FailApiResponses;
import kr.ac.jnu.capstone.bigpicture.dongsim.dto.request.ChatRequest;
import kr.ac.jnu.capstone.bigpicture.dongsim.dto.response.ChatResponse;
import kr.ac.jnu.capstone.bigpicture.dongsim.enumurate.ChatSenderType;
import kr.ac.jnu.capstone.bigpicture.dongsim.enumurate.ChatType;
import kr.ac.jnu.capstone.bigpicture.dongsim.exception.ErrorCode;
import kr.ac.jnu.capstone.bigpicture.dongsim.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat")
@RequiredArgsConstructor
@Tag(name = "Chat", description = "채팅 조회 및 생성 API")
public class ChatController {

    private final ChatService chatService;

    @Operation(
        summary = "인형 요구사항 대화 조회",
        responses = @ApiResponse(responseCode = "200", useReturnTypeSchema = true))
    @FailApiResponses({
        ErrorCode.AUTHORIZATION_FAILED})
    @GetMapping("/doll-requirement-talk")
    public ResponseEntity<ApiResponseBody<List<ChatResponse>>> getDollRequirementTalkChats(
        @AuthorizedEndpoint AuthorizedEndpointContext authorizedEndpointContext,
        @Parameter(description = "조회할 하루 단위 날짜", example = "2024-10-20")
            @RequestParam("date")  @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date)
    {
        return ResponseEntityBuilder.ok(chatService.getChats(authorizedEndpointContext, ChatType.DOLL_REQUIREMENT_TALK, date));
    }

    @Operation(
        summary = "아이 인형간 대화 조회",
        responses = @ApiResponse(responseCode = "200", useReturnTypeSchema = true))
    @FailApiResponses({
        ErrorCode.AUTHORIZATION_FAILED})
    @GetMapping("/child-doll-talk")
    public ResponseEntity<ApiResponseBody<List<ChatResponse>>> getChildDollTalkChats(
        @Parameter(description = "조회할 하루 단위 날짜", example = "2024-10-20")
            @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date)
    {
        return ResponseEntityBuilder.ok(chatService.getChats(new AuthorizedEndpointContext(1L), ChatType.CHILD_DOLL_TALK, date));
    }

    @Operation(
        summary = "인형 요구사항 대화 생성",
        responses = @ApiResponse(responseCode = "201", useReturnTypeSchema = true))
    @FailApiResponses({
        ErrorCode.AUTHORIZATION_FAILED})
    @PutMapping("/doll-requirement-talk/{sender}")
    public ResponseEntity<ApiResponseBody<ChatResponse>> createDollRequirementTalkChat(
        @Parameter(hidden = true) @AuthorizedEndpoint AuthorizedEndpointContext authorizedEndpointContext,
        @Parameter(description = "대화 생성자")
            @PathVariable("sender") ChatSenderType senderType,
        @Parameter(description = "대화 내용")
            @RequestBody ChatRequest request)
    {
        return ResponseEntityBuilder.created(chatService.createChat(authorizedEndpointContext, ChatType.DOLL_REQUIREMENT_TALK, senderType, request.getContent()));
    }

    @Operation(
        summary = "아이 인형간 대화 생성",
        responses = @ApiResponse(responseCode = "201", useReturnTypeSchema = true))
    @FailApiResponses({
        ErrorCode.AUTHORIZATION_FAILED})
    @PutMapping("/child-doll-talk/{sender}")
    public ResponseEntity<ApiResponseBody<ChatResponse>> createChildDollTalkChat(
        @Parameter(hidden = true) @AuthorizedEndpoint AuthorizedEndpointContext authorizedEndpointContext,
        @Parameter(description = "대화 생성자")
            @PathVariable("sender") ChatSenderType senderType,
        @Parameter(description = "대화 내용")
            @RequestBody ChatRequest request)
    {
        return ResponseEntityBuilder.created(chatService.createChat(authorizedEndpointContext, ChatType.CHILD_DOLL_TALK, senderType, request.getContent()));
    }
}
