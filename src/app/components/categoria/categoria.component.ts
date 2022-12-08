import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Categoria } from '../../entities/categoria';
import { CategoriaService } from '../../services/categoria.service';
import { Treinamento } from '../../entities/treinamento';
import { TreinamentoService } from '../../services/treinamento.service';

@Component({
  selector: 'app-categoria',
  templateUrl: 'categoria.component.html',
  styleUrls: ['./categoria.component.css']
})
export class CategoriaComponent implements OnInit{

  public categorias: Categoria[] = [];
  public treinamentos: Treinamento[] = [];

  public addCategoria: Categoria = new Categoria();
  public editCategoria: Categoria = new Categoria();
  public deleteCategoria: Categoria = new Categoria();

  constructor(private categoriaService: CategoriaService, private TreinamentoService: TreinamentoService){}

  ngOnInit(){
    this.getCategorias();
    this.getTreinamentos();
  }  

  public getCategorias(): void {
    this.categoriaService.listCategorias().subscribe(
      (response: Categoria[]) => {
        this.categorias = response;
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

  public onAddCategoria(addForm: NgForm): void {
    document.getElementById('close-add-categoria-form')!.click();
    this.categoriaService.addCategoria(addForm.value).subscribe(
      (response: Categoria) => {
        this.getCategorias();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdateCategoria(categoria: Categoria): void {
    this.categoriaService.updateCategoria(categoria).subscribe(
      (response: Categoria) => {
        this.getCategorias();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteCategoria(categoriaId: number): void {
    this.categoriaService.deleteCategoria(categoriaId).subscribe(
      (response: void) => {
        this.getCategorias();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public searchCategorias(key: string): void {
    const results: Categoria[] = [];
    for (const categoria of this.categorias) {
      if (categoria.titulo.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        results.push(categoria);
      }
    }
    this.categorias = results;
    if (results.length === 0 || !key) {
      this.getCategorias();
    }
  }


  public onOpenModal(categoria: Categoria, mode: string): void {
    
    const container = document.getElementById('main-container')!;
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
  
    if (mode === 'add'){
      button.setAttribute('data-target', '#addCategoriaModal');
    }
  
    if (mode === 'edit'){
      this.editCategoria = categoria;
      button.setAttribute('data-target', '#editCategoriaModal');
    }
  
    if (mode === 'delete'){
      this.deleteCategoria = categoria;
      button.setAttribute('data-target', '#deleteCategoriaModal');
    }
  
    container.appendChild(button);
    button.click();
  
  }
}
