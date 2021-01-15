package com.train.taskmanager.repositories;

import com.train.taskmanager.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectInterface extends CrudRepository<Project, Long> {
}
