package be.hogent.task.service;

import be.hogent.task.business.TaskEntity;
import be.hogent.task.business.TaskRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@AllArgsConstructor
public class TaskService {
    @Autowired
    private TaskMapper mapper;

    @Autowired
    private TaskRepo repo;

    @GetMapping("/task/{id}")
    public Task getById(String id) {
        Long longId = Long.parseLong(id);
        Optional<TaskEntity> taskEntity = repo.findById(longId);
        return taskEntity.map(entity -> mapper.toDTO(entity)).orElse(null);
    }

    @PostMapping("/task")
    public Task save(@RequestBody Task task) {
        TaskEntity taskEntity = mapper.toEntity(task);
        TaskEntity savedEntity = repo.save(taskEntity);
        return mapper.toDTO(savedEntity);
    }

    @GetMapping("/task")
    public List<Task> getAll() {
        Iterable<TaskEntity> all = repo.findAll();
        List<TaskEntity> collect = StreamSupport.stream(all.spliterator(), false)
                .collect(Collectors.toList());
        return mapper.toDTO(collect);
    }
}
