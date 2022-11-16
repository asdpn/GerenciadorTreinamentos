import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Funcao } from './funcao';
import { FuncaoService } from './funcao.service';

@Component({
  selector: 'app-root',
  templateUrl: 'funcao.html',
  styleUrls: ['../app.component.css']
})
export class FuncaoComponent {

  public funcoes: Funcao[] = [];
  public addFuncao: Funcao = {id:0, titulo: "", statusFuncao: StatusFuncao.CRIADO, resultado: Resultado};
  public editFuncao: Funcao = {id:0, titulo: "", statusFuncao: StatusFuncao.CRIADO, resultado: []};
  public deleteFuncao: Funcao = {id:0, titulo: "", statusFuncao: StatusFuncao.CRIADO, resultado: []};

  constructor(private FuncaoService: FuncaoService){}

  ngOnInit(){
    this.getFuncoes();
  }  

  public getFuncoes(): void {
    this.FuncaoService.listFuncoes().subscribe(
      (response: Funcao[]) => {
        this.funcoes = response;
      },
      (error: HttpErrorResponse) =>{
        alert(error.message);
      }
    )
  }

  public onAddFuncao(addForm: NgForm): void {
    document.getElementById('close-add-Funcao-form')!.click();
    this.FuncaoService.addFuncao(addForm.value).subscribe(
      (response: Funcao) => {
        this.getFuncoes();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdateFuncao(Funcao: Funcao): void {
    this.FuncaoService.updateFuncao(Funcao).subscribe(
      (response: Funcao) => {
        this.getFuncoes();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteFuncao(FuncaoId: number): void {
    this.FuncaoService.deleteFuncao(FuncaoId).subscribe(
      (response: void) => {
        this.getFuncoes();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public searchFuncoes(key: string): void {
    const results: Funcao[] = [];
    for (const funcao of this.funcoes) {
      if (funcao.titulo.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        results.push(funcao);
      }
    }
    this.funcoes = results;
    if (results.length === 0 || !key) {
      this.getFuncoes();
    }
  }


  public onOpenModal(Funcao: Funcao, mode: string): void {
    
    const container = document.getElementById('main-container')!;
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
  
    if (mode === 'add'){
      button.setAttribute('data-target', '#addFuncaoModal');
    }
  
    if (mode === 'edit'){
      this.editFuncao = Funcao;
      button.setAttribute('data-target', '#editFuncaoModal');
    }
  
    if (mode === 'delete'){
      this.deleteFuncao = Funcao;
      button.setAttribute('data-target', '#deleteFuncaoModal');
    }
  
    container.appendChild(button);
    button.click();
  
  }
}
