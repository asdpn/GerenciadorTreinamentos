import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { StatusResultado } from '../../entities/enums/statusResultado.enum';
import { Resultado } from '../../entities/resultado';
import { ResultadoService } from '../../services/resultado.service';
//import { Certificado } from '../../entities/certificado';
//import { CertificadoService } from '../../services/certificado.service';
import { Prova } from '../../entities/prova';
import { ProvaService } from '../../services/prova.service';
import { Profissional } from 'src/app/entities/profissional';
import { ProfissionalService } from 'src/app/services/profissional.service';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-resultado',
  templateUrl: './resultado.component.html',
  styleUrls: ['./resultado.component.css']
})
export class ResultadoComponent implements OnInit {

  public resultados: Resultado[] = [];
  public provas: Prova[] = [];
  public profissionais: Profissional[] = [];  
  public statusResultados: StatusResultado[] = [StatusResultado.APROVADO, StatusResultado.CRIADO, StatusResultado.REPROVADO];

  public addResultado: Resultado = new Resultado();
  public editResultado: Resultado = new Resultado();
  public deleteResultado: Resultado = new Resultado();
  public isGerente = false;
  public isPalestrante = false;

  constructor(private ResultadoService: ResultadoService, private ProvaService: ProvaService, private ProfissionalService: ProfissionalService, private athenticationService: AuthenticationService){
    this.isGerente = this.athenticationService.isGerente;
    this.isPalestrante = this.athenticationService.isPalestrante;
  }


  ngOnInit(){
    this.getResultados();
    this.getProvas();
    this.getProfissionais();
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
    this.ProvaService.listProvas().subscribe(
      (response: Prova[]) => {
        this.provas = response;
      },
      (error: HttpErrorResponse) =>{
        alert(error.message);
      }
    )
  }

  public onAddResultado(addForm: NgForm): void {
    document.getElementById('close-add-Resultado-form')!.click();
    this.ResultadoService.addResultado(addForm.value).subscribe(
      (response: Resultado) => {
        this.getResultados();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdateResultado(Resultado: Resultado): void {
    this.ResultadoService.updateResultado(Resultado).subscribe(
      (response: Resultado) => {
        this.getResultados();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteResultado(ResultadoId: number): void {
    this.ResultadoService.deleteResultado(ResultadoId).subscribe(
      (response: void) => {
        this.getResultados();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public searchResultados(key: string): void {
    const results: Resultado[] = [];
    for (const Resultado of this.resultados) {
      if (Resultado.titulo.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        results.push(Resultado);
      }
    }
    this.resultados = results;
    if (results.length === 0 || !key) {
      this.getResultados();
    }
  }


  public onOpenModal(Resultado: Resultado, mode: string): void {
    
    const container = document.getElementById('main-container')!;
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
  
    if (mode === 'add'){
      button.setAttribute('data-target', '#addResultadoModal');
    }
  
    if (mode === 'edit'){
      this.editResultado = Resultado;
      button.setAttribute('data-target', '#editResultadoModal');
    }
  
    if (mode === 'delete'){
      this.deleteResultado = Resultado;
      button.setAttribute('data-target', '#deleteResultadoModal');
    }
  
    container.appendChild(button);
    button.click();
  
  }
}
