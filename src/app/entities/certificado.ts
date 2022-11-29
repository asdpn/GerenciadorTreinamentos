import { Resultado } from "./resultado";
import { StatusCertificado } from "./enums/statusCertificado.enum";

export interface Certificado{
    id: number;
    titulo: string;
    statusCertificado: StatusCertificado;
    resultado: Resultado;
}