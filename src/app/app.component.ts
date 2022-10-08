import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Categoria } from './categoria';
import { CategoriaService } from './categoria.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  public categorias: Categoria[] = [];

  ngOnInit(){
    this.getCategorias();
  }
  
  constructor(private categoriaService: CategoriaService){}

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
}
