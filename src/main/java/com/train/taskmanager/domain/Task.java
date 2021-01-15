package com.train.taskmanager.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id", nullable = false)
    private Long id;
    @Column(name = "description", nullable = false, length = 16777215)
    private String description;
    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @OneToOne
    @JoinTable(name = "usercreator_task",
        joinColumns = {@JoinColumn(name = "task_id", referencedColumnName = "task_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")}
    )
    private User userCreator;

    @Column(name = "estimate", nullable = false)
    private String estimate;
    @Column(name = "spent_time")
    private LocalDateTime spent_time;
    @Column(name = "start_time")
    private LocalDateTime start_time;
    @Column(name = "finish_time")
    private LocalDateTime finish_time;

    @OneToOne
    @JoinTable(name = "userreviewer_task",
            joinColumns = {@JoinColumn(name = "task_id", referencedColumnName = "task_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")}
    )
    private User userReviewer;

    @ManyToMany(mappedBy = "tasks")
    private Set<User> users = new HashSet<>();

    @ElementCollection(targetClass = Status.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "task_status", joinColumns = @JoinColumn(name = "task_id"))
    @Enumerated(EnumType.STRING)
    private Set<Status> status = new HashSet<>();

    @Column(name = "last_update", nullable = false)
    private LocalDateTime lastUpdate;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUserCreator() {
        return userCreator;
    }

    public void setUserCreator(User userCreator) {
        this.userCreator = userCreator;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public void setStatus(Set<Status> status) {
        this.status = status;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getEstimate() {
        return estimate;
    }

    public void setEstimate(String estimate) {
        this.estimate = estimate;
    }

    public LocalDateTime getSpent_time() {
        return spent_time;
    }

    public void setSpent_time(LocalDateTime spent_time) {
        this.spent_time = spent_time;
    }

    public LocalDateTime getStart_time() {
        return start_time;
    }

    public void setStart_time(LocalDateTime start_time) {
        this.start_time = start_time;
    }

    public LocalDateTime getFinish_time() {
        return finish_time;
    }

    public void setFinish_time(LocalDateTime finish_time) {
        this.finish_time = finish_time;
    }

    public User getUserReviewer() {
        return userReviewer;
    }

    public void setUserReviewer(User userReviewer) {
        this.userReviewer = userReviewer;
    }

    public Set<Status> getStatus() {
        return status;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
