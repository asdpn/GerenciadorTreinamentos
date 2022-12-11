import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { environment } from '../../environments/environment';
import { Usuario } from '../entities/usuario';

@Injectable({ providedIn: 'root' })
export class AuthenticationService {
    private usuarioSubject: BehaviorSubject<Usuario>;
    public usuario: Observable<Usuario>;

    constructor(
        private router: Router,
        private http: HttpClient
    ) {
        this.usuarioSubject = new BehaviorSubject<Usuario>(JSON.parse(localStorage.getItem('usuario') || ''));
        this.usuario = this.usuarioSubject.asObservable();
    }

    public get usuarioValue(): Usuario {
        return this.usuarioSubject.value;
    }

    login(nomeUsuario: string, senha: string) {
        return this.http.post<any>(`${environment.apiBaseUrl}/usuarios/authenticate`, { nomeUsuario, senha })
            .pipe(map(usuario => {
                // store user details and jwt token in local storage to keep user logged in between page refreshes
                localStorage.setItem('usuario', JSON.stringify(usuario));
                this.usuarioSubject.next(usuario);
                return usuario;
            }));
    }

    logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('usuario');
        this.usuarioSubject.next(new Usuario());
        this.router.navigate(['/login']);
    }
}