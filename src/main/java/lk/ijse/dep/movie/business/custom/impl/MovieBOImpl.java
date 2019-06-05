package lk.ijse.dep.movie.business.custom.impl;

import lk.ijse.dep.movie.business.custom.MovieBO;
import lk.ijse.dep.movie.dao.MovieDAO;
import lk.ijse.dep.movie.dto.MovieDTO;
import lk.ijse.dep.movie.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional
public class MovieBOImpl implements MovieBO {
@Autowired
public MovieDAO movieDAO;

    @Override
    public List<MovieDTO> getAll() throws Exception {
        List<MovieDTO> collect = movieDAO.findAll().stream().map(movie -> new MovieDTO(movie.getId(), movie.getName())).collect(Collectors.toList());
        return collect;
    }

    @Override
    public boolean save(MovieDTO dto) throws Exception {
        movieDAO.save(new Movie(dto.getId(),dto.getName()));
        return true;
    }

    @Override
    public boolean remove(Integer dtoId) throws Exception {
        movieDAO.deleteById(dtoId);
        return true;
    }

    @Override
    public boolean update(MovieDTO dtoId) throws Exception {
        movieDAO.save(new Movie(dtoId.getId(),dtoId.getName()));
        return true;
    }

    @Override
    public MovieDTO get(Integer dtoId) throws Exception {
        Movie movie = movieDAO.getOne(dtoId);
        return new MovieDTO(movie.getId(),movie.getName());
    }

    @Override
    public int getMaxId() throws Exception {
        return movieDAO.getTopMovieByOrderByIdDesc().getId();
    }
}
