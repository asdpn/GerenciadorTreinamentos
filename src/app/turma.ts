import { Profissional } from "./profissional";
import { Treinamento } from "./treinamento";

export interface Turma{
    id: number;
    tamanhoMaximo: number;
    tamanhoMinimo: number;
    treinamento: Treinamento;
    profissionais: Profissional[];
}