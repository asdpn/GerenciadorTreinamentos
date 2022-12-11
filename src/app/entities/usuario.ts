import { Permissao } from "./enums/permissao.enum";
import { Profissional } from "./profissional";

export class Usuario{

    constructor(public id= 0, nomeUsuario= "", senha= "", permissao= Permissao.PROFISSIONAL, profissional= new Profissional(), token = ""){
        this.Id = id;
        this.nomeUsuario =  nomeUsuario;
        this.senha = senha;
        this.permissao = permissao;
        this.profissional = profissional;
        this.token = token;

    }

    public Id: number;
    public nomeUsuario: string;
    public senha: string;
    public permissao: Permissao;
    public profissional: Profissional;
    public token?: string;
}