import { Prova } from "../prova/prova";

export interface Questao{
    id: number;
    cabecalho: string;
    gabarito: string;
    provas: Prova[];
}