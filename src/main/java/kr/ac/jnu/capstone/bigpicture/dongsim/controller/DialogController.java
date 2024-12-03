package kr.ac.jnu.capstone.bigpicture.dongsim.controller;

import kr.ac.jnu.capstone.bigpicture.dongsim._common.api.ResponseEntityBuilder;
import kr.ac.jnu.capstone.bigpicture.dongsim._common.api.body.ApiResponseBody;
import kr.ac.jnu.capstone.bigpicture.dongsim._common.auth.AuthorizedEndpointContext;
import kr.ac.jnu.capstone.bigpicture.dongsim.dto.request.DialogRequest;
import kr.ac.jnu.capstone.bigpicture.dongsim.dto.response.ChatResponse;
import kr.ac.jnu.capstone.bigpicture.dongsim.enumurate.ChatSenderType;
import kr.ac.jnu.capstone.bigpicture.dongsim.enumurate.ChatType;
import kr.ac.jnu.capstone.bigpicture.dongsim.service.ChatService;
import kr.ac.jnu.capstone.bigpicture.dongsim.service.EmotionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DialogController {

    private final ChatService chatService;
    private final EmotionService emotionService;

    @PostMapping("/dialog")
    public ResponseEntity<ApiResponseBody<String>> createDialog(@RequestBody DialogRequest request) {
        log.warn("#### request = {}", request);
        ChatResponse childChat = chatService.createChat(new AuthorizedEndpointContext(1L), ChatType.CHILD_DOLL_TALK,
            ChatSenderType.child, request.getOriginalText());
        chatService.createChat(new AuthorizedEndpointContext(1L), ChatType.CHILD_DOLL_TALK,
            ChatSenderType.doll, request.getGeneratedText());

        emotionService.saveEmotion(chatService.getChat(childChat.getId()), request.getEmotion());

        return ResponseEntityBuilder.ok("");
    }

}
