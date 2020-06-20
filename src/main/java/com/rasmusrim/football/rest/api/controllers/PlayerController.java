package com.rasmusrim.football.rest.api.controllers;

import com.rasmusrim.football.rest.api.interfaces.PlayerRepository;
import com.rasmusrim.football.rest.api.models.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/player")
@CrossOrigin(origins = "*")
public class PlayerController {

    @Autowired
    PlayerRepository playerRepository;

    @GetMapping
    public @ResponseBody Iterable<Player> getCountries() {
        return playerRepository.findAll();
    }
}
