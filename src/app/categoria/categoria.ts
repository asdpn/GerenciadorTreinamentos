import { Treinamento } from "../treinamento/treinamento";

export interface Categoria{
    id: number;
    titulo: string;
    descricao: string;
    treinamentos: Treinamento[];
}