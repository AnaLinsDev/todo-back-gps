package br.edu.ifpb.gps.planner.Planner.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Task {

	@Id
	private int id;

	private String title;

	private String description;

	private String status;

	private Date data;

	@ManyToOne(cascade = { CascadeType.ALL })
	private Usuario usuario;

	public Task() {
	}

	public Task(int id, String title, String description, String status, Date data, Usuario usuario) {
		this.title = title;
		this.description = description;
		this.status = status;
		this.data = data;
		this.usuario = usuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void setUsuario(Usuario usu) {
		this.usuario = usu;
	}

}
