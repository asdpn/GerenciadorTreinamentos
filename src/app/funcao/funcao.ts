import { Permissao } from "../permissao.enum";
import { Profissional } from "../profissional/profissional";

export interface Funcao{
    id: number;
    titulo: string;
    descricao: string;
    permissao: Permissao;
    profissionais: Profissional[];
}