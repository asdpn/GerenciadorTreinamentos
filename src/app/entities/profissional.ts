import { Funcao } from "./funcao";
import { Prova } from "./prova";
import { Treinamento } from "./treinamento";
import { Turma } from "./turma";

export class Profissional{

    constructor(public id=0, nomeCompleto="", empresa="", email="", telefone="", senha="", funcao = new Funcao(), treinamentos?: Treinamento[], turmas?: Turma[], provas?: Prova[]){
        this.Id = id;
        this.nomeCompleto =  nomeCompleto;
        this.empresa = empresa;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.funcao = funcao;
        this.treinamentos = treinamentos;
        this.turmas = turmas;
        this.provas = provas;

    }

    public Id: number;
    public nomeCompleto: string;
    public empresa: string;
    public email: string;
    public telefone: string;
    public senha: string;
    public funcao: Funcao;
    public treinamentos?: Treinamento[];
    public turmas?: Turma[];
    public provas?: Prova[];

}