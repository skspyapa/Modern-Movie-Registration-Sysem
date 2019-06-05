package lk.ijse.dep.movie.business.custom;

import lk.ijse.dep.movie.business.SuperBO;
import lk.ijse.dep.movie.dto.ActorDTO;

public interface ActorBO extends SuperBO<ActorDTO,Integer> {
int getMaxId() throws Exception;
}
