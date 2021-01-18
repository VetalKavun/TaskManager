package com.train.taskmanager;

import com.train.taskmanager.domain.*;
import com.train.taskmanager.repositories.ProjectRepository;
import com.train.taskmanager.repositories.TaskRepository;
import com.train.taskmanager.repositories.TeamRepository;
import com.train.taskmanager.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class TaskmanagerApplication {


    private UserRepository userRepository;
    private TeamRepository teamRepository;
    private ProjectRepository projectRepository;
    private TaskRepository taskRepository;

    public TaskmanagerApplication(UserRepository userRepository, TeamRepository teamRepository, ProjectRepository projectRepository, TaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.teamRepository = teamRepository;
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(TaskmanagerApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(){
        return args -> {
            Project project1 = new Project();
            project1.setTitle("Test project");
            project1.setDescription("Test description");

            Team team1 = new Team();
            team1.setTitle("DEV");
            team1.setDescription("Dev team");

            Team team2 = new Team();
            team2.setTitle("QA");
            team2.setDescription("QA team");

            Team team3 = new Team();
            team3.setTitle("DBA");
            team3.setDescription("DBA team");

            User user1 = new User();
            user1.setUserName("username1");
            user1.setEmail("email1");
            user1.setTeam(team1);
            user1.setPassword("pas1");
            user1.getUserRoles().add(Role.USER);
            user1.setProject(project1);


            User user2 = new User();
            user2.setUserName("username2");
            user2.setEmail("email2");
            user2.setTeam(team2);
            user2.setPassword("pas2");
            user2.getUserRoles().add(Role.ADMIN);
            user2.setProject(project1);


            User user3 = new User();
            user3.setUserName("username3");
            user3.setEmail("email3");
            user3.setTeam(team1);
            user3.setPassword("pas3");
            user3.getUserRoles().add(Role.USER);
            user3.setProject(project1);




            Task task1 = new Task();
            task1.setTitle("Task_1");
            task1.setDescription("description for task_1");
            task1.setEstimate("3");
            task1.setProject(project1);
            task1.setStart_time(LocalDateTime.now());
            task1.getUsers().add(user1);
            task1.getUsers().add(user3);


            Task task2 = new Task();
            task2.setTitle("Task_2");
            task2.setDescription("description for task_2");
            task2.setEstimate("8");
            task2.setProject(project1);
            task2.setStart_time(LocalDateTime.now());
            task2.getUsers().add(user1);
            task2.getUsers().add(user3);


            Task task3 = new Task();
            task3.setTitle("Task_3");
            task3.setDescription("description for task_3");
            task3.setEstimate("6");
            task3.setProject(project1);
            task3.setStart_time(LocalDateTime.now());
            task3.getUsers().add(user2);


            user1.getTasks().add(task1);
            user1.getTasks().add(task2);
            user2.getTasks().add(task3);
            user3.getTasks().add(task2);
            user3.getTasks().add(task1);

            project1.getUsers().add(user1);
            project1.getUsers().add(user2);
            project1.getUsers().add(user3);
            project1.getTasks().add(task1);
            project1.getTasks().add(task3);
            project1.getTasks().add(task3);

            team1.getUsers().add(user1);
            team1.getUsers().add(user3);
            team2.getUsers().add(user2);

            projectRepository.save(project1);


            taskRepository.save(task1);
            taskRepository.save(task2);
            taskRepository.save(task3);

            teamRepository.save(team1);
            teamRepository.save(team2);
            teamRepository.save(team3);
            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);





        };
    }

}
