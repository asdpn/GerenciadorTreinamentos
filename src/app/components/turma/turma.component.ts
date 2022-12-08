import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Turma } from '../../entities/turma';
import { TurmaService } from '../../services/turma.service';

@Component({
  selector: 'app-turma',
  templateUrl: './turma.component.html',
  styleUrls: ['./turma.component.css']
})
export class TurmaComponent  implements OnInit {

  public turmas: Turma[] = [];
  public addTurma: Turma = new Turma();
  public editTurma: Turma = new Turma();
  public deleteTurma: Turma = new Turma();

  constructor(private TurmaService: TurmaService){}

  ngOnInit(){
    this.getTurmas();
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

  public onAddTurma(addForm: NgForm): void {
    document.getElementById('close-add-Turma-form')!.click();
    this.TurmaService.addTurma(addForm.value).subscribe(
      (response: Turma) => {
        this.getTurmas();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdateTurma(Turma: Turma): void {
    this.TurmaService.updateTurma(Turma).subscribe(
      (response: Turma) => {
        this.getTurmas();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteTurma(TurmaId: number): void {
    this.TurmaService.deleteTurma(TurmaId).subscribe(
      (response: void) => {
        this.getTurmas();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public searchTurmas(key: string): void {
    const results: Turma[] = [];
    for (const Turma of this.turmas) {
      if (Turma.titulo.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        results.push(Turma);
      }
    }
    this.turmas = results;
    if (results.length === 0 || !key) {
      this.getTurmas();
    }
  }


  public onOpenModal(Turma: Turma, mode: string): void {
    
    const container = document.getElementById('main-container')!;
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
  
    if (mode === 'add'){
      button.setAttribute('data-target', '#addTurmaModal');
    }
  
    if (mode === 'edit'){
      this.editTurma = Turma;
      button.setAttribute('data-target', '#editTurmaModal');
    }
  
    if (mode === 'delete'){
      this.deleteTurma = Turma;
      button.setAttribute('data-target', '#deleteTurmaModal');
    }
  
    container.appendChild(button);
    button.click();
  
  }
}
