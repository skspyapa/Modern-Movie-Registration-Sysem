package lk.ijse.dep.movie.dao;

import lk.ijse.dep.movie.entity.RegisterMovie;
import lk.ijse.dep.movie.entity.RegisterMoviePK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterMovieDAO extends JpaRepository<RegisterMovie, RegisterMoviePK> {

}
