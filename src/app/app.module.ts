import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';

import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';

import { CategoriaService } from './services/categoria.service';
import { CategoriaComponent } from './components/categoria/categoria.component';
import { CertificadoService } from './services/certificado.service';
import { CertificadoComponent } from './components/certificado/certificado.component';
import { ConviteService } from './services/convite.service';
import { ConviteComponent } from './components/convite/convite.component';
import { UsuarioService } from './services/usuario.service';
import { UsuarioComponent } from './components/usuario/usuario.component';
import { ProfissionalService } from './services/profissional.service';
import { ProfissionalComponent } from './components/profissional/profissional.component';
import { ProvaService } from './services/prova.service';
import { ProvaComponent } from './components/prova/prova.component';
import { QuestaoService } from './services/questao.service';
import { QuestaoComponent } from './components/questao/questao.component';
import { ResultadoService } from './services/resultado.service';
import { ResultadoComponent } from './components/resultado/resultado.component';
import { TreinamentoService } from './services/treinamento.service';
import { TreinamentoComponent } from './components/treinamento/treinamento.component';
import { TurmaService } from './services/turma.service';
import { TurmaComponent } from './components/turma/turma.component';
import { LoginComponent } from './components/login/login.component';
import { JwtInterceptor } from './helpers/jwt.interceptor';
import { ErrorInterceptor } from './helpers/error.interceptor';

@NgModule({
  declarations: [
    AppComponent,
    CategoriaComponent,
    CertificadoComponent,
    ConviteComponent,
    UsuarioComponent,
    ProfissionalComponent,
    ProvaComponent,
    QuestaoComponent,
    ResultadoComponent,
    TreinamentoComponent,
    TurmaComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    CategoriaService, 
    CertificadoService, 
    ConviteService, 
    UsuarioService, 
    ProfissionalService, 
    ProvaService, 
    QuestaoService, 
    ResultadoService, 
    TreinamentoService, 
    TurmaService,
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
