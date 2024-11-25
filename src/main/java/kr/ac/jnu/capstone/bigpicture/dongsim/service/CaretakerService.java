package kr.ac.jnu.capstone.bigpicture.dongsim.service;

import kr.ac.jnu.capstone.bigpicture.dongsim._common.auth.AuthorizedEndpointContext;
import kr.ac.jnu.capstone.bigpicture.dongsim.dto.request.CaretakerUpdateRequest;
import kr.ac.jnu.capstone.bigpicture.dongsim.dto.response.CaretakerResponse;
import kr.ac.jnu.capstone.bigpicture.dongsim.entity.Caretaker;
import kr.ac.jnu.capstone.bigpicture.dongsim.exception.EntityNotFoundException;
import kr.ac.jnu.capstone.bigpicture.dongsim.repository.CaretakerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CaretakerService {

    private final CaretakerRepository caretakerRepository;

    @Transactional(readOnly = true)
    public CaretakerResponse getCaretaker(AuthorizedEndpointContext context) {
        return caretakerRepository.findById(context.getId())
            .map(Caretaker::toCaretakerResponse)
            .orElseThrow(() -> new EntityNotFoundException(Caretaker.class));
    }

    @Transactional
    public CaretakerResponse updateCaretaker(AuthorizedEndpointContext context, CaretakerUpdateRequest updateRequest) {
        Caretaker caretaker = caretakerRepository.findById(context.getId())
            .orElseThrow(() -> new EntityNotFoundException(Caretaker.class));
        caretaker.update(updateRequest);
        return caretaker.toCaretakerResponse();
    }
}
