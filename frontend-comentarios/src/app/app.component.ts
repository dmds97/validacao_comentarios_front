import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ComentarioFormComponent } from './components/comentario-form/comentario-form.component';
import { ComentarioListComponent } from './components/comentario-list/comentario-list.component';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    CommonModule,
    RouterOutlet,
    ComentarioFormComponent,
    ComentarioListComponent
  ],
  templateUrl: './app.component.html',
})
export class AppComponent {
  title = 'frontend-comentarios';
}