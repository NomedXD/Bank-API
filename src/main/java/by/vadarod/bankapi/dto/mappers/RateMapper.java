package by.vadarod.bankapi.dto.mappers;

import by.vadarod.bankapi.domain.Rate;
import by.vadarod.bankapi.dto.response.RateApiResponse;
import by.vadarod.bankapi.dto.response.RateResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RateMapper {

    @Mapping(source = "Cur_ID", target = "currentId")
    @Mapping(source = "Date", target = "dateTime")
    @Mapping(source = "Cur_Abbreviation", target = "currentAbbreviation")
    @Mapping(source = "Cur_Scale", target = "currentScale")
    @Mapping(source = "Cur_Name", target = "currentName")
    @Mapping(source = "Cur_OfficialRate", target = "currentOfficialRate")
    Rate toRate(RateApiResponse rateApiResponse);

    RateResponse toRateResponse(Rate rate);
}
