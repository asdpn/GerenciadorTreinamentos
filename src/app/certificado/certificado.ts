import { Resultado } from "../resultado/resultado";
import { StatusCertificado } from "../statusCertificado.enum";

export interface Certificado{
    id: number;
    titulo: string;
    statusCertificado: StatusCertificado;
    resultado: Resultado;
}