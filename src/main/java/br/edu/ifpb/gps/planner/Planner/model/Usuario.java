package br.edu.ifpb.gps.planner.Planner.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class Usuario {

    @Id
    private int id;

    private String name;
    
    private String password;

    private String email;
    
    //private List<Task> tasks;

    public Usuario() {
    }

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	/*
	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	 */
	@Override
	public String toString() {
		return "Usuario [id= " + id + ","
				+ " name= " + name + ","
				+ " password= " + password + ","
				+ " email= " + email + "]";
	}

	
}