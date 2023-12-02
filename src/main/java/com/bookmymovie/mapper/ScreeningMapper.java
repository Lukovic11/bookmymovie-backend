package com.bookmymovie.mapper;

import com.bookmymovie.dto.ScreeningDTO;
import com.bookmymovie.entity.Screening;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel="spring")
public interface ScreeningMapper {


    ScreeningDTO screeningToScreeningDTO(Screening screening);
    List<ScreeningDTO> toScreeningDTOs(List<Screening> screenings);

}
