package com.projet.todo.entities;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Todo")
public class Todo {

		 @Id
		 @GeneratedValue(strategy = GenerationType.IDENTITY)
	     private Integer id;
		 
	     private String task;
	     
	     private LocalDate Date;
	     private boolean isDone; 
	     
			
		 public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getTask() {
			return task;
		}
		public void setTask(String task) {
			this.task = task;
		}
		public LocalDate getDate() {
			return Date;
		}
		public void setDate(LocalDate date) {
			Date = date;
		}
		public boolean isDone() {
			return isDone;
		}
		public void setDone(boolean isDone) {
			this.isDone = isDone;
		}
		public Todo(Integer id, String task, LocalDate date, boolean isDone) {
			super();
			this.id = id;
			this.task = task;
			Date = date;
			this.isDone = isDone;
		}
		public Todo() {
		    super();
		// TODO Auto-generated constructor stub
	     }
		@Override
		public String toString() {
			return "Todo [id=" + id + ", task=" + task + ", Date=" + Date + ", isDone=" + isDone + "]";
		}
		
	}

