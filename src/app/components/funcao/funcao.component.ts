import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Permissao } from 'src/app/entities/enums/permissao.enum';
import { Profissional } from 'src/app/entities/profissional';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { ProfissionalService } from 'src/app/services/profissional.service';
import { Funcao } from '../../entities/funcao';
import { FuncaoService } from '../../services/funcao.service';

@Component({
  selector: 'app-funcao',
  templateUrl: './funcao.component.html',
  styleUrls: ['./funcao.component.css']
})
export class FuncaoComponent implements OnInit{

  public funcoes: Funcao[] = [];
  public profissionais: Profissional[] = [];
  public permissoes: Permissao[] = [Permissao.GERENTE, Permissao.PALESTRANTE, Permissao.PROFISSIONAL];
  
  public addFuncao: Funcao = new Funcao();
  public editFuncao: Funcao = new Funcao();
  public deleteFuncao: Funcao = new Funcao();
  public isGerente = false;

  constructor(private FuncaoService: FuncaoService, private ProfissionalService: ProfissionalService, private athenticationService: AuthenticationService){
    this.isGerente = this.athenticationService.isGerente;
  }

  ngOnInit(){
    this.getFuncoes();
    this.getProfissionais();
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

  public getProfissionais(): void {
    this.ProfissionalService.listProfissionais().subscribe(
      (response: Profissional[]) => {
        this.profissionais = response;
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