package lk.ijse.dep.movie.dao;

import lk.ijse.dep.movie.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ActorDAO extends JpaRepository<Actor,Integer> {
   Actor getTopActorByOrderByIdDesc()throws Exception;
}
