package com.black.personalCal.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.black.personalCal.model.Task;
import com.black.personalCal.model.TaskStatus;
import com.black.personalCal.model.TaskType;

import jakarta.annotation.PostConstruct;

@Repository
public class TaskCollectionRepository {

    private final List<Task> taskList = new ArrayList<>();

    public TaskCollectionRepository() {

    }

    public List<Task> findAll() {
        return taskList;
    }

    public Optional<Task> findById(Integer id) {
        return taskList.stream().filter(t -> t.id().equals(id)).findFirst();
    }

    public void save(Task task) {
        taskList.removeIf(c -> c.id().equals(task.id()));
        taskList.add(task);
    }

    public boolean existsById(Integer id) {
        return taskList.stream().filter(t -> t.id().equals(id)).count() == 1;
    }

    @PostConstruct
    private void init() {
        for (int i = 0; i < 3; i++) {
            Task t = new Task(
                    i+1,
                    "Create Endpoint for Contract Agreement "+(i+1),
                    "Create endpoints for contract Agreement of jocker project",
                    TaskStatus.IDEA,
                    TaskType.FREELANCE_TASK,
                    LocalDateTime.now(),
                    null);
            taskList.add(t);
        }
    }

    
}