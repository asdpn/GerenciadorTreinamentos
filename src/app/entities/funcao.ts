import { Permissao } from "./enums/permissao.enum";
import { Profissional } from "./profissional";

export interface Funcao{
    id: number;
    titulo: string;
    descricao: string;
    permissao: Permissao;
    profissionais: Profissional[];
}