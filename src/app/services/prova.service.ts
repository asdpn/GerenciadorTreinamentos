import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Prova } from '../entities/prova';

@Injectable({
    providedIn: 'root'
})
export class ProvaService{
    private apiServerUrl = environment.apiBaseUrl;

    constructor(private http: HttpClient) { }

    public listProvas(): Observable<Prova[]>{
        return this.http.get<Prova[]>(`${this.apiServerUrl}prova/all`)
    }

    public addProva(prova: Prova): Observable<Prova>{
        return this.http.post<Prova>(`${this.apiServerUrl}prova/add`, prova)
    }

    public updateProva(prova: Prova): Observable<Prova>{
        return this.http.put<Prova>(`${this.apiServerUrl}prova/update/${prova.id}`, prova)
    }

    public deleteProva(provaId: number): Observable<void>{
        return this.http.delete<void>(`${this.apiServerUrl}prova/delete/${provaId}`)
    }
}