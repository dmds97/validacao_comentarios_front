import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-comentario-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './comentario-form.component.html',
  styleUrl: './comentario-form.component.css'
})
export class ComentarioFormComponent {}