import { Treinamento } from "../treinamento/treinamento";

export interface Convite{
    id: number;
    titulo: string;
    localLink: string;
    dataHora: Date;
    treinamento: Treinamento;
}