import { Funcao } from "./funcao";
import { Prova } from "./prova";
import { Treinamento } from "./treinamento";
import { Turma } from "./turma";

export interface Profissional{
    id: number;
    nomeCompleto: string;
    empresa: string;
    email: string;
    telefone: string;
    senha: string;
    funcao: Funcao;
    treinamentos: Treinamento[];
    turmas: Turma[];
    provas: Prova[];
}