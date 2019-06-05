package lk.ijse.dep.movie.business.custom.impl;

import lk.ijse.dep.movie.business.custom.ActorBO;
import lk.ijse.dep.movie.dao.ActorDAO;
import lk.ijse.dep.movie.dto.ActorDTO;

import lk.ijse.dep.movie.entity.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional
public class ActorBOImpl implements ActorBO {
    @Autowired
    public ActorDAO actorDAO;


    @Override
    public List<ActorDTO> getAll() throws Exception {
        List<ActorDTO> collect = actorDAO.findAll().stream().map(actor -> new ActorDTO(actor.getId(), actor.getName(), actor.getAge())).collect(Collectors.toList());
        return collect;
    }

    @Override
    public boolean remove(Integer dtoId) throws Exception {
        actorDAO.deleteById(dtoId);
        return true;
    }

    @Override
    public ActorDTO get(Integer dtoId) throws Exception {
        Actor actor = actorDAO.getOne(dtoId);
        return new ActorDTO(actor.getId(),actor.getName(),actor.getAge());
    }

    @Override
    public boolean update(ActorDTO dtoId) throws Exception {
        actorDAO.save(new Actor(dtoId.getId(),dtoId.getName(),dtoId.getAge()));
        return true;
    }

    @Override
    public boolean save(ActorDTO dto) throws Exception {
        actorDAO.save(new Actor(dto.getId(),dto.getName(),dto.getAge()));
        return true;
    }

    @Override
    public int getMaxId() throws Exception {
        return actorDAO.getTopActorByOrderByIdDesc().getId();
    }
}
