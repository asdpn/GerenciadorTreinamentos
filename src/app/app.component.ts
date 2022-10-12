import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Categoria } from './categoria';
import { CategoriaService } from './categoria.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  public categorias: Categoria[] = [];
  public addCategoria: Categoria = {id:0, descricao: ""};
  public editCategoria: Categoria = {id:0, descricao: ""};
  public deleteCategoria: Categoria = {id:0, descricao: ""};

  constructor(private categoriaService: CategoriaService){}

  ngOnInit(){
    this.getCategorias();
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

  public onAddCategoria(addForm: NgForm): void {
    document.getElementById('add-categoria-form')!.click();
    this.categoriaService.addCategoria(addForm.value).subscribe(
      (response: Categoria) => {
        console.log(response);
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
        console.log(response);
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
        console.log(response);
        this.getCategorias();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public searchCategorias(key: string): void {
    console.log(key);
    const results: Categoria[] = [];
    for (const categoria of this.categorias) {
      if (categoria.descricao.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
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
