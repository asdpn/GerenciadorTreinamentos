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
    {path: 'categoria', component: CategoriaComponent},
    {path: 'certificado', component: CertificadoComponent},
    {path: 'convite', component: ConviteComponent},
    {path: 'profissional', component: ProfissionalComponent},
    {path: 'prova', component: ProvaComponent},
    {path: 'questao', component: QuestaoComponent},
    {path: 'resultado', component: ResultadoComponent},
    {path: 'treinamento', component: TreinamentoComponent},
    {path: 'turma', component: TurmaComponent},    
    {path: 'funcao', component: FuncaoComponent},
    {path: 'login', component: LoginComponent},
    {path: '', redirectTo: '/login', pathMatch: 'full'}     
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }