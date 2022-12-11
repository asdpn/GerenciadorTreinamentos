import { Component} from '@angular/core';
import { Permissao } from './entities/enums/permissao.enum';
import { Usuario } from './entities/usuario';

import { AuthenticationService } from './services/authentication.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
})
export class AppComponent {

   public usuario: Usuario = new Usuario();

   constructor(private authenticationService: AuthenticationService) {
       this.authenticationService.usuario.subscribe(x => this.usuario = x);
   }

   get isGerente() {
       return this.usuario && this.usuario.permissao === Permissao.GERENTE;
   }

   get isProfissional() {
    return this.usuario && this.usuario.permissao === Permissao.PROFISSIONAL;
    }

    get isPalestrante() {
        return this.usuario && this.usuario.permissao === Permissao.PALESTRANTE;
        }

   logout() {
       this.authenticationService.logout();
   }
}
