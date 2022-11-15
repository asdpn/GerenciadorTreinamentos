import { Certificado } from "../certificado/certificado";
import { Prova } from "../prova/prova";
import { StatusResultado } from "../statusResultado.enum";

export interface Resultado{
    id: number;
    notaObtida: string;
    statusResultado: StatusResultado;
    certificado: Certificado;
    prova: Prova;
}