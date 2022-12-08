import { Profissional } from "./profissional";
import { Treinamento } from "./treinamento";

export class Turma{

    constructor(public id=0, titulo="", tamanhoMaximo=0, tamanhoMinimo=0, treinamento?: Treinamento, profissionais?: Profissional[]){
        this.Id = id;
        this.titulo =  titulo;
        this.tamanhoMaximo = tamanhoMaximo;
        this.tamanhoMinimo = tamanhoMinimo;
        this.treinamento = treinamento;
        this.profissionais = profissionais;

    }

    public Id: number;
    public titulo: string;
    public tamanhoMaximo: number;
    public tamanhoMinimo: number;
    public treinamento?: Treinamento;
    public profissionais?: Profissional[];

}