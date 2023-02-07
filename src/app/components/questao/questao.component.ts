import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Questao } from '../../entities/questao';
import { QuestaoService } from '../../services/questao.service';
import { ProvaService } from '../../services/prova.service';
import { Prova } from 'src/app/entities/prova';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-questao',
  templateUrl: './questao.component.html',
  styleUrls: ['./questao.component.css']
})
export class QuestaoComponent implements OnInit{

  public questoes: Questao[] = [];
  public provas: Prova[] = [];
  
  public addQuestao: Questao = new Questao();
  public editQuestao: Questao = new Questao();
  public deleteQuestao: Questao = new Questao();
  public isGerente = false;
  public isPalestrante = false;

  constructor(private QuestaoService: QuestaoService,private ProvaService: ProvaService, private athenticationService: AuthenticationService){
    this.isGerente = this.athenticationService.isGerente;
    this.isPalestrante = this.athenticationService.isPalestrante;
  }


  ngOnInit(){
    this.getQuestoes();
    this.getProvas();
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

  public onAddQuestao(addForm: NgForm): void {
    document.getElementById('close-add-Questao-form')!.click();
    this.QuestaoService.addQuestao(addForm.value).subscribe(
      (response: Questao) => {
        this.getQuestoes();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdateQuestao(Questao: Questao): void {
    this.QuestaoService.updateQuestao(Questao).subscribe(
      (response: Questao) => {
        this.getQuestoes();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteQuestao(QuestaoId: number): void {
    this.QuestaoService.deleteQuestao(QuestaoId).subscribe(
      (response: void) => {
        this.getQuestoes();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public searchQuestoes(key: string): void {
    const results: Questao[] = [];
    for (const Questao of this.questoes) {
      if (Questao.cabecalho.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        results.push(Questao);
      }
    }
    this.questoes = results;
    if (results.length === 0 || !key) {
      this.getQuestoes();
    }
  }


  public onOpenModal(Questao: Questao, mode: string): void {
    
    const container = document.getElementById('main-container')!;
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
  
    if (mode === 'add'){
      button.setAttribute('data-target', '#addQuestaoModal');
    }
  
    if (mode === 'edit'){
      this.editQuestao = Questao;
      button.setAttribute('data-target', '#editQuestaoModal');
    }
  
    if (mode === 'delete'){
      this.deleteQuestao = Questao;
      button.setAttribute('data-target', '#deleteQuestaoModal');
    }
  
    container.appendChild(button);
    button.click();
  
  }
}
