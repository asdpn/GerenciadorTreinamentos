import { Permissao } from "./enums/permissao.enum";
import { Profissional } from "./profissional";

export class Funcao{

    constructor(public id=0, titulo="", descricao="", permissao= Permissao.PROFISSIONAL, profissionais?: Profissional[]){
        this.Id = id;
        this.titulo =  titulo;
        this.descricao = descricao;
        this.permissao = permissao;
        this.profissionais = profissionais;

    }

    public Id: number;
    public titulo: string;
    public descricao: string;
    public permissao: Permissao;
    public profissionais?: Profissional[];

}