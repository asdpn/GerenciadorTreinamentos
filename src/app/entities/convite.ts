import { Treinamento } from "./treinamento";

export class Convite{

    constructor(public id=0, titulo="", localLink="", dataHora= new Date(), treinamento= new Treinamento()){
        this.Id = id;
        this.titulo =  titulo;
        this.localLink = localLink;
        this.dataHora = dataHora;
        this.treinamento = treinamento;

    }

    public Id: number;
    public titulo: string;
    public localLink: string;
    public dataHora: Date;
    public treinamento: Treinamento;

}