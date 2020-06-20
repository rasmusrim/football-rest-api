package com.rasmusrim.football.rest.api.controllers;

import com.rasmusrim.football.rest.api.interfaces.GoalsRepository;
import com.rasmusrim.football.rest.api.models.Goals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
@CrossOrigin(origins = "*")
public class GoalsController {

    @Autowired
    GoalsRepository goalsRepository;

    @GetMapping(value = "/goals/{id}")
    public @ResponseBody
    Goals getGoals(@PathVariable(name = "id") long playerId) {
        return goalsRepository.findByPlayerId(playerId).get(0);
    }
}