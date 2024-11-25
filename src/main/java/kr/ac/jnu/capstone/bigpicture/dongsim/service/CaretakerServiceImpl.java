package kr.ac.jnu.capstone.bigpicture.dongsim.service;

import java.time.LocalDate;
import kr.ac.jnu.capstone.bigpicture.dongsim._common.auth.AuthorizedEndpointContext;
import kr.ac.jnu.capstone.bigpicture.dongsim.dto.request.CaretakerUpdateRequest;
import kr.ac.jnu.capstone.bigpicture.dongsim.dto.request.ChildUpdateRequest;
import kr.ac.jnu.capstone.bigpicture.dongsim.dto.response.CaretakerResponse;
import kr.ac.jnu.capstone.bigpicture.dongsim.dto.response.ChildResponse;
import kr.ac.jnu.capstone.bigpicture.dongsim.entity.Caretaker;
import kr.ac.jnu.capstone.bigpicture.dongsim.exception.EntityNotFoundException;
import kr.ac.jnu.capstone.bigpicture.dongsim.repository.CaretakerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CaretakerServiceImpl implements CaretakerService {

    private final CaretakerRepository caretakerRepository;

    @Override
    @Transactional(readOnly = true)
    public CaretakerResponse getCaretaker(AuthorizedEndpointContext context) {
        return caretakerRepository.findById(context.getId())
            .map(Caretaker::toCaretakerResponse)
            .orElseThrow(() -> new EntityNotFoundException(Caretaker.class));
    }

    @Override
    @Transactional
    public CaretakerResponse updateCaretaker(AuthorizedEndpointContext context, CaretakerUpdateRequest updateRequest) {
        Caretaker caretaker = caretakerRepository.findById(context.getId())
            .orElseThrow(() -> new EntityNotFoundException(Caretaker.class));
        caretaker.update(updateRequest);
        return caretaker.toCaretakerResponse();
    }

    // TODO: implement
    @Override
    @Transactional(readOnly = true)
    public ChildResponse getChild(AuthorizedEndpointContext context) {
        return ChildResponse.builder()
            .childName("")
            .childBirthDate(LocalDate.now())
            .build();
    }

    // TODO: implement
    @Override
    @Transactional
    public ChildResponse updateChild(AuthorizedEndpointContext context,
        ChildUpdateRequest updateRequest) {
        return ChildResponse.builder()
            .childName("")
            .childBirthDate(LocalDate.now())
            .build();
    }
}