package by.vadarod.bankapi.exceptions;

import java.time.LocalDate;

public class NoSuchEntityException extends IllegalArgumentException {
    public NoSuchEntityException(Long currentId, LocalDate date) {
        super(String.format("No rate with code current_id=%d found for date=%s. Try load rates firstly", currentId, date));
    }
}
