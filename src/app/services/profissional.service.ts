import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Profissional } from '../entities/profissional';

@Injectable({
    providedIn: 'root'
})
export class ProfissionalService{
    private apiServerUrl = environment.apiBaseUrl;

    constructor(private http: HttpClient) { }

    public listProfissionais(): Observable<Profissional[]>{
        return this.http.get<Profissional[]>(`${this.apiServerUrl}profissional/all`)
    }

    public addProfissional(profissional: Profissional): Observable<Profissional>{
        return this.http.post<Profissional>(`${this.apiServerUrl}profissional/add`, profissional)
    }

    public updateProfissional(profissional: Profissional): Observable<Profissional>{
        return this.http.put<Profissional>(`${this.apiServerUrl}profissional/update/${profissional.id}`, profissional)
    }

    public deleteProfissional(profissionalId: number): Observable<void>{
        return this.http.delete<void>(`${this.apiServerUrl}profissional/delete/${profissionalId}`)
    }

    public authenticateProfissional(profissional: Profissional): Observable<Profissional>{
        return this.http.post<Profissional>(`${this.apiServerUrl}profissional/authenticate`, profissional)
    }
}