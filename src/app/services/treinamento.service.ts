import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Treinamento } from '../entities/treinamento';

@Injectable({
    providedIn: 'root'
})
export class TreinamentoService{
    private apiServerUrl = environment.apiBaseUrl;

    constructor(private http: HttpClient) { }

    public listTreinamentos(): Observable<Treinamento[]>{
        return this.http.get<Treinamento[]>(`${this.apiServerUrl}treinamento/all`)
    }

    public addTreinamento(treinamento: Treinamento): Observable<Treinamento>{
        return this.http.post<Treinamento>(`${this.apiServerUrl}treinamento/add`, treinamento)
    }

    public updateTreinamento(treinamento: Treinamento): Observable<Treinamento>{
        return this.http.put<Treinamento>(`${this.apiServerUrl}treinamento/update/${treinamento.id}`, treinamento)
    }

    public deleteTreinamento(treinamentoId: number): Observable<void>{
        return this.http.delete<void>(`${this.apiServerUrl}treinamento/delete/${treinamentoId}`)
    }
}