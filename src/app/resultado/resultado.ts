import { Certificado } from "../certificado/certificado";
import { Prova } from "../prova/prova";
import { StatusResultado } from "../statusResultado.enum";

export interface Resultado{
    id: number;
    titulo: string;
    notaObtida: number;
    statusResultado: StatusResultado;
    certificado: Certificado;
    prova: Prova;
}