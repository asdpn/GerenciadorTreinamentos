import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Funcao } from './funcao';

@Injectable({
    providedIn: 'root'
})
export class FuncaoService{
    private apiServerUrl = environment.apiBaseUrl;

    constructor(private http: HttpClient) { }

    public listFuncoes(): Observable<Funcao[]>{
        return this.http.get<Funcao[]>(`${this.apiServerUrl}funcao/all`)
    }

    public addFuncao(funcao: Funcao): Observable<Funcao>{
        return this.http.post<Funcao>(`${this.apiServerUrl}funcao/add`, funcao)
    }

    public updateFuncao(funcao: Funcao): Observable<Funcao>{
        return this.http.put<Funcao>(`${this.apiServerUrl}funcao/update/${funcao.id}`, funcao)
    }

    public deleteFuncao(funcaoId: number): Observable<void>{
        return this.http.delete<void>(`${this.apiServerUrl}funcao/delete/${funcaoId}`)
    }
}