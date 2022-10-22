import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Convite } from './convite';

@Injectable({
    providedIn: 'root'
})
export class ConviteService{
    private apiServerUrl = environment.apiBaseUrl;

    constructor(private http: HttpClient) { }

    public listConvites(): Observable<Convite[]>{
        return this.http.get<Convite[]>(`${this.apiServerUrl}convite/all`)
    }

    public addConvite(convite: Convite): Observable<Convite>{
        return this.http.post<Convite>(`${this.apiServerUrl}convite/add`, convite)
    }

    public updateConvite(convite: Convite): Observable<Convite>{
        return this.http.put<Convite>(`${this.apiServerUrl}convite/update/${convite.id}`, convite)
    }

    public deleteConvite(conviteId: number): Observable<void>{
        return this.http.delete<void>(`${this.apiServerUrl}convite/delete/${conviteId}`)
    }
}