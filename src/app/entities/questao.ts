import { Prova } from "./prova";

export class Questao{

    constructor(public id=0, cabecalho="",  gabarito="", provas?: Prova[]){
        this.Id = id;
        this.cabecalho =  cabecalho;
        this.gabarito = gabarito;
        this.provas = provas;

    }

    public Id: number;
    public cabecalho: string;
    public gabarito: string;
    public provas?: Prova[];

}