import { Component, OnInit } from '@angular/core';
import { TaskService } from '../../services/task.service';
import {CommonModule} from "@angular/common";

@Component({
  selector: 'app-task-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent implements OnInit {

  tasks: any[] = [];

  constructor(private taskService: TaskService) {}

  ngOnInit(): void {
    this.loadTasks();

    this.taskService.refreshNeeded$.subscribe(() => {
      this.loadTasks();
    });
  }

  loadTasks() {
    this.taskService.getTasks().subscribe(data => {
      this.tasks = data;
    });
  }

  markDone(id: number) {
    this.taskService.markAsDone(id).subscribe(() => {
      this.taskService.triggerRefresh();
    });
  }
}
