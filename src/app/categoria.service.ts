import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Categoria } from './categoria';

@Injectable({
    providedIn: 'root'
})
export class CategoriaService{
    private apiServerUrl = environment.apiBaseUrl;

    constructor(private http: HttpClient) { }

    public listCategorias(): Observable<Categoria[]>{
        return this.http.get<Categoria[]>(`${this.apiServerUrl}/categoria`)
    }

    public create(categoria: Categoria): Observable<Categoria[]>{
        return this.http.post<Categoria[]>(`${this.apiServerUrl}/categoria/`, categoria)
    }

    public update(categoria: Categoria): Observable<Categoria[]>{
        return this.http.put<Categoria[]>(`${this.apiServerUrl}/categoria/`, categoria)
    }

    public delete(categoriaId: number): Observable<void>{
        return this.http.delete<void>(`${this.apiServerUrl}/categoria/${categoriaId}`)
    }
}