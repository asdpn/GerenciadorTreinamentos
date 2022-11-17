import { Categoria } from "../categoria/categoria";
import { Convite } from "../convite/convite";
import { Profissional } from "../profissional/profissional";
import { Prova } from "../prova/prova";
import { StatusTreinamento } from "../statusTreinamento.enum";
import { Turma } from "../turma/turma";

export interface Treinamento{
    id: number;
    titulo: string;
    descricao: string;
    motivoReprovacao: string;
    statusTreinamento: StatusTreinamento;
    categoria: Categoria;
    turma: Turma;
    convite: Convite;
    provas: Prova[];
    profissionais: Profissional[];
}

