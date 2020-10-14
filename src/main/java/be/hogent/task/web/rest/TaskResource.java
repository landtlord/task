package be.hogent.task.web.rest;

import be.hogent.task.business.TaskEntity;
import be.hogent.task.service.Task;
import be.hogent.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class TaskResource {

    @Autowired
    private TaskService taskService;

    @GetMapping("/task/{id}")
    public ResponseEntity<Task> getById(Long id) {
        return ResponseEntity.ok(taskService.getById(id));
    }

    @PostMapping("/task")
    public ResponseEntity<Task> save(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.save(task));
    }

    @GetMapping("/task")
    public ResponseEntity<List<Task>> getAll() {
        return ResponseEntity.ok(taskService.getAll());
    }
}
