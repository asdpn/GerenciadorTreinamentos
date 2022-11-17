import { Profissional } from "../profissional/profissional";
import { Questao } from "../questao/questao";
import { Treinamento } from "../treinamento/treinamento";

export interface Prova{
    id: number;
    titulo: string;
    notaMaxima: number;
    notaMinima: number;
    questoes: Questao[];
    profissional: Profissional;
    treinamento: Treinamento;
}