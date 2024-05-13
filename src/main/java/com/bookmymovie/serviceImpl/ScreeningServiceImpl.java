package com.bookmymovie.serviceImpl;

import com.bookmymovie.entity.Movie;
import com.bookmymovie.entity.MovieHall;
import com.bookmymovie.repository.MovieHallRepository;
import com.bookmymovie.repository.MovieRepository;
import com.bookmymovie.repository.ScreeningRepository;
import com.bookmymovie.dto.ScreeningDTO;
import com.bookmymovie.entity.Screening;
import com.bookmymovie.mapper.ScreeningMapper;
import com.bookmymovie.service.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class ScreeningServiceImpl implements ScreeningService {

    @Autowired
    private ScreeningRepository screeningRepository;
    @Autowired
    private ScreeningMapper screeningMapper;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private MovieHallRepository movieHallRepository;


    @Override
    public List<ScreeningDTO> findAll() {
        return screeningMapper.toScreeningDTOs(screeningRepository.findAll());
    }

    @Override
    public List<ScreeningDTO> findByMovieId(Long movieId) {
        return screeningMapper.toScreeningDTOs(screeningRepository.findByMovie_Id(movieId));
    }

    @Override
    public ScreeningDTO findByDateAndTimeAndMovie_Id(LocalDate date, LocalTime time, Long movieId) {
        return screeningMapper.screeningToScreeningDTO(screeningRepository.findByDateAndTimeAndMovie_Id(date, time, movieId));
    }

    @Override
    public void save(Screening screening) {
        screeningRepository.save(screening);
    }

    @Override
    public void deleteAllInBatch() {
        screeningRepository.deleteAllInBatch();
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

    @Override
    public void generateScreeningsForNext3Months() {
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusMonths(3);
        List<Movie> movies = movieRepository.findByIsPlayingTrue();
        List<MovieHall> movieHalls = movieHallRepository.findAll();

        LocalTime[] timeSlots = {LocalTime.of(13, 0), LocalTime.of(17, 0), LocalTime.of(21, 0)};
        int timeSlotIndex = 0;

        for (LocalDate date = startDate; date.isBefore(endDate); date = date.plusDays(1)) {
            for (Movie movie : movies) {
                if (!existsByMovieAndDate(movie, date)) {
                    MovieHall movieHall = movieHalls.get((int) (Math.random() * movieHalls.size()));
                    for (LocalTime time : timeSlots) {
                        Screening screening = new Screening();
                        screening.setMovie(movie);
                        screening.setMovieHall(movieHall);
                        screening.setDate(date);
                        screening.setTime(time);
                        save(screening);
                    }
                }
            }
        }
    }

    @Override
    public boolean existsByMovieAndDate(Movie movie, LocalDate date) {
        return screeningRepository.existsByMovieAndDate(movie, date);
    }


    @Scheduled(cron = "0 0 * * * ?")
    private void deleteFinishedScreenings(){
        List<Screening> screenings=screeningRepository.findAll();
        for(Screening s:screenings){
            if(isScreeningOver(s.getDate(),s.getTime())){
                deleteById(s.getId());
            }
        }
    }

    private boolean isScreeningOver(LocalDate date, LocalTime time){
        LocalDateTime now= LocalDateTime.now();
        LocalDateTime screening = date.atTime(time);
        return now.isAfter(screening);
    }

}
