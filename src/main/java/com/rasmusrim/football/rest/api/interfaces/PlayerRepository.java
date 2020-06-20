package com.rasmusrim.football.rest.api.interfaces;

import com.rasmusrim.football.rest.api.models.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {
}