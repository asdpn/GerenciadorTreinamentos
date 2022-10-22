import { Resultado } from "./resultado";
import { StatusCertificado } from "./statusCertificado.enum";

export interface Certificado{
    id: number;
    statusCertificado: StatusCertificado;
    resultado: Resultado;
}