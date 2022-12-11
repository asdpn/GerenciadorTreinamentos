import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Usuario } from '../entities/usuario';

@Injectable({
    providedIn: 'root'
})
export class UsuarioService{
    private apiServerUrl = environment.apiBaseUrl;

    constructor(private http: HttpClient) { }

    public listUsuarios(): Observable<Usuario[]>{
        return this.http.get<Usuario[]>(`${this.apiServerUrl}usuario/all`)
    }

    public addUsuario(usuario: Usuario): Observable<Usuario>{
        return this.http.post<Usuario>(`${this.apiServerUrl}usuario/add`, usuario)
    }

    public updateUsuario(usuario: Usuario): Observable<Usuario>{
        return this.http.put<Usuario>(`${this.apiServerUrl}usuario/update/${usuario.id}`, usuario)
    }

    public deleteUsuario(usuarioId: number): Observable<void>{
        return this.http.delete<void>(`${this.apiServerUrl}usuario/delete/${usuarioId}`)
    }
}