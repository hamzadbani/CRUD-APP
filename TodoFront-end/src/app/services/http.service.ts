import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Todo } from '../model/todo';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private http:HttpClient) { }

  private Url = 'http://localhost:8080/todo/'

  fetchAll():Observable<Todo[]>{
    return this.http.get<Todo[]>(this.Url + 'findall');    
  }
  addTodo(newTodo: Todo):Observable<Todo>{
    return this.http.post<Todo>(this.Url + 'save',newTodo)
  }
  deleteTodo(TodoId: number): Observable<object> {
    return this.http.delete<object>(this.Url + 'delete/'+ TodoId);
  }
  update(TodoId: number,todo:Todo):Observable<Todo>{
    return this.http.put<Todo>(this.Url + 'update/' + TodoId, todo);
  }
}
