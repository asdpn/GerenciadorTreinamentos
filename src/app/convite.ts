import { Treinamento } from "./treinamento";

export interface Convite{
    id: number;
    localLink: string;
    dataHora: Date;
    treinamento: Treinamento;
}