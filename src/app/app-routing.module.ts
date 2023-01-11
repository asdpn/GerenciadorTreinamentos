import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CategoriaComponent } from './components/categoria/categoria.component';
import { CertificadoComponent } from './components/certificado/certificado.component';
import { ConviteComponent } from './components/convite/convite.component';
import { ProfissionalComponent } from './components/profissional/profissional.component';
import { ProvaComponent } from './components/prova/prova.component';
import { QuestaoComponent } from './components/questao/questao.component';
import { ResultadoComponent } from './components/resultado/resultado.component';
import { TreinamentoComponent } from './components/treinamento/treinamento.component';
import { TurmaComponent } from './components/turma/turma.component';
import { LoginComponent } from './components/login/login.component';
import { AuthGuard } from './helpers/auth.guard';
import { FuncaoComponent } from './components/funcao/funcao.component';



const routes: Routes = [
    {path: 'categoria', component: CategoriaComponent, canActivate: [AuthGuard]},
    {path: 'certificado', component: CertificadoComponent, canActivate: [AuthGuard]},
    {path: 'convite', component: ConviteComponent, canActivate: [AuthGuard]},
    {path: 'profissional', component: ProfissionalComponent, canActivate: [AuthGuard]},
    {path: 'prova', component: ProvaComponent, canActivate: [AuthGuard]},
    {path: 'questao', component: QuestaoComponent, canActivate: [AuthGuard]},
    {path: 'resultado', component: ResultadoComponent, canActivate: [AuthGuard]},
    {path: 'treinamento', component: TreinamentoComponent, canActivate: [AuthGuard]},
    {path: 'turma', component: TurmaComponent, canActivate: [AuthGuard]},    
    {path: 'funcao', component: FuncaoComponent, canActivate: [AuthGuard]},
    {path: 'login', component: LoginComponent},
    {path: '', redirectTo: '/login', pathMatch: 'full'}     
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }