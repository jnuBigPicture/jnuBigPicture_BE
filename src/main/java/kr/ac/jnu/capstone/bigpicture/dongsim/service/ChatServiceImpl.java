package kr.ac.jnu.capstone.bigpicture.dongsim.service;

import java.time.LocalDate;
import java.util.List;
import kr.ac.jnu.capstone.bigpicture.dongsim._common.auth.AuthorizedEndpointContext;
import kr.ac.jnu.capstone.bigpicture.dongsim.dto.response.ChatResponse;
import kr.ac.jnu.capstone.bigpicture.dongsim.entity.Caretaker;
import kr.ac.jnu.capstone.bigpicture.dongsim.entity.Chat;
import kr.ac.jnu.capstone.bigpicture.dongsim.enumurate.ChatSenderType;
import kr.ac.jnu.capstone.bigpicture.dongsim.enumurate.ChatType;
import kr.ac.jnu.capstone.bigpicture.dongsim.repository.CaretakerRepository;
import kr.ac.jnu.capstone.bigpicture.dongsim.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final ChatRepository chatRepository;
    private final CaretakerRepository caretakerRepository;

    @Override
    public List<ChatResponse> getChats(AuthorizedEndpointContext context, ChatType chatType,
        LocalDate date) {
        return chatRepository.findAll().stream()
//            .filter(c -> c.getChatType().equals(chatType))
//            .filter(c -> c.getCreatedAt().toLocalDate().equals(date))
            .map(ChatResponse::from)
            .toList();
    }

    @Override
    public ChatResponse createChat(AuthorizedEndpointContext context, ChatType chatType,
        ChatSenderType senderType, String content) {
        Chat chat = Chat.builder()
            .chatType(chatType)
            .senderType(senderType)
            .content(content)
            .caretaker(getCaretaker(context))
            .build();
        return ChatResponse.from(chatRepository.save(chat));
    }

    @Override
    public Chat getChat(Long chatId) {
        return chatRepository.findById(chatId).orElseThrow(() -> new RuntimeException("채팅을 찾지 못했습니다."));
    }

    private Caretaker getCaretaker(AuthorizedEndpointContext context) {
        return caretakerRepository.findById(context.getId()).orElseThrow(() -> new RuntimeException("보호자를 찾지 못했습니다."));
    }
}
