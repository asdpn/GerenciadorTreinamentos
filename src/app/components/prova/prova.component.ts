import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Treinamento } from 'src/app/entities/treinamento';
import { Prova } from '../../entities/prova';
import { ProvaService } from '../../services/prova.service';
import { TreinamentoService } from 'src/app/services/treinamento.service';
import { Questao } from 'src/app/entities/questao';
import { QuestaoService } from '../../services/questao.service';
import { ResultadoService } from '../../services/resultado.service';
import { Resultado } from 'src/app/entities/resultado';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-prova',
  templateUrl: './prova.component.html',
  styleUrls: ['./prova.component.css']
})

export class ProvaComponent implements OnInit {

  public provas: Prova[] = [];
  public questoes: Questao[] = [];
  public treinamentos: Treinamento[] = [];
  public resultados: Resultado[] = [];

  public addProva: Prova = new Prova();
  public editProva: Prova = new Prova();
  public deleteProva: Prova = new Prova();
  public isGerente = false;
  public isPalestrante = false;

  constructor(private ProvaService: ProvaService, private QuestaoService: QuestaoService, private TreinamentoService: TreinamentoService, private ResultadoService: ResultadoService, private athenticationService: AuthenticationService){
    this.isGerente = this.athenticationService.isGerente;
    this.isPalestrante = this.athenticationService.isPalestrante;
  }

  ngOnInit(){
    this.getProvas();
    this.getQuestoes();
    this.getTreinamentos();
    this.getResultados();
  }  

  public getProvas(): void {
    this.ProvaService.listProvas().subscribe(
      (response: Prova[]) => {
        this.provas = response;
      },
      (error: HttpErrorResponse) =>{
        alert(error.message);
      }
    )
  }

  public getQuestoes(): void {
    this.QuestaoService.listQuestoes().subscribe(
      (response: Questao[]) => {
        this.questoes = response;
      },
      (error: HttpErrorResponse) =>{
        alert(error.message);
      }
    )
  }

  public getTreinamentos(): void {
    this.TreinamentoService.listTreinamentos().subscribe(
      (response: Treinamento[]) => {
        this.treinamentos = response;
      },
      (error: HttpErrorResponse) =>{
        alert(error.message);
      }
    )
  }

  public getResultados(): void {
    this.ResultadoService.listResultados().subscribe(
      (response: Resultado[]) => {
        this.resultados = response;
      },
      (error: HttpErrorResponse) =>{
        alert(error.message);
      }
    )
  }

  public onAddProva(addForm: NgForm): void {
    document.getElementById('close-add-Prova-form')!.click();
    this.ProvaService.addProva(addForm.value).subscribe(
      (response: Prova) => {
        this.getProvas();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdateProva(Prova: Prova): void {
    this.ProvaService.updateProva(Prova).subscribe(
      (response: Prova) => {
        this.getProvas();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteProva(ProvaId: number): void {
    this.ProvaService.deleteProva(ProvaId).subscribe(
      (response: void) => {
        this.getProvas();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public searchProvas(key: string): void {
    const results: Prova[] = [];
    for (const Prova of this.provas) {
      if (Prova.titulo.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        results.push(Prova);
      }
    }
    this.provas = results;
    if (results.length === 0 || !key) {
      this.getProvas();
    }
  }


  public onOpenModal(Prova: Prova, mode: string): void {
    
    const container = document.getElementById('main-container')!;
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
  
    if (mode === 'add'){
      button.setAttribute('data-target', '#addProvaModal');
    }
  
    if (mode === 'edit'){
      this.editProva = Prova;
      button.setAttribute('data-target', '#editProvaModal');
    }
  
    if (mode === 'delete'){
      this.deleteProva = Prova;
      button.setAttribute('data-target', '#deleteProvaModal');
    }
  
    container.appendChild(button);
    button.click();
  
  }
}
