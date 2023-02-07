import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { map } from 'rxjs/operators';
import { Permissao } from '../entities/enums/permissao.enum';

import { Profissional } from '../entities/profissional';
import { ProfissionalService } from './profissional.service';

@Injectable({ providedIn: 'root' })
export class AuthenticationService {
    public profissional: Profissional = new Profissional();
    public loginOK = false;
    public isGerente = false;
    public isPalestrante = false;

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
                this.isGerente = false;
                this.isPalestrante = false;
                if (profissional.funcao?.permissao == Permissao.GERENTE){
                    this.isGerente = true;
                } else if (profissional.funcao?.permissao == Permissao.PALESTRANTE){
                    this.isPalestrante = true;
                } 
                return profissional;
            }));
    }

    logout() {
        sessionStorage.removeItem('profissional');
        this.loginOK = false;
        this.router.navigate(['/login']);
    }
}