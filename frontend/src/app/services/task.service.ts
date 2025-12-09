import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  private apiUrl = 'http://localhost:8080/api/tasks';

  constructor(private http: HttpClient) {}

  getTasks() {
    return this.http.get<any[]>(this.apiUrl);
  }

  addTask(task: any) {
    return this.http.post(this.apiUrl, task);
  }

  markDone(id: number) {
    return this.http.put(`${this.apiUrl}/${id}/done`, {});
  }
}
