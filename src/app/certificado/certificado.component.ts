import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { StatusCertificado } from '../statusCertificado.enum';
import { Certificado } from './certificado';
import { CertificadoService } from './certificado.service';

@Component({
  selector: 'app-root',
  templateUrl: 'certificado.html',
  styleUrls: ['../app.component.css']
})
export class CertificadoComponent {

  public certificados: Certificado[] = [];
  public addCertificado: Certificado = {id:0, titulo: "", statusCertificado: StatusCertificado.CRIADO, resultado: Resultado};
  public editCertificado: Certificado = {id:0, titulo: "", statusCertificado: StatusCertificado.CRIADO, resultado: []};
  public deleteCertificado: Certificado = {id:0, titulo: "", statusCertificado: StatusCertificado.CRIADO, resultado: []};

  constructor(private CertificadoService: CertificadoService){}

  ngOnInit(){
    this.getCertificados();
  }  

  public getCertificados(): void {
    this.CertificadoService.listCertificados().subscribe(
      (response: Certificado[]) => {
        this.certificados = response;
      },
      (error: HttpErrorResponse) =>{
        alert(error.message);
      }
    )
  }

  public onAddCertificado(addForm: NgForm): void {
    document.getElementById('close-add-certificado-form')!.click();
    this.CertificadoService.addCertificado(addForm.value).subscribe(
      (response: Certificado) => {
        this.getCertificados();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdateCertificado(certificado: Certificado): void {
    this.CertificadoService.updateCertificado(certificado).subscribe(
      (response: Certificado) => {
        this.getCertificados();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteCertificado(certificadoId: number): void {
    this.CertificadoService.deleteCertificado(certificadoId).subscribe(
      (response: void) => {
        this.getCertificados();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public searchCertificados(key: string): void {
    const results: Certificado[] = [];
    for (const certificado of this.certificados) {
      if (certificado.titulo.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        results.push(certificado);
      }
    }
    this.certificados = results;
    if (results.length === 0 || !key) {
      this.getCertificados();
    }
  }


  public onOpenModal(certificado: Certificado, mode: string): void {
    
    const container = document.getElementById('main-container')!;
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
  
    if (mode === 'add'){
      button.setAttribute('data-target', '#addCertificadoModal');
    }
  
    if (mode === 'edit'){
      this.editCertificado = certificado;
      button.setAttribute('data-target', '#editCertificadoModal');
    }
  
    if (mode === 'delete'){
      this.deleteCertificado = certificado;
      button.setAttribute('data-target', '#deleteCertificadoModal');
    }
  
    container.appendChild(button);
    button.click();
  
  }
}
