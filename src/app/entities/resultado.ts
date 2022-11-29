import { Certificado } from "./certificado";
import { Prova } from "./prova";
import { StatusResultado } from "./enums/statusResultado.enum";

export interface Resultado{
    id: number;
    titulo: string;
    notaObtida: number;
    statusResultado: StatusResultado;
    certificado: Certificado;
    prova: Prova;
}