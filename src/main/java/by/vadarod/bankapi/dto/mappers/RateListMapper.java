package by.vadarod.bankapi.dto.mappers;

import by.vadarod.bankapi.domain.Rate;
import by.vadarod.bankapi.dto.response.RateApiResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = RateMapper.class)
public interface RateListMapper {
    List<Rate> toRateList(List<RateApiResponse> rateApiResponseList);
}
