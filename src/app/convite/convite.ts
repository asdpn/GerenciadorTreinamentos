import { Treinamento } from "../treinamento/treinamento";

export interface Convite{
    id: number;
    localLink: string;
    dataHora: Date;
    treinamento: Treinamento;
}