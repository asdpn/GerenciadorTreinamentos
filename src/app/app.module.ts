import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { CategoriaService } from './categoria/categoria.service';
import { CategoriaComponent } from './categoria/categoria.component';
import { CertificadoService } from './certificado/certificado.service';
import { CertificadoComponent } from './certificado/certificado.component';
import { ConviteService } from './convite/convite.service';
import { ConviteComponent } from './convite/convite.component';
import { FuncaoService } from './funcao/funcao.service';
import { FuncaoComponent } from './funcao/funcao.component';
import { ProfissionalService } from './profissional/profissional.service';
import { ProfissionalComponent } from './profissional/profissional.component';
import { ProvaService } from './prova/prova.service';
import { ProvaComponent } from './prova/prova.component';
import { QuestaoService } from './questao/questao.service';
import { QuestaoComponent } from './questao/questao.component';
import { ResultadoService } from './resultado/resultado.service';
import { ResultadoComponent } from './resultado/resultado.component';
import { TreinamentoService } from './treinamento/treinamento.service';
import { TreinamentoComponent } from './treinamento/treinamento.component';
import { TurmaService } from './turma/turma.service';
import { TurmaComponent } from './turma/turma.component';

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
    TurmaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [CategoriaService, CertificadoService, ConviteService, FuncaoService, ProfissionalService, ProvaService, QuestaoService, ResultadoService, TreinamentoService, TurmaService],
  bootstrap: [AppComponent]
})
export class AppModule { }
