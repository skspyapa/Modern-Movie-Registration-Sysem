package lk.ijse.dep.movie.business.custom;

import lk.ijse.dep.movie.business.SuperBO;
import lk.ijse.dep.movie.dto.MovieDTO;

public interface MovieBO extends SuperBO<MovieDTO,Integer> {
    int getMaxId() throws Exception;

}
