import { Component, OnInit } from '@angular/core';
import { Comentario } from '../models/comentario.model';
import { ComentarioService } from '../services/comentario.service';

@Component({
  selector: 'app-comentarios',
  templateUrl: './comentarios.component.html',
  styleUrls: ['./comentarios.component.css']
})
export class ComentariosComponent implements OnInit {
  comentarios: Comentario[] = [];

  novoComentario: Comentario = {
    autor: '',
    texto: '',
    criadoEm: new Date()
  };

  constructor(private comentarioService: ComentarioService) {}

  ngOnInit(): void {
    this.carregarComentarios();
  }

  carregarComentarios(): void {
    this.comentarioService.getComentarios().subscribe((dados) => {
      this.comentarios = dados;
    });
  }

  adicionarComentario(): void {
    if (this.novoComentario.autor && this.novoComentario.texto) {
      const comentarioParaSalvar = {
        ...this.novoComentario,
        criadoEm: new Date()
      };

      this.comentarioService.adicionarComentario(comentarioParaSalvar).subscribe((comentarioSalvo) => {
        this.comentarios.push(comentarioSalvo);
        this.novoComentario = { autor: '', texto: '', criadoEm: new Date() };
      });
    }
  }
}