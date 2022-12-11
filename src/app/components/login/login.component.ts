import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { first } from 'rxjs/operators';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { Usuario } from 'src/app/entities/usuario';


@Component({ templateUrl: 'login.component.html' })
export class LoginComponent implements OnInit {
    usuario = new Usuario();
    loading = false;
    submitted = false;
    error = '';

    constructor(
        private route: ActivatedRoute,
        private router: Router,
        private authenticationService: AuthenticationService
    ) { 
        // redirect to home if already logged in
        if (this.authenticationService.usuarioValue) { 
            this.router.navigate(['/']);
        }
    }

    ngOnInit() {
    }

    onSubmit() {
        this.loading = true;
        this.authenticationService.login(this.usuario.nomeUsuario, this.usuario.senha)
            .pipe(first())
            .subscribe({
                next: () => {
                    // get return url from query parameters or default to home page
                    const returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
                    this.router.navigateByUrl(returnUrl);
                },
                error: error => {
                    this.error = error;
                    this.loading = false;
                }
            });
    }
}