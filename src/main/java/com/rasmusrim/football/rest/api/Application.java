package com.rasmusrim.football.rest.api;

import com.github.javafaker.Faker;
import com.rasmusrim.football.rest.api.interfaces.AvatarRepository;
import com.rasmusrim.football.rest.api.interfaces.GoalsRepository;
import com.rasmusrim.football.rest.api.interfaces.PlayerRepository;
import com.rasmusrim.football.rest.api.models.Avatar;
import com.rasmusrim.football.rest.api.models.Goals;
import com.rasmusrim.football.rest.api.models.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Application {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    AvatarRepository avatarRepository;

    @Autowired
    GoalsRepository goalsRepository;

    Faker faker = new Faker();

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }

    @PostConstruct
    private void initializeDb() {
        addPlayers();


    }

    private void addPlayers() {
        for (int i = 0; i < 11; i++) {
            var player = new Player();
            player.setFirstName(faker.name().firstName());
            player.setLastName(faker.name().lastName());

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
