package com.projet.todo.service;

import java.util.List;

import com.projet.todo.entities.Todo;

public interface ITodoService {
	List<Todo> findAll();
	public void save(Todo td);
	public void delete(int id);
	public Todo update(int id,Todo todo);
}
