package com.rasmusrim.football.rest.api.controllers;

import com.rasmusrim.football.rest.api.interfaces.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping(value = "/player")
@CrossOrigin(origins = "*")
public class PlayerController {

    @Autowired
    PlayerRepository playerRepository;

    @GetMapping
    public @ResponseBody Set<Long> getPlayers() {

        var players = playerRepository.findAll();

        Set<Long> playerIds = new HashSet<>();
        for (var player : players) {
            playerIds.add(player.getId());

        }

        return playerIds;
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody Map<String, String> getPlayer(@PathVariable(name = "id") long playerId) {

        var player = playerRepository.findById(playerId).get();

        Map<String, String> returnValue = new HashMap<>();

        returnValue.put("firstName", player.getFirstName());
        returnValue.put("lastName", player.getLastName());

        return returnValue;
    }

}
