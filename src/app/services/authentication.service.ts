import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { map } from 'rxjs/operators';

import { Profissional } from '../entities/profissional';
import { ProfissionalService } from './profissional.service';

@Injectable({ providedIn: 'root' })
export class AuthenticationService {
    public profissional: Profissional = new Profissional();
    public loginOK = false;

    constructor(
        private router: Router,
        private ProfissionalService: ProfissionalService
    ) {

    }

    login(email: string, senha: string) {
        this.profissional.email = email;
        this.profissional.senha = senha;
        return this.ProfissionalService.authenticateProfissional(this.profissional)
            .pipe(map(profissional => {
                sessionStorage.setItem('profissional', JSON.stringify(profissional));
                this.loginOK = true;
                return profissional;
            }));
    }

    logout() {
        sessionStorage.removeItem('profissional');
        this.loginOK = false;
        this.router.navigate(['/login']);
    }
}