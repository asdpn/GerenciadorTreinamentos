import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { StatusTreinamento } from '../../entities/enums/statusTreinamento.enum';
import { Treinamento } from '../../entities/treinamento';
import { TreinamentoService } from '../../services/treinamento.service';
import { Categoria } from '../../entities/categoria';
import { CategoriaService } from '../../services/categoria.service';
import { Turma } from 'src/app/entities/turma';
import { TurmaService } from 'src/app/services/turma.service';
import { Convite } from '../../entities/convite';
import { ConviteService } from '../../services/convite.service';
import { Prova } from 'src/app/entities/prova';
import { ProvaService } from 'src/app/services/prova.service';
import { Profissional } from '../../entities/profissional';
import { ProfissionalService } from '../../services/profissional.service';

@Component({
  selector: 'app-treinamento',
  templateUrl: './treinamento.component.html',
  styleUrls: ['./treinamento.component.css']
})
export class TreinamentoComponent implements OnInit{

  public treinamentos: Treinamento[] = [];
  public categorias: Categoria[] = [];
  public turmas: Turma[] = [];
  public convites: Convite[] = [];
  public provas: Prova[] = [];
  public profissionais: Profissional[] = [];
  public statusTreinamento: StatusTreinamento[]=[StatusTreinamento.AGENDADO, StatusTreinamento.CRIADO, StatusTreinamento.FINALIZADO];


  public addTreinamento: Treinamento = new Treinamento();
  public editTreinamento: Treinamento = new Treinamento();
  public deleteTreinamento: Treinamento = new Treinamento();

  constructor(private TreinamentoService: TreinamentoService, private categoriaService: CategoriaService, private TurmaService: TurmaService, private ConviteService: ConviteService, private ProvaService: ProvaService, private ProfissionalService: ProfissionalService){}

  ngOnInit(){
    this.getTreinamentos();
    this.getCategorias();
    this.getTurmas();
    this.getConvites();
    this.getProvas();
    this.getProfissionais();

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

  public getCategorias(): void {
    this.categoriaService.listCategorias().subscribe(
      (response: Categoria[]) => {
        this.categorias = response;
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

  public getConvites(): void {
    this.ConviteService.listConvites().subscribe(
      (response: Convite[]) => {
        this.convites = response;
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
