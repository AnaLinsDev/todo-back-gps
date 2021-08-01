package br.edu.ifpb.gps.planner.Planner.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.gps.planner.Planner.model.Task;
import br.edu.ifpb.gps.planner.Planner.model.Usuario;
import br.edu.ifpb.gps.planner.Planner.repository.TaskRepository;


@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Transactional
    public String createTask(Task task){
        try {
            
              task.setId(null == taskRepository.findMaxId()? 0 : taskRepository.findMaxId() + 1);
              taskRepository.save(task);
              return "Task record created successfully.";

        }catch (Exception e){
            throw e;
        }

    }

    public List<Task> readTasks(){
        return taskRepository.findAll();
    }

    @Transactional
    public String updateTask(Task task){
        if (taskRepository.existsById(task.getId())){
            try {
                Optional<Task> Tasks = taskRepository.findById(task.getId());
                Tasks.stream().forEach(s -> {
                    Task TaskToBeUpdate = taskRepository.findById(s.getId()).get();
                    TaskToBeUpdate.setTitle(task.getTitle());
                    TaskToBeUpdate.setDescription(task.getDescription());
                    TaskToBeUpdate.setStatus(task.getStatus());
                    TaskToBeUpdate.setData(task.getData());
                    taskRepository.save(TaskToBeUpdate);
                });
                return "Task record updated.";
            }catch (Exception e){
                throw e;
            }
        }else {
            return "Task does not exists in the database.";
        }
    }

    @Transactional
    public String deleteTask(Task task){
        if (taskRepository.existsById(task.getId())){
            try {
                Optional<Task> tasks = taskRepository.findById(task.getId());
                tasks.stream().forEach(s -> {
                    taskRepository.delete(s);
                });
                return "Task record deleted successfully.";
            }catch (Exception e){
                throw e;
            }

        }else {
            return "Task does not exist";
        }
    }
    
    @Transactional
    public String deleteAllTask(){

        List<Task> tasks = taskRepository.findAll();
        		tasks.stream().forEach(s -> {
                    taskRepository.delete(s);
                });
                return "All Task record deleted successfully.";
                
    }
}