import { Profissional } from "./profissional";
import { Treinamento } from "./treinamento";

export class Turma{

    constructor(public id=0, titulo="", tamanhoMaximo=0, tamanhoMinimo=0, profissionais = [new Profissional()], treinamentos?: Treinamento[]){
        this.Id = id;
        this.titulo =  titulo;
        this.tamanhoMaximo = tamanhoMaximo;
        this.tamanhoMinimo = tamanhoMinimo;
        this.treinamentos = treinamentos;
        this.profissionais = profissionais;

    }

    public Id: number;
    public titulo: string;
    public tamanhoMaximo: number;
    public tamanhoMinimo: number;
    public profissionais: Profissional[];
    public treinamentos?: Treinamento[];


}