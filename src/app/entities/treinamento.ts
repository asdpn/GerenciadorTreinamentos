import { Categoria } from "./categoria";
import { Convite } from "./convite";
import { Profissional } from "./profissional";
import { Prova } from "./prova";
import { StatusTreinamento } from "./enums/statusTreinamento.enum";
import { Turma } from "./turma";

export class Treinamento{

    constructor(public id=0, titulo="", descricao="", statusTreinamento= StatusTreinamento.CRIADO, categoria = new Categoria(), turma?: Turma, convite?: Convite, prova?: Prova, palestrantes?: Profissional[]){
        this.Id = id;
        this.titulo =  titulo;
        this.descricao = descricao;
        this.statusTreinamento = statusTreinamento;
        this.categoria = categoria;
        this.turma = turma;
        this.convite = convite;
        this.prova = prova;
        this.palestrantes = palestrantes;

    }

    public Id: number;
    public titulo: string;
    public descricao?: string;
    public statusTreinamento: StatusTreinamento;
    public categoria: Categoria;
    public turma?: Turma;
    public convite?: Convite;
    public prova?: Prova;
    public palestrantes?: Profissional[];

}