package br.edu.ifpb.gps.planner.Planner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.gps.planner.Planner.model.Task;
import br.edu.ifpb.gps.planner.Planner.service.TaskService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class TaskController {
	
	@Autowired
    private TaskService taskService;

	@RequestMapping(value = "/task/info", method = RequestMethod.GET)
	public String info() {
		return "App is up...";
	}

    @RequestMapping(value = "/task/createtask", method = RequestMethod.POST)
    public Task createTask(@RequestBody Task task){
        return taskService.createTask(task);
    }

    @RequestMapping(value = "/task/readtasks", method = RequestMethod.GET)
    public List<Task> readTasks(){
        return taskService.readTasks();
    }

    @RequestMapping(value = "/task/updatetask", method = RequestMethod.PUT)
    public String updateTask(@RequestBody Task task){
        return taskService.updateTask(task);
    }

    @RequestMapping(value = "/task/deletetask", method = RequestMethod.DELETE)
    public String deleteTask(@RequestBody Task task){
        return taskService.deleteTask(task);
    }
    
    @RequestMapping(value = "/task/deletealltask", method = RequestMethod.DELETE)
    public String deleteAllTask(){
        return taskService.deleteAllTask();
    }
}
