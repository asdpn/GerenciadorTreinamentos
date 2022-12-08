import { Treinamento } from "./treinamento";

export class Categoria{

    constructor(public id=0, titulo="", descricao="", treinamentos?: Treinamento[]){
        this.Id = id;
        this.titulo =  titulo;
        this.descricao = descricao;
        this.treinamentos = treinamentos;

    }

    public Id: number;
    public titulo: string;
    public descricao?: string;
    public treinamentos?: Treinamento[];

}