package com.bookmymovie.serviceImpl;

import com.bookmymovie.repository.ScreeningRepository;
import com.bookmymovie.dto.ScreeningDTO;
import com.bookmymovie.entity.Screening;
import com.bookmymovie.mapper.ScreeningMapper;
import com.bookmymovie.service.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ScreeningServiceImpl implements ScreeningService {

    @Autowired
    private ScreeningRepository screeningRepository;
    @Autowired
    private ScreeningMapper screeningMapper;


    @Override
    public List<ScreeningDTO> findAll() {
        List<ScreeningDTO> screenings=screeningMapper.toScreeningDTOs(screeningRepository.findAll());
        return screenings;
    }

    @Override
    public List<ScreeningDTO> findByDate(LocalDate date) {
        List<ScreeningDTO> screenings=screeningMapper.toScreeningDTOs(screeningRepository.findByDate(date));
        return screenings;
    }

    @Override
    public List<ScreeningDTO> findByMovieId(Long movieId) {
        List<ScreeningDTO> screenings=screeningMapper.toScreeningDTOs(screeningRepository.findByMovie_Id(movieId));
        return screenings;
    }

    @Override
    public void save(Screening screening) {
        screeningRepository.save(screening);
    }

    @Override
    public void deleteById(Long id) {
        screeningRepository.deleteById(id);
    }

    @Override
    public void deleteByMovieId(Long movieId) {
        screeningRepository.deleteByMovie_Id(movieId);
    }

    @Override
    public void deleteByMovieHallId(Long movieHallId) {
        screeningRepository.deleteByMovieHall_Id(movieHallId);
    }

    @Override
    public void deleteByDate(LocalDate date) {
        screeningRepository.deleteByDate(date);
    }
}
