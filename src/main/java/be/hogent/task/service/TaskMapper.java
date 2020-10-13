package be.hogent.task.service;

import be.hogent.task.business.TaskEntity;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface TaskMapper{
    Task toDTO(TaskEntity taskEntity);

    TaskEntity toEntity(Task task);

    default List<Task> toDTO(List<TaskEntity> taskEntities){
        return taskEntities.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
