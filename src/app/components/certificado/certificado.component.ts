import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { StatusCertificado } from '../../entities/enums/statusCertificado.enum';
import { Certificado } from '../../entities/certificado';
import { CertificadoService } from '../../services/certificado.service';
import { ResultadoService } from '../../services/resultado.service';
import { Resultado } from 'src/app/entities/resultado';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-certificado',
  templateUrl: './certificado.component.html',
  styleUrls: ['./certificado.component.css']
})

export class CertificadoComponent implements OnInit{

  public certificados: Certificado[] = [];
  public resultados: Resultado[] = [];
  public statusCertificados: StatusCertificado[]=[StatusCertificado.CRIADO, StatusCertificado.ENVIADO, StatusCertificado.VALIDADO];
;  
  public addCertificado: Certificado = new Certificado();
  public editCertificado: Certificado = new Certificado();
  public deleteCertificado: Certificado = new Certificado();
  public isGerente = false;

  constructor(private CertificadoService: CertificadoService, private ResultadoService: ResultadoService, private athenticationService: AuthenticationService){
    this.isGerente = this.athenticationService.isGerente;
  }

  ngOnInit(){
    this.getCertificados();
    this.getResultados();
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
