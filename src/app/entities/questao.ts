import { Prova } from "./prova";

export interface Questao{
    id: number;
    cabecalho: string;
    gabarito: string;
    provas: Prova[];
}