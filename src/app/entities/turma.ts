import { Profissional } from "./profissional";
import { Treinamento } from "./treinamento";

export interface Turma{
    id: number;
    titulo: string;
    tamanhoMaximo: number;
    tamanhoMinimo: number;
    treinamento: Treinamento;
    profissionais: Profissional[];
}
