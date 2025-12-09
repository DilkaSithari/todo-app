import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { TaskService } from '../../services/task.service';

@Component({
  selector: 'app-task-form',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './task-form.component.html',
  styleUrls: ['./task-form.component.css']
})
export class TaskFormComponent {

  title = '';
  description = '';

  constructor(private taskService: TaskService) {}

  addTask() {
    if (!this.title) return;

    this.taskService.addTask({
      title: this.title,
      description: this.description
    }).subscribe(() => {

      this.title = '';
      this.description = '';
      this.taskService.triggerRefresh();
    });
  }

}
