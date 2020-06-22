package com.rasmusrim.football.rest.api.interfaces;

import com.rasmusrim.football.rest.api.models.Color;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends CrudRepository<Color, Long> {

}
