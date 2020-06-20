package com.rasmusrim.football.rest.api.interfaces;

import com.rasmusrim.football.rest.api.models.Avatar;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvatarRepository extends CrudRepository<Avatar, Long> {
    List<Avatar> findByPlayerId(Long playerId);

}
