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
       this.authenticationService.profissional;
   }

   logout() {
       this.authenticationService.logout();
   }
}
