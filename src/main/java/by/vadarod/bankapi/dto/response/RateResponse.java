package by.vadarod.bankapi.dto.response;

import java.time.LocalDateTime;

public record RateResponse(
        Long currentId,
        LocalDateTime dateTime,
        String currentAbbreviation,
        Long currentScale,
        String currentName,
        Double currentOfficialRate
) {
}
