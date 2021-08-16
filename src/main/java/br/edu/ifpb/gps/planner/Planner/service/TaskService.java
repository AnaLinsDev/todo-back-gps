package br.edu.ifpb.gps.planner.Planner.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.gps.planner.Planner.model.Task;
import br.edu.ifpb.gps.planner.Planner.repository.TaskRepository;


@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Transactional
    public Task createTask(Task task){
        try {
            
              //task.setId(null == taskRepository.findMaxId()? 0 : taskRepository.findMaxId() + 1);
              taskRepository.save(task);
              return task;

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

                    Task TaskToBeUpdate = taskRepository.findById(task.getId()).get();
                    TaskToBeUpdate.setTitle(task.getTitle());
                    TaskToBeUpdate.setDescription(task.getDescription());
                    TaskToBeUpdate.setStatus(task.getStatus());
                    TaskToBeUpdate.setDate(task.getDate());
                    taskRepository.save(TaskToBeUpdate);
                
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

                taskRepository.deleteById(task.getId());
                
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

          taskRepository.deleteAll();
          return "All Task record deleted successfully.";
                
    }
}