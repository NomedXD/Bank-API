package by.vadarod.bankapi.dto.response;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record RateApiResponse(
        Long Cur_ID,
        LocalDateTime Date,
        String Cur_Abbreviation,
        Long Cur_Scale,
        String Cur_Name,
        Double Cur_OfficialRate
) {
}
