package com.in28minutes.springboot.myfirstwebapp.todo;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Todo {

	@Id
	@SequenceGenerator(
			name = "todo_sequence",
			sequenceName = "todo_sequence",
			allocationSize = 1
	)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "student_sequence")
	private int id;

	@Column(name="username")
	private String username;

	@Column(name="description")
	private String	description;

	@Column(name="targetDate")
	private LocalDate targetDate;

	@Column(name="done")
	private boolean done;
	
	public Todo() {
		
	}

	public Todo(int id, String username, String description, LocalDate targetDate, boolean done) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.targetDate = targetDate;
		this.done = done;
	}
	public Todo(String username, String description, LocalDate targetDate, boolean done) {
		this.username = username;
		this.description = description;
		this.targetDate = targetDate;
		this.done = done;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	@Override
	public String toString() {
		return "Todo [id=" + id + ", username=" + username + ", description=" + description + ", targetDate="
				+ targetDate + ", done=" + done + "]";
	}
}
