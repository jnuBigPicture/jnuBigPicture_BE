package kr.ac.jnu.capstone.bigpicture.dongsim.service;

import java.time.LocalDate;
import java.util.List;
import kr.ac.jnu.capstone.bigpicture.dongsim._common.auth.AuthorizedEndpointContext;
import kr.ac.jnu.capstone.bigpicture.dongsim.dto.response.ChatResponse;
import kr.ac.jnu.capstone.bigpicture.dongsim.enumurate.ChatSenderType;
import kr.ac.jnu.capstone.bigpicture.dongsim.enumurate.ChatType;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService {

    // TODO: Implement this method
    @Override
    public List<ChatResponse> getChats(AuthorizedEndpointContext context, ChatType chatType,
        LocalDate date) {
        return List.of();
    }

    // TODO: Implement this method
    @Override
    public ChatResponse createChat(AuthorizedEndpointContext context, ChatType chatType,
        ChatSenderType senderType, String content) {
        return null;
    }
}
