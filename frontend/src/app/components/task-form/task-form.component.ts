import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { TaskService } from '../../services/task.service';

@Component({
  selector: 'app-task-form',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './task-form.component.html'
})
export class TaskFormComponent {
  title = '';
  description = '';

  constructor(private taskService: TaskService) {}

  addTask() {
    this.taskService.addTask({
      title: this.title,
      description: this.description
    }).subscribe(() => {
      this.title = '';
      this.description = '';
      window.location.reload();
    });
  }
}
