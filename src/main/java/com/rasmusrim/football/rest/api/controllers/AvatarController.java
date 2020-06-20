package com.rasmusrim.football.rest.api.controllers;

import com.rasmusrim.football.rest.api.interfaces.AvatarRepository;
import com.rasmusrim.football.rest.api.models.Avatar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
@CrossOrigin(origins = "*")
public class AvatarController {

    @Autowired
    AvatarRepository avatarRepository;

    @GetMapping(value = "/avatar/{id}")
    public @ResponseBody Iterable<Avatar> getAvatars(@PathVariable(name = "id") long playerId) {
        return avatarRepository.findByPlayerId(playerId);
    }
}
