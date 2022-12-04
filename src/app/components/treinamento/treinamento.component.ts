import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { StatusTreinamento } from '../../entities/enums/statusTreinamento.enum';
import { Treinamento } from '../../entities/treinamento';
import { TreinamentoService } from '../../services/treinamento.service';

@Component({
  selector: 'app-treinamento',
  templateUrl: './treinamento.component.html',
  styleUrls: ['./treinamento.component.css']
})
export class TreinamentoComponent implements OnInit{

  public treinamentos: Treinamento[] = [];
  public addTreinamento: Treinamento = {id:0, titulo: "", descricao: "", statusTreinamento: StatusTreinamento.AGENDADO, categoria: Categoria, turma: Turma, convite: Convite, provas: Prova[], profissionais: Profissional[]};
  public editTreinamento: Treinamento = {id:0, titulo: "", descricao: "", statusTreinamento: StatusTreinamento.AGENDADO, categoria: Categoria, turma: Turma, convite: Convite, provas: Prova[], profissionais: Profissional[]};
  public deleteTreinamento: Treinamento = {id:0, titulo: "", descricao: "", statusTreinamento: StatusTreinamento.AGENDADO, categoria: Categoria, turma: Turma, convite: Convite, provas: Prova[], profissionais: Profissional[]};

  constructor(private TreinamentoService: TreinamentoService){}

  ngOnInit(){
    this.getTreinamentos();
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

  public onAddTreinamento(addForm: NgForm): void {
    document.getElementById('close-add-Treinamento-form')!.click();
    this.TreinamentoService.addTreinamento(addForm.value).subscribe(
      (response: Treinamento) => {
        this.getTreinamentos();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdateTreinamento(Treinamento: Treinamento): void {
    this.TreinamentoService.updateTreinamento(Treinamento).subscribe(
      (response: Treinamento) => {
        this.getTreinamentos();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteTreinamento(TreinamentoId: number): void {
    this.TreinamentoService.deleteTreinamento(TreinamentoId).subscribe(
      (response: void) => {
        this.getTreinamentos();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public searchTreinamentos(key: string): void {
    const results: Treinamento[] = [];
    for (const Treinamento of this.treinamentos) {
      if (Treinamento.titulo.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        results.push(Treinamento);
      }
    }
    this.treinamentos = results;
    if (results.length === 0 || !key) {
      this.getTreinamentos();
    }
  }


  public onOpenModal(Treinamento: Treinamento, mode: string): void {
    
    const container = document.getElementById('main-container')!;
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
  
    if (mode === 'add'){
      button.setAttribute('data-target', '#addTreinamentoModal');
    }
  
    if (mode === 'edit'){
      this.editTreinamento = Treinamento;
      button.setAttribute('data-target', '#editTreinamentoModal');
    }
  
    if (mode === 'delete'){
      this.deleteTreinamento = Treinamento;
      button.setAttribute('data-target', '#deleteTreinamentoModal');
    }
  
    container.appendChild(button);
    button.click();
  
  }
}
