import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Profissional } from '../../entities/profissional';
import { ProfissionalService } from '../../services/profissional.service';

@Component({
  selector: 'app-profissional',
  templateUrl: './profissional.component.html',
  styleUrls: ['./profissional.component.css']
})
export class ProfissionalComponent implements OnInit{

  public profissionais: Profissional[] = [];
  public addProfissional: Profissional = {id:0, nomeCompleto: "", empresa: "", email: "", telefone: "", senha: "", funcao: Funcao};
  public editProfissional: Profissional = {id:0, nomeCompleto: "", empresa: "", email: "", telefone: "", senha: "", funcao: Funcao};
  public deleteProfissional: Profissional = {id:0, nomeCompleto: "", empresa: "", email: "", telefone: "", senha: "", funcao: Funcao};

  constructor(private ProfissionalService: ProfissionalService){}

  ngOnInit(){
    this.getProfissionais();
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
