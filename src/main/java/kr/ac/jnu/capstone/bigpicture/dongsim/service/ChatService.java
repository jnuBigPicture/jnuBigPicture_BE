package kr.ac.jnu.capstone.bigpicture.dongsim.service;

import java.time.LocalDate;
import java.util.List;
import kr.ac.jnu.capstone.bigpicture.dongsim._common.auth.AuthorizedEndpointContext;
import kr.ac.jnu.capstone.bigpicture.dongsim.dto.response.ChatResponse;
import kr.ac.jnu.capstone.bigpicture.dongsim.enumurate.ChatSenderType;
import kr.ac.jnu.capstone.bigpicture.dongsim.enumurate.ChatType;

public interface ChatService {

    List<ChatResponse> getChats(AuthorizedEndpointContext context, ChatType chatType, LocalDate date);
    ChatResponse createChat(AuthorizedEndpointContext context, ChatType chatType, ChatSenderType senderType, String content);
}
