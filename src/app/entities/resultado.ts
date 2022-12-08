import { Certificado } from "./certificado";
import { Prova } from "./prova";
import { StatusResultado } from "./enums/statusResultado.enum";

export class Resultado{

    constructor(public id=0, titulo="", notaObtida=0, statusResultado=StatusResultado.CRIADO, certificado?: Certificado, prova= new Prova()){
        this.Id = id;
        this.titulo =  titulo;
        this.notaObtida = notaObtida;
        this.statusResultado = statusResultado;
        this.certificado = certificado;
        this.prova = prova;

    }

    public Id: number;
    public titulo: string;
    public notaObtida: number;
    public statusResultado: StatusResultado;
    public certificado?: Certificado;
    public prova: Prova;

}