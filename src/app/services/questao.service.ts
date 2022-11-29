import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Questao } from '../entities/questao';

@Injectable({
    providedIn: 'root'
})
export class QuestaoService{
    private apiServerUrl = environment.apiBaseUrl;

    constructor(private http: HttpClient) { }

    public listQuestoes(): Observable<Questao[]>{
        return this.http.get<Questao[]>(`${this.apiServerUrl}questao/all`)
    }

    public addQuestao(questao: Questao): Observable<Questao>{
        return this.http.post<Questao>(`${this.apiServerUrl}questao/add`, questao)
    }

    public updateQuestao(questao: Questao): Observable<Questao>{
        return this.http.put<Questao>(`${this.apiServerUrl}questao/update/${questao.id}`, questao)
    }

    public deleteQuestao(questaoId: number): Observable<void>{
        return this.http.delete<void>(`${this.apiServerUrl}questao/delete/${questaoId}`)
    }
}