import { Profissional } from "./profissional";
import { Questao } from "./questao";
import { Resultado } from "./resultado";
import { Treinamento } from "./treinamento";


export class Prova{

    constructor(public id=0, titulo="", notaMaxima=0, notaMinima=0, questoes?: Questao[], profissional = new Profissional(), treinamento= new Treinamento(), resultado?: Resultado){
        this.Id = id;
        this.titulo =  titulo;
        this.notaMaxima = notaMaxima;
        this.notaMinima = notaMinima;
        this.questoes = questoes;
        this.profissional = profissional;
        this.treinamento = treinamento;
        this.resultado = resultado;

    }

    public Id: number;
    public titulo: string;
    public notaMaxima: number;
    public notaMinima: number;
    public questoes?: Questao[];
    public profissional: Profissional;
    public treinamento: Treinamento;
    public resultado?: Resultado;

}