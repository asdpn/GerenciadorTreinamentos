import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { environment } from '../../environments/environment';
import { Profissional } from '../entities/profissional';

@Injectable({ providedIn: 'root' })
export class AuthenticationService {
    private profissionalSubject: BehaviorSubject<Profissional>;
    public profissional: Observable<Profissional>;

    constructor(
        private router: Router,
        private http: HttpClient
    ) {
        this.profissionalSubject = new BehaviorSubject<Profissional>(JSON.parse(sessionStorage.getItem('profissional') ?? '{}'));
        this.profissional = this.profissionalSubject.asObservable();
    }

    public get profissionalValue(): Profissional {
        return this.profissionalSubject.value;
    }

    login(nomeUsuario: string, senha: string) {
        return this.http.post<any>(`${environment.apiBaseUrl}/profissional/authenticate`, { nomeUsuario, senha })
            .pipe(map(profissional => {
                // store user details and jwt token in local storage to keep user logged in between page refreshes
                sessionStorage.setItem('profissional', JSON.stringify(profissional));
                this.profissionalSubject.next(profissional);
                return profissional;
            }));
    }

    logout() {
        // remove user from local storage to log user out
        sessionStorage.removeItem('profissional');
        this.profissionalSubject.next(new Profissional());
        this.router.navigate(['/login']);
    }
}