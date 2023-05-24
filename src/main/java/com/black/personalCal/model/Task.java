package com.black.personalCal.model;

import java.time.LocalDateTime;

public record Task(
    Integer id,
    String title,
    String desc,
    TaskStatus status,
    TaskType taskType,
    LocalDateTime dateCreated,
    LocalDateTime dateUpdated

){}