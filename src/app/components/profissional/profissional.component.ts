import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Usuario } from '../../entities/usuario';
import { UsuarioService } from '../../services/usuario.service';
import { Treinamento } from 'src/app/entities/treinamento';
import { TreinamentoService } from 'src/app/services/treinamento.service';


import { Profissional } from '../../entities/profissional';
import { ProfissionalService } from '../../services/profissional.service';
import { Resultado } from 'src/app/entities/resultado';
import { ResultadoService } from 'src/app/services/resultado.service';
import { TurmaService } from 'src/app/services/turma.service';
import { Turma } from 'src/app/entities/turma';

@Component({
  selector: 'app-profissional',
  templateUrl: './profissional.component.html',
  styleUrls: ['./profissional.component.css']
})
export class ProfissionalComponent implements OnInit{

  public profissionais: Profissional[] = [];
  public usuarios: Usuario[] = [];
  public treinamentos: Treinamento[] = [];
  public turmas: Turma[] = [];
  public resultados: Resultado[] = [];


  public addProfissional: Profissional = new Profissional();
  public editProfissional: Profissional = new Profissional();
  public deleteProfissional: Profissional = new Profissional();

  constructor(private ProfissionalService: ProfissionalService, private UsuarioService: UsuarioService, private TreinamentoService: TreinamentoService, private TurmaService: TurmaService, private ResultadoService: ResultadoService){}

  ngOnInit(){
    this.getProfissionais();
    this.getUsuarios();
    this.getTreinamentos();
    this.getTurmas();
    this.getResultados();
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

  public getUsuarios(): void {
    this.UsuarioService.listUsuarios().subscribe(
      (response: Usuario[]) => {
        this.usuarios = response;
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

  public getTurmas(): void {
    this.TurmaService.listTurmas().subscribe(
      (response: Turma[]) => {
        this.turmas = response;
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

  public onAddProfissional(addForm: NgForm): void {
    document.getElementById('close-add-Profissional-form')!.click();
    this.ProfissionalService.addProfissional(addForm.value).subscribe(
      (response: Profissional) => {
        this.getProfissionais();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdateProfissional(profissional: Profissional): void {
    this.ProfissionalService.updateProfissional(profissional).subscribe(
      (response: Profissional) => {
        this.getProfissionais();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteProfissional(profissionalId: number): void {
    this.ProfissionalService.deleteProfissional(profissionalId).subscribe(
      (response: void) => {
        this.getProfissionais();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public searchProfissionais(key: string): void {
    const results: Profissional[] = [];
    for (const profissional of this.profissionais) {
      if (profissional.nomeCompleto.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        results.push(profissional);
      }
    }
    this.profissionais = results;
    if (results.length === 0 || !key) {
      this.getProfissionais();
    }
  }


  public onOpenModal(Profissional: Profissional, mode: string): void {
    
    const container = document.getElementById('main-container')!;
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
  
    if (mode === 'add'){
      button.setAttribute('data-target', '#addProfissionalModal');
    }
  
    if (mode === 'edit'){
      this.editProfissional = Profissional;
      button.setAttribute('data-target', '#editProfissionalModal');
    }
  
    if (mode === 'delete'){
      this.deleteProfissional = Profissional;
      button.setAttribute('data-target', '#deleteProfissionalModal');
    }
  
    container.appendChild(button);
    button.click();
  
  }
}
