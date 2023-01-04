import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { first } from 'rxjs/operators';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { Profissional } from 'src/app/entities/profissional';


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
        // redirect to home if already logged in
        if (this.authenticationService.profissionalValue) { 
            this.router.navigate(['/']);
        }
    }

    ngOnInit() {
    }

    onSubmit(id: string) {
        if (id === 'login'){
            this.loading = true;
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