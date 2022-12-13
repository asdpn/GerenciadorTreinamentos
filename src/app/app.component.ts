import { Component} from '@angular/core';
import { Permissao } from './entities/enums/permissao.enum';
import { Profissional } from './entities/profissional';

import { AuthenticationService } from './services/authentication.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
})
export class AppComponent {

   public profissional: Profissional = new Profissional();

   constructor(private authenticationService: AuthenticationService) {
       this.authenticationService.profissional.subscribe(x => this.profissional = x);
   }

   get isGerente() {
       return this.profissional && this.profissional.funcao?.permissao === Permissao.GERENTE;
   }

   get isProfissional() {
    return this.profissional && this.profissional.funcao?.permissao === Permissao.PROFISSIONAL;
    }

    get isPalestrante() {
        return this.profissional && this.profissional.funcao?.permissao === Permissao.PALESTRANTE;
    }

   logout() {
       this.authenticationService.logout();
   }
}
