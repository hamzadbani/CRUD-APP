package com.projet.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.todo.entities.Todo;
import com.projet.todo.repository.TodoRepository;
import com.projet.todo.service.ITodoService;


@RestController
@RequestMapping("/todo")
public class TodoController {

	    @Autowired
        private ITodoService ItodoService;
	    //@Autowired
		TodoRepository todoRepository;

		
		@GetMapping("/findall")
		public List<Todo> fetchAll(){
			
			return this.ItodoService.findAll();
		}
		
		//@PostMapping("/add")
		//public ResponseEntity<?> addTodo(@RequestBody Todo todo) {
			
		//	return new ResponseEntity<>(this.todoRepository.save(todo),HttpStatus.CREATED);
		//}

		
		@PostMapping("/save")
		public void addTodo(@RequestBody Todo todo) {
			ItodoService.save(todo);
		//this.ItodoService.save(todo);
		}
		
		//@DeleteMapping("delete/{id}")
		//public ResponseEntity<?> deleteTodo(@PathVariable Integer id){
		//	if(this.todoRepository.findById(id).isPresent()) {
		//		this.todoRepository.deleteById(id);
		//		return new ResponseEntity<>(HttpStatus.OK);
		//	}
		//	else {
		//		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		//	}
		//}
		
		@DeleteMapping("delete/{id}")
		public void deleteTodo(@PathVariable("id") int id){
			ItodoService.delete(id);
		}
		
		//@PutMapping("update/{id}")
		//public ResponseEntity<?> updateTodo(@PathVariable Integer id, @RequestBody Todo todo ){
			
		//	if(this.todoRepository.findById(id).isPresent()) {
				
		//		todo.setId(id);
		//		return new ResponseEntity<>(this.todoRepository.save(todo),HttpStatus.OK);
		//	}
		//	else {
				
		//		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		//	}
		//}
		@PutMapping("update/{id}")
		public void UpdateTodo(@PathVariable("id")Integer id,@RequestBody Todo todo) {
			ItodoService.update(id,todo);
		}
}


