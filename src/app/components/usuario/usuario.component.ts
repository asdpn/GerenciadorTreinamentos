import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Permissao } from 'src/app/entities/enums/permissao.enum';
import { Profissional } from 'src/app/entities/profissional';
import { ProfissionalService } from 'src/app/services/profissional.service';
import { UsuarioService } from 'src/app/services/usuario.service';
import { Usuario } from '../../entities/usuario';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css']
})
export class UsuarioComponent implements OnInit{

  public usuarios: Usuario[] = [];
  public profissionais: Profissional[] = [];
  public permissoes: Permissao[] = [Permissao.GERENTE, Permissao.PALESTRANTE, Permissao.PROFISSIONAL];
  
  public addUsuario: Usuario = new Usuario();
  public editUsuario: Usuario = new Usuario();
  public deleteUsuario: Usuario = new Usuario();

  constructor(private UsuarioService: UsuarioService, private ProfissionalService: ProfissionalService){}

  ngOnInit(){
    this.getUsuarios();
    this.getProfissionais();
  }  

  public getUsuarios(): void {
    this.UsuarioService.listUsuarios().subscribe(
      (response: Usuario[]) => {
        this.usuarios = response;
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

  public onAddUsuario(addForm: NgForm): void {
    document.getElementById('close-add-Usuario-form')!.click();
    this.UsuarioService.addUsuario(addForm.value).subscribe(
      (response: Usuario) => {
        this.getUsuarios();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdateUsuario(Usuario: Usuario): void {
    this.UsuarioService.updateUsuario(Usuario).subscribe(
      (response: Usuario) => {
        this.getUsuarios();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteUsuario(UsuarioId: number): void {
    this.UsuarioService.deleteUsuario(UsuarioId).subscribe(
      (response: void) => {
        this.getUsuarios();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public searchUsuarios(key: string): void {
    const results: Usuario[] = [];
    for (const usuario of this.usuarios) {
      if (usuario.nomeUsuario.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        results.push(usuario);
      }
    }
    this.usuarios = results;
    if (results.length === 0 || !key) {
      this.getUsuarios();
    }
  }


  public onOpenModal(Usuario: Usuario, mode: string): void {
    
    const container = document.getElementById('main-container')!;
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
  
    if (mode === 'add'){
      button.setAttribute('data-target', '#addUsuarioModal');
    }
  
    if (mode === 'edit'){
      this.editUsuario = Usuario;
      button.setAttribute('data-target', '#editUsuarioModal');
    }
  
    if (mode === 'delete'){
      this.deleteUsuario = Usuario;
      button.setAttribute('data-target', '#deleteUsuarioModal');
    }
  
    container.appendChild(button);
    button.click();
  
  }
}
