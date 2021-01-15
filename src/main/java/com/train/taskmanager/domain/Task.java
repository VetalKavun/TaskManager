package com.train.taskmanager.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    @Column(name = "user_creator_id", nullable = false)
    private Long userCreatorID;
    @Column(name = "estimate", nullable = false)
    private String estimate;
    @Column(name = "spent_time")
    private LocalDateTime spent_time;
    @Column(name = "start_time")
    private LocalDateTime start_time;
    @Column(name = "finish_time")
    private LocalDateTime finish_time;
    @Column(name = "user_reviewer_id")
    private Long userReviewerId;
    @Column(name = "status", nullable = false)
    private Status status;
    @Column(name = "last_update", nullable = false)
    private LocalDateTime lastUpdate;
    @Column(name = "project_id", nullable = false)
    private Long projectId;

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

    public Long getUserCreatorID() {
        return userCreatorID;
    }

    public void setUserCreatorID(Long userCreatorID) {
        this.userCreatorID = userCreatorID;
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

    public Long getUserReviewerId() {
        return userReviewerId;
    }

    public void setUserReviewerId(Long userReviewerId) {
        this.userReviewerId = userReviewerId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
