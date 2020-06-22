package com.rasmusrim.football.rest.api;

import com.github.javafaker.Faker;
import com.rasmusrim.football.rest.api.interfaces.AvatarRepository;
import com.rasmusrim.football.rest.api.interfaces.ColorRepository;
import com.rasmusrim.football.rest.api.interfaces.GoalsRepository;
import com.rasmusrim.football.rest.api.interfaces.PlayerRepository;
import com.rasmusrim.football.rest.api.models.Avatar;
import com.rasmusrim.football.rest.api.models.Color;
import com.rasmusrim.football.rest.api.models.Goals;
import com.rasmusrim.football.rest.api.models.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    AvatarRepository avatarRepository;

    @Autowired
    GoalsRepository goalsRepository;

    @Autowired
    ColorRepository colorRepository;

    Faker faker = new Faker();

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }

    @PostConstruct
    private void initializeDb() {
        addColors();
        addPlayers();


    }

    private void addColors() {
        List<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Blue");
        colors.add("Yellow");
        colors.add("Green");
        colors.add("Indigo");

        for (String colorName : colors) {
            Color color = new Color(colorName);
            colorRepository.save(color);

        }

    }

    private void addPlayers() {
        for (int i = 0; i < 11; i++) {
            Player player = new Player();
            player.setFirstName(faker.name().firstName());
            player.setLastName(faker.name().lastName());

            long colorId = Math.round(Math.random() * 4) + 1;
            Color color = colorRepository.findById(colorId).get();
            player.setFavoriteColor(color);

            playerRepository.save(player);

            Avatar avatar = new Avatar();
            avatar.setAvatar(faker.avatar().image());
            avatar.setPlayer(player);

            avatarRepository.save(avatar);

            Goals goals = new Goals();
            goals.setGoals((int) (Math.random() * 80));
            goals.setPlayer(player);
            goalsRepository.save(goals);
        }


    }


}
