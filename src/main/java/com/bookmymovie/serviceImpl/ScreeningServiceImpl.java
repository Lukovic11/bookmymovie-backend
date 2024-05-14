package com.bookmymovie.serviceImpl;

import com.bookmymovie.entity.Movie;
import com.bookmymovie.entity.MovieHall;
import com.bookmymovie.exceptions.BadRequestException;
import com.bookmymovie.exceptions.NotFoundException;
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
        if(movieId==null){
            throw new BadRequestException("Movie id cannot be null.");
        }
        movieRepository.findById(movieId)
                .orElseThrow(()->new NotFoundException("Movie with the id of "+movieId+" not found."));
        return screeningMapper.toScreeningDTOs(screeningRepository.findByMovie_Id(movieId)
                .orElseThrow(()->new NotFoundException("Screenings not found")));
    }

    @Override
    public ScreeningDTO findByDateAndTimeAndMovie_Id(LocalDate date, LocalTime time, Long movieId) {
        if(movieId==null){
            throw new BadRequestException("Movie id cannot be null.");
        }
        if(date==null){
            throw new BadRequestException("Date cannot be null.");
        }
        if(time==null){
            throw new BadRequestException("Time id cannot be null.");
        }
        movieRepository.findById(movieId)
                .orElseThrow(()->new NotFoundException("Movie with the id of "+movieId+" not found."));
        return screeningMapper.screeningToScreeningDTO(screeningRepository.findByDateAndTimeAndMovie_Id(date, time, movieId).
                orElseThrow(()->new NotFoundException("Screening not found.")));
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
        if(id==null){
            throw new BadRequestException("Screening id cannot be null.");
        }
        screeningRepository.findById(id).orElseThrow(()->new NotFoundException("Screening with the id of "+id+" not found"));
        screeningRepository.deleteById(id);
    }

    @Override
    public void deleteByMovieId(Long movieId) {
        if(movieId==null){
            throw new BadRequestException("Movie id cannot be null.");
        }
        movieRepository.findById(movieId)
                .orElseThrow(()->new NotFoundException("Movie with the id of "+movieId+" not found."));
        screeningRepository.findByMovie_Id(movieId)
                .orElseThrow(()->new NotFoundException("Screening not found"));
        screeningRepository.deleteByMovie_Id(movieId);
    }

    @Override
    public void deleteByMovieHallId(Long movieHallId) {
        if(movieHallId==null){
            throw new BadRequestException("Movie Hall id cannot be null.");
        }
        movieRepository.findById(movieHallId)
                .orElseThrow(()->new NotFoundException("Movie Hall with the id of "+movieHallId+" not found"));
        screeningRepository.deleteByMovieHall_Id(movieHallId);
    }

    @Override
    public void deleteByDate(LocalDate date) {
        if(date==null){
            throw new BadRequestException("Date cannot be null.");
        }
        screeningRepository.deleteByDate(date);
    }

    @Override
    public void generateScreeningsForNext3Months() {
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusMonths(3);
        List<Movie> movies = movieRepository.findByIsPlayingTrue()
                .orElseThrow(()->new NotFoundException("There are no movies currently playing."));
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
        if(movie==null || date==null){
            throw new BadRequestException("Data cannot be null.");
        }
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
        if(date==null || time==null){
            throw new BadRequestException("Data cannot be null.");
        }
        LocalDateTime now= LocalDateTime.now();
        LocalDateTime screening = date.atTime(time);
        return now.isAfter(screening);
    }

}
