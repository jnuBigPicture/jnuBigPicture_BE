package kr.ac.jnu.capstone.bigpicture.dongsim.service;

import kr.ac.jnu.capstone.bigpicture.dongsim.entity.Chat;
import kr.ac.jnu.capstone.bigpicture.dongsim.entity.Emotion;
import kr.ac.jnu.capstone.bigpicture.dongsim.repository.EmotionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EmotionService {

    private final EmotionRepository emotionRepository;

    @Transactional
    public void saveEmotion(Chat chat, String emotion) {
        Emotion emotionEntity = Emotion.builder()
                .emotion(emotion)
                .chat(chat)
                .build();

        chat.setEmotion(emotionRepository.save(emotionEntity));
    }
}
