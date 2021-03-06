package com.projet.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.todo.entities.Todo;
import com.projet.todo.repository.TodoRepository;

@Service
public class TodoService implements ITodoService {

	@Autowired
	TodoRepository todoRepository;
	
	
    public List<Todo> findAll() {

        return (List<Todo>) todoRepository.findAll();
    }


	@Override
	public void save(Todo td) {
		// TODO Auto-generated method stub
		todoRepository.save(td);
		
	}
	
	@Override
	public void delete(int id) {
        todoRepository.deleteById(id);
    }


	@Override
	public Todo update(int id,Todo todo) {
		// TODO Auto-generated method stub
		todo.setId(id);
		return todoRepository.save(todo);
	}
}
