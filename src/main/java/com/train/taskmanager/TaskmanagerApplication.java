package com.train.taskmanager;

import com.train.taskmanager.domain.Role;
import com.train.taskmanager.domain.Team;
import com.train.taskmanager.domain.User;
import com.train.taskmanager.repositories.TeamRepository;
import com.train.taskmanager.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TaskmanagerApplication {


    private UserRepository userRepository;
    private TeamRepository teamRepository;

    public TaskmanagerApplication(UserRepository userRepository, TeamRepository teamRepository) {
        this.userRepository = userRepository;
        this.teamRepository = teamRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(TaskmanagerApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(){
        return args -> {
            Team team1 = new Team();
            team1.setTitle("DEV");
            team1.setDescription("Dev team");

            User user1 = new User();
            user1.setUserName("username1");
            user1.setEmail("email1");
            user1.setTeam(team1);
            user1.setPassword("pas1");
            user1.getUserRoles().add(Role.USER);

            team1.getUsers().add(user1);
            teamRepository.save(team1);
            userRepository.save(user1);





        };
    }

}
