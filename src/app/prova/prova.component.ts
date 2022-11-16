import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Prova } from './prova';
import { ProvaService } from './prova.service';

@Component({
  selector: 'app-root',
  templateUrl: 'prova.html',
  styleUrls: ['../app.component.css']
})
export class ProvaComponent {

  public provas: Prova[] = [];
  public addProva: Prova = {id:0, titulo: "", statusProva: StatusProva.CRIADO, resultado: Resultado};
  public editProva: Prova = {id:0, titulo: "", statusProva: StatusProva.CRIADO, resultado: []};
  public deleteProva: Prova = {id:0, titulo: "", statusProva: StatusProva.CRIADO, resultado: []};

  constructor(private ProvaService: ProvaService){}

  ngOnInit(){
    this.getProvas();
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
