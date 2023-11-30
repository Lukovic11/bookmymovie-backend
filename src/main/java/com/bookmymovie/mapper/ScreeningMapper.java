package com.bookmymovie.mapper;

import com.bookmymovie.dto.ScreeningDTO;
import com.bookmymovie.entity.Screening;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel="spring")
public interface ScreeningMapper {

    ScreeningMapper INSTANCE = Mappers.getMapper(ScreeningMapper.class);

    ScreeningDTO screeningToScreeningDTO(Screening screening);
//    Screening screeningDTOToScreening(ScreeningDTO screeningDTO);
    List<ScreeningDTO> toScreeningDTOs(List<Screening> screenings);

}
