import { Profissional } from "../profissional/profissional";
import { Treinamento } from "../treinamento/treinamento";

export interface Turma{
    id: number;
    titulo: string;
    tamanhoMaximo: number;
    tamanhoMinimo: number;
    treinamento: Treinamento;
    profissionais: Profissional[];
}
