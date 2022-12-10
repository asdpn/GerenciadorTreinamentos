import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';

import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
//import { AuthModule } from '@auth0/auth0-angular';
//import { environment as env } from 'src/environments/environment';
import { RouterModule } from '@angular/router';

import { CategoriaService } from './services/categoria.service';
import { CategoriaComponent } from './components/categoria/categoria.component';
import { CertificadoService } from './services/certificado.service';
import { CertificadoComponent } from './components/certificado/certificado.component';
import { ConviteService } from './services/convite.service';
import { ConviteComponent } from './components/convite/convite.component';
import { FuncaoService } from './services/funcao.service';
import { FuncaoComponent } from './components/funcao/funcao.component';
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
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
//import { LoginButtonComponent } from './components/login-button/login-button.component';
//import { LogoutButtonComponent } from './components/logout-button/logout-button.component';
//import { LoadingComponent } from './components/loading/loading.component';

@NgModule({
  declarations: [
    AppComponent,
    CategoriaComponent,
    CertificadoComponent,
    ConviteComponent,
    FuncaoComponent,
    ProfissionalComponent,
    ProvaComponent,
    QuestaoComponent,
    ResultadoComponent,
    TreinamentoComponent,
    TurmaComponent,
    NavBarComponent,
    //LoginButtonComponent,
    //LogoutButtonComponent,
    //LoadingComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot([
      {path: 'categoria', component: CategoriaComponent},
      {path: 'certificado', component: CertificadoComponent},
      {path: 'convite', component: ConviteComponent},
      {path: 'funcao', component: FuncaoComponent},
      {path: 'profissional', component: ProfissionalComponent},
      {path: 'prova', component: ProvaComponent},
      {path: 'questao', component: QuestaoComponent},
      {path: 'resultado', component: ResultadoComponent},
      {path: 'treinamento', component: TreinamentoComponent},
      {path: 'turma', component: TurmaComponent},
      {path: '', redirectTo: '/treinamento', pathMatch: 'full'}      
    ]),
    HttpClientModule,
    FormsModule
    //AuthModule.forRoot({
    //  ... env.auth,
    //})
  ],
  providers: [CategoriaService, CertificadoService, ConviteService, FuncaoService, ProfissionalService, ProvaService, QuestaoService, ResultadoService, TreinamentoService, TurmaService],
  bootstrap: [AppComponent]
})
export class AppModule { }
