import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { first } from 'rxjs/operators';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { Profissional } from 'src/app/entities/profissional';


@Component({ templateUrl: 'login.component.html' })
export class LoginComponent implements OnInit {
    profissional = new Profissional();
    loading = false;
    submitted = false;
    error = '';

    constructor(
        private route: ActivatedRoute,
        private router: Router,
        private authenticationService: AuthenticationService
    ) { 
        // redirect to home if already logged in
        if (this.authenticationService.profissionalValue) { 
            this.router.navigate(['/']);
        }
    }

    ngOnInit() {
    }

    onSubmit() {
        this.loading = true;
        this.authenticationService.login(this.profissional.nomeUsuario, this.profissional.senha)
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