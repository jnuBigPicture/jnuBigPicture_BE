package kr.ac.jnu.capstone.bigpicture.dongsim.exception;

public class EntityNotFoundException extends BusinessException {

    public <T> EntityNotFoundException(Class<T> classType) {
        super("존재하지 않는 " + classType.getSimpleName() + " Entity 입니다.");
    }

}
