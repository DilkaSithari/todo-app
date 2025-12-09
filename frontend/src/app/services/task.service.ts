import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  private apiUrl = 'http://localhost:8080/api/tasks';

  private refreshNeeded = new BehaviorSubject<void>(undefined);
  refreshNeeded$ = this.refreshNeeded.asObservable();

  constructor(private http: HttpClient) {}

  getTasks(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }

  addTask(task: any): Observable<any> {
    return this.http.post(this.apiUrl, task);
  }

  markAsDone(id: number): Observable<any> {
    return this.http.put(`${this.apiUrl}/${id}/done`, {});
  }

  deleteTask(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/${id}`);
  }


  triggerRefresh() {
    this.refreshNeeded.next();
  }
}
