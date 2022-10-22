import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Resultado } from './resultado';

@Injectable({
    providedIn: 'root'
})
export class ResultadoService{
    private apiServerUrl = environment.apiBaseUrl;

    constructor(private http: HttpClient) { }

    public listResultados(): Observable<Resultado[]>{
        return this.http.get<Resultado[]>(`${this.apiServerUrl}resultado/all`)
    }

    public addResultado(resultado: Resultado): Observable<Resultado>{
        return this.http.post<Resultado>(`${this.apiServerUrl}resultado/add`, resultado)
    }

    public updateResultado(resultado: Resultado): Observable<Resultado>{
        return this.http.put<Resultado>(`${this.apiServerUrl}resultado/update/${resultado.id}`, resultado)
    }

    public deleteResultado(resultadoId: number): Observable<void>{
        return this.http.delete<void>(`${this.apiServerUrl}resultado/delete/${resultadoId}`)
    }
}