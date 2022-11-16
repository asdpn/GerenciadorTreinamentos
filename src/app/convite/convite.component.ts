import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Convite } from './convite';
import { ConviteService } from './convite.service';

@Component({
  selector: 'app-root',
  templateUrl: 'convite.html',
  styleUrls: ['../app.component.css']
})
export class ConviteComponent {

  public convites: Convite[] = [];
  public addConvite: Convite = {id:0, titulo: "", statusconvite: Statusconvite.CRIADO, resultado: Resultado};
  public editConvite: Convite = {id:0, titulo: "", statusconvite: Statusconvite.CRIADO, resultado: []};
  public deleteConvite: Convite = {id:0, titulo: "", statusconvite: Statusconvite.CRIADO, resultado: []};

  constructor(private ConviteService: ConviteService){}

  ngOnInit(){
    this.getConvites();
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

  public onAddConvite(addForm: NgForm): void {
    document.getElementById('close-add-convite-form')!.click();
    this.ConviteService.addConvite(addForm.value).subscribe(
      (response: Convite) => {
        this.getConvites();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdateConvite(convite: Convite): void {
    this.ConviteService.updateConvite(convite).subscribe(
      (response: Convite) => {
        this.getConvites();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteConvite(conviteId: number): void {
    this.ConviteService.deleteConvite(conviteId).subscribe(
      (response: void) => {
        this.getConvites();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public searchConvites(key: string): void {
    const results: Convite[] = [];
    for (const convite of this.convites) {
      if (convite.titulo.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        results.push(convite);
      }
    }
    this.convites = results;
    if (results.length === 0 || !key) {
      this.getConvites();
    }
  }


  public onOpenModal(convite: Convite, mode: string): void {
    
    const container = document.getElementById('main-container')!;
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
  
    if (mode === 'add'){
      button.setAttribute('data-target', '#addConviteModal');
    }
  
    if (mode === 'edit'){
      this.editconvite = convite;
      button.setAttribute('data-target', '#editConviteModal');
    }
  
    if (mode === 'delete'){
      this.deleteconvite = convite;
      button.setAttribute('data-target', '#deleteConviteModal');
    }
  
    container.appendChild(button);
    button.click();
  
  }
}
