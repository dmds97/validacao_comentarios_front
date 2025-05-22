export interface Comentario {
  id?: number;               // opcional ao criar
  autor: string;
  texto: string;
  criadoEm?: string | Date;  // pode ser string (ISO) ou Date
}
