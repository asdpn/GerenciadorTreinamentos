import { Profissional } from "./profissional";
import { Questao } from "./questao";
import { Treinamento } from "./treinamento";

export interface Prova{
    id: number;
    notaMaxima: number;
    notaMinima: number;
    questoes: Questao[];
    profissional: Profissional;
    treinamento: Treinamento;
}