package com.rasmusrim.football.rest.api.controllers;

import com.rasmusrim.football.rest.api.interfaces.ColorRepository;
import com.rasmusrim.football.rest.api.models.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
@CrossOrigin(origins = "*")
public class ColorController {

    @Autowired
    ColorRepository colorRepository;

    @GetMapping(value = "/color/{id}")
    public @ResponseBody
    Color getColor(@PathVariable(name = "id") long colorId) {
        return colorRepository.findById(colorId).get();
    }
}