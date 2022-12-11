import { Usuario } from "./usuario";
import { Treinamento } from "./treinamento";
import { Turma } from "./turma";
import { Resultado } from "./resultado";

export class Profissional{

    constructor(public id=0, nomeCompleto="", cargo="", empresa="", email="", telefone="", usuario = new Usuario(), treinamentos?: Treinamento[], turmas?: Turma[], resultados?: Resultado[]){
        this.Id = id;
        this.nomeCompleto =  nomeCompleto;
        this.cargo = cargo;
        this.empresa = empresa;
        this.email = email;
        this.telefone = telefone;
        this.usuario = usuario;
        this.treinamentos = treinamentos;
        this.turmas = turmas;
        this.resultados = resultados;

    }

    public Id: number;
    public nomeCompleto: string;
    public cargo: string;
    public empresa: string;
    public email: string;
    public telefone: string;
    public usuario: Usuario;
    public treinamentos?: Treinamento[];
    public turmas?: Turma[];
    public resultados?: Resultado[];

}