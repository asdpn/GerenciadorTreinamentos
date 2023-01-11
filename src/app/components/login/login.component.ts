import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { first } from 'rxjs/operators';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { Profissional } from 'src/app/entities/profissional';
import { NgForm } from '@angular/forms';


@Component({ templateUrl: 'login.component.html' })
export class LoginComponent implements OnInit {
    email = '';
    senha='';
    loading = false;
    submitted = false;
    error = '';
    show = false;

    constructor(
        private route: ActivatedRoute,
        private router: Router,
        private authenticationService: AuthenticationService
    ) { 
        if (this.authenticationService.loginOK) { 
            this.router.navigate(['/']);
        }
    }

    ngOnInit() {
    }

    onSubmit(id: string, loginForm: NgForm) {
        if (id === 'login'){
            this.loading = true;
            this.email = loginForm.value.email;
            this.senha = loginForm.value.senha;
            this.authenticationService.login(this.email, this.senha)
                .pipe(first())
                .subscribe({
                    next: () => {
                        // get return url from query parameters or default to home page
                        const returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
                        this.router.navigateByUrl(returnUrl);
                    },
                    error: error => {
                        this.error = error.error.msg;
                        this.loading = false;
                    }
                });
        }

        if (id === 'showHideButton'){
            this.show = !this.show;
        }
    }
}