import { Treinamento } from "./treinamento";
import { Turma } from "./turma";
import { Resultado } from "./resultado";
import { Funcao } from "./funcao";

export class Profissional{

    constructor(public id=0, nomeCompleto="", nomeUsuario="", senha="", empresa="", email="", telefone="", funcao?: Funcao, treinamentos?: Treinamento[], turmas?: Turma[], resultados?: Resultado[]){
        this.Id = id;
        this.nomeCompleto =  nomeCompleto;
        this.nomeUsuario = nomeUsuario;
        this.empresa = empresa;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.treinamentos = treinamentos;
        this.turmas = turmas;
        this.resultados = resultados;
        this.funcao = funcao;

    }

    public Id: number;
    public nomeCompleto: string;
    public nomeUsuario: string;
    public senha: string;
    public empresa: string;
    public email: string;
    public telefone: string;
    public funcao?: Funcao;
    public treinamentos?: Treinamento[];
    public turmas?: Turma[];
    public resultados?: Resultado[];

}