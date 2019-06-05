package lk.ijse.dep.movie.dao;

import lk.ijse.dep.movie.entity.Actor;
import lk.ijse.dep.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface MovieDAO extends JpaRepository<Movie,Integer> {
    Movie getTopMovieByOrderByIdDesc()throws Exception;
}
