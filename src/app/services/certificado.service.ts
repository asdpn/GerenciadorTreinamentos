import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Certificado } from '../entities/certificado';

@Injectable({
    providedIn: 'root'
})
export class CertificadoService{
    private apiServerUrl = environment.apiBaseUrl;

    constructor(private http: HttpClient) { }

    public listCertificados(): Observable<Certificado[]>{
        return this.http.get<Certificado[]>(`${this.apiServerUrl}certificado/all`)
    }

    public addCertificado(certificado: Certificado): Observable<Certificado>{
        return this.http.post<Certificado>(`${this.apiServerUrl}certificado/add`, certificado)
    }

    public updateCertificado(certificado: Certificado): Observable<Certificado>{
        return this.http.put<Certificado>(`${this.apiServerUrl}certificado/update/${certificado.id}`, certificado)
    }

    public deleteCertificado(certificadoId: number): Observable<void>{
        return this.http.delete<void>(`${this.apiServerUrl}certificado/delete/${certificadoId}`)
    }
}