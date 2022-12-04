import { Categoria } from "./categoria";
import { Convite } from "./convite";
import { Profissional } from "./profissional";
import { Prova } from "./prova";
import { StatusTreinamento } from "./enums/statusTreinamento.enum";
import { Turma } from "./turma";

export interface Treinamento{
    id: number;
    titulo: string;
    descricao: string;
    statusTreinamento: StatusTreinamento;
    categoria: Categoria;
    turma: Turma;
    convite: Convite;
    provas: Prova[];
    palestrante: Profissional;
}

