import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Turma } from './turma';

@Injectable({
    providedIn: 'root'
})
export class TurmaService{
    private apiServerUrl = environment.apiBaseUrl;

    constructor(private http: HttpClient) { }

    public listTurmas(): Observable<Turma[]>{
        return this.http.get<Turma[]>(`${this.apiServerUrl}turma/all`)
    }

    public addTurma(turma: Turma): Observable<Turma>{
        return this.http.post<Turma>(`${this.apiServerUrl}turma/add`, turma)
    }

    public updateTurma(turma: Turma): Observable<Turma>{
        return this.http.put<Turma>(`${this.apiServerUrl}turma/update/${turma.id}`, turma)
    }

    public deleteTurma(turmaId: number): Observable<void>{
        return this.http.delete<void>(`${this.apiServerUrl}turma/delete/${turmaId}`)
    }
}