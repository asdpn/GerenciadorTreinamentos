import { Resultado } from "./resultado";
import { StatusCertificado } from "./enums/statusCertificado.enum";

export class Certificado{

    constructor(public id=0, titulo="", statusCertificado=StatusCertificado.CRIADO, resultado= new Resultado()){
        this.Id = id;
        this.titulo =  titulo;
        this.statusCertificado = statusCertificado;
        this.resultado = resultado;
    }

    public Id: number;
    public titulo: string;
    public statusCertificado: StatusCertificado;
    public resultado: Resultado;

}