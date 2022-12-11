import { Certificado } from "./certificado";
import { Prova } from "./prova";
import { StatusResultado } from "./enums/statusResultado.enum";
import { Profissional } from "./profissional";

export class Resultado{

    constructor(public id=0, titulo="", prova = new Prova(), profissional= new Profissional(), notaObtida=0, statusResultado=StatusResultado.CRIADO, certificado?: Certificado){
        this.Id = id;
        this.titulo =  titulo;
        this.prova = prova;
        this. profissional = profissional;
        this.notaObtida = notaObtida;
        this.statusResultado = statusResultado;
        this.certificado = certificado;
    }

    public Id: number;
    public titulo: string;
    public prova: Prova;
    public profissional: Profissional;
    public notaObtida: number;
    public statusResultado: StatusResultado;
    public certificado?: Certificado;

}