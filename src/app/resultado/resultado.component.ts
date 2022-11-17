import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { StatusResultado } from '../statusResultado.enum';
import { Resultado } from './resultado';
import { ResultadoService } from './resultado.service';

@Component({
  selector: 'app-root',
  templateUrl: 'resultado.html',
  styleUrls: ['../app.component.css']
})
export class ResultadoComponent {

  public resultados: Resultado[] = [];
  public addResultado: Resultado = {id:0, titulo: "", notaObtida: 0, statusResultado: StatusResultado.CRIADO, certificado: Certificado, prova: Prova};
  public editResultado: Resultado = {id:0, titulo: "", notaObtida: 0, statusResultado: StatusResultado.CRIADO, certificado: Certificado, prova: Prova};
  public deleteResultado: Resultado = {id:0, titulo: "", notaObtida: 0, statusResultado: StatusResultado.CRIADO, certificado: Certificado, prova: Prova};

  constructor(private ResultadoService: ResultadoService){}

  ngOnInit(){
    this.getResultados();
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
