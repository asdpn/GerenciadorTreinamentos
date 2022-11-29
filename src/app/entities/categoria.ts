import { Treinamento } from "./treinamento";

export interface Categoria{
    id: number;
    titulo: string;
    descricao: string;
    treinamentos: Treinamento[];
}