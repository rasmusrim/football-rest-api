package com.rasmusrim.football.rest.api.interfaces;

import com.rasmusrim.football.rest.api.models.Goals;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoalsRepository extends CrudRepository<Goals, Long> {
    List<Goals> findByPlayerId(Long playerId);
}
