import { Component, OnInit } from '@angular/core';
import { Todo } from 'src/app/model/todo';
import { HttpService } from 'src/app/services/http.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-show-all',
  templateUrl: './show-all.component.html',
  styleUrls: ['./show-all.component.css']
})
export class ShowAllComponent implements OnInit {

  listOfTodos !: Todo[];
  newTodo: Todo = new Todo();
  TodoToEdit: Todo = new Todo();
  editIndex !:number;
  constructor(private httpService:HttpService, private router:Router) { }

  ngOnInit(): void {

    this.httpService.fetchAll().subscribe(
      (response : Todo[])=>{
        this.listOfTodos = response
      }
    )
  }
  saveTodo(){
    this.httpService.addTodo(this.newTodo).subscribe(
      (response) =>{
        console.log(response)
         window.location.href="/show"
       // this.router.navigate(['/home'])
      },(error)=>{
        console.log(error)
      }
    )
  }
confirmDelete(id: number){
    if(confirm("Are you sure to delete ")) {
  this.httpService.deleteTodo(id).subscribe();
  window.location.href="/show"
  }
}
editTodo(index: number) {
  this.TodoToEdit.id = this.listOfTodos[index].id;
  this.TodoToEdit.task = this.listOfTodos[index].task;
  this.TodoToEdit.date = this.listOfTodos[index].date;
  this.TodoToEdit.done = this.listOfTodos[index].done;
  this.editIndex = index;
}

updateTodo() {
  this.httpService.update( this.TodoToEdit.id ,this.TodoToEdit).subscribe();
    window.location.href="/show"
  }
}
