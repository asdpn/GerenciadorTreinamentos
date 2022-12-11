import { Questao } from "./questao";
import { Resultado } from "./resultado";
import { Treinamento } from "./treinamento";


export class Prova{

    constructor(public id=0, titulo="", notaMaxima=0, notaMinima=0, treinamento= new Treinamento(), questoes?: Questao[],  resultados?: Resultado[]){
        this.Id = id;
        this.titulo =  titulo;
        this.notaMaxima = notaMaxima;
        this.notaMinima = notaMinima;
        this.questoes = questoes;
        this.treinamento = treinamento;
        this.resultados = resultados;

    }

    public Id: number;
    public titulo: string;
    public notaMaxima: number;
    public notaMinima: number;
    public questoes?: Questao[];
    public treinamento: Treinamento;
    public resultados?: Resultado[];

}