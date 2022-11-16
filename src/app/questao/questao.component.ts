import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Questao } from './questao';
import { QuestaoService } from './questao.service';

@Component({
  selector: 'app-root',
  templateUrl: 'questao.html',
  styleUrls: ['../app.component.css']
})
export class QuestaoComponent {

  public questoes: Questao[] = [];
  public addQuestao: Questao = {id:0, titulo: "", statusQuestao: StatusQuestao.CRIADO, resultado: Resultado};
  public editQuestao: Questao = {id:0, titulo: "", statusQuestao: StatusQuestao.CRIADO, resultado: []};
  public deleteQuestao: Questao = {id:0, titulo: "", statusQuestao: StatusQuestao.CRIADO, resultado: []};

  constructor(private QuestaoService: QuestaoService){}

  ngOnInit(){
    this.getQuestoes();
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

  public searchquestoes(key: string): void {
    const results: Questao[] = [];
    for (const Questao of this.questoes) {
      if (Questao.titulo.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
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
