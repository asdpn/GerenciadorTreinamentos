import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Treinamento } from 'src/app/entities/treinamento';
import { TreinamentoService } from 'src/app/services/treinamento.service';
import { Convite } from '../../entities/convite';
import { ConviteService } from '../../services/convite.service';

@Component({
  selector: 'app-convite',
  templateUrl: './convite.component.html',
  styleUrls: ['./convite.component.css']
})
export class ConviteComponent implements OnInit{

  public convites: Convite[] = [];
  public treinamentos: Treinamento[] = [];
  
  public addConvite: Convite = new Convite();
  public editConvite: Convite = new Convite();
  public deleteConvite: Convite = new Convite();

  constructor(private ConviteService: ConviteService, private TreinamentoService : TreinamentoService){}

  ngOnInit(){
    this.getConvites();
    this.getTreinamentos();
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
      this.editConvite = convite;
      button.setAttribute('data-target', '#editConviteModal');
    }
  
    if (mode === 'delete'){
      this.deleteConvite = convite;
      button.setAttribute('data-target', '#deleteConviteModal');
    }
  
    container.appendChild(button);
    button.click();
  
  }
}
