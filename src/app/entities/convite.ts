import { Treinamento } from "./treinamento";

export interface Convite{
    id: number;
    titulo: string;
    localLink: string;
    dataHora: Date;
    treinamento: Treinamento;
}