package be.hogent.task.service;

import lombok.Data;

@Data
public class Task {
    private String id;

    private String description;

    private String plannedTime;
}
