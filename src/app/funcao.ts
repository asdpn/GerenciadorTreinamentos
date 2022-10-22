import { Permissao } from "./permissao.enum";
import { Profissional } from "./profissional";

export interface Funcao{
    id: number;
    descricao: string;
    permissao: Permissao;
    profissionais: Profissional[];
}