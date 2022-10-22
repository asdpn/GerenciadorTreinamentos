import { Funcao } from "./funcao";
import { TipoProfissional } from "./tipoProfissional.enum";

export interface Profissional{
    id: number;
    nomeCompleto: string;
    tipoProfissional: TipoProfissional;
    empresa: string;
    email: string;
    telefone: string;
    senha: string;
    funcao: Funcao;
}