import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { Comentario } from '../../../models/comentario.model';
import { ComentarioService } from '../../../services/comentario.service';

@Component({
  selector: 'app-comentario-list',
  standalone: true,
  imports: [CommonModule, HttpClientModule],
  templateUrl: './comentario-list.component.html',
  styleUrl: './comentario-list.component.css'
})
export class ComentarioListComponent implements OnInit {
  comentarios: Comentario[] = [];

  constructor(private comentarioService: ComentarioService) {}

  ngOnInit(): void {
    this.comentarioService.getComentarios().subscribe({
      next: (data: Comentario[]) => {
        this.comentarios = data;
      },
      error: (error: unknown) => {
        if (error instanceof Error) {
          console.error('Erro ao buscar comentários:', error.message);
        } else {
          console.error('Erro desconhecido:', error);
        }
      }
    });
  }
}
