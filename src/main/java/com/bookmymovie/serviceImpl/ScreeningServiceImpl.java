package com.bookmymovie.serviceImpl;

import com.bookmymovie.dao.ScreeningRepository;
import com.bookmymovie.entity.Screening;
import com.bookmymovie.service.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ScreeningServiceImpl implements ScreeningService {

    private ScreeningRepository screeningRepository;

    @Autowired
    public ScreeningServiceImpl(ScreeningRepository screeningRepository) {
        this.screeningRepository = screeningRepository;
    }

    @Override
    public List<Screening> findAll() {
        return screeningRepository.findAll();
    }

    @Override
    public List<Screening> findByDate(LocalDate date) {
        return screeningRepository.findByDate(date);
    }

    @Override
    public List<Screening> findByMovieId(Long movieId) {
        return screeningRepository.findByMovie_Id(movieId);
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
