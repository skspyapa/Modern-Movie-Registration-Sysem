package lk.ijse.dep.movie.business.custom.impl;

import lk.ijse.dep.movie.business.custom.RegisterMovieBO;
import lk.ijse.dep.movie.dao.RegisterMovieDAO;
import lk.ijse.dep.movie.dto.RegisterMovieDTO;
import lk.ijse.dep.movie.entity.Movie;
import lk.ijse.dep.movie.entity.RegisterMovie;
import lk.ijse.dep.movie.entity.RegisterMoviePK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional
public class RegisterMovieBOImpl implements RegisterMovieBO {
@Autowired
public RegisterMovieDAO registerMovieDAO;
    @Override
    public List<RegisterMovieDTO> getAll() throws Exception {
        List<RegisterMovieDTO> collect = registerMovieDAO.findAll().stream().map(registerMovie -> new RegisterMovieDTO(registerMovie.getActor().getId(),registerMovie.getMovie().getId(),registerMovie.getRole())).collect(Collectors.toList());
        return collect;
    }

    @Override
    public boolean save(RegisterMovieDTO dto) throws Exception {

        registerMovieDAO.save(new RegisterMovie(dto.getActor(),dto.getMovie(),dto.getRole()));
        return true;
    }

    @Override
    public boolean remove(RegisterMoviePK dtoId) throws Exception {
        return false;
    }

    @Override
    public boolean update(RegisterMovieDTO dtoId) throws Exception {
        return false;
    }

    @Override
    public RegisterMovieDTO get(RegisterMoviePK dtoId) throws Exception {
        return null;
    }
}
