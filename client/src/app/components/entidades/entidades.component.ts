import { Component, OnInit } from "@angular/core";
import { Entidades } from "src/app/models/Entidades";
import { EntidadService } from "src/app/services/entidad.service";
import Swal from "sweetalert2";

@Component({
  selector: 'app-entidades',
  templateUrl: 'entidades.component.html',
  styleUrls: ['entidades.component.css'],
})
export class EntidadesComponent implements OnInit{
  entidades: Entidades[] = []
  currentEntidad = {} as Entidades
  constructor(private entidadServicio: EntidadService) { }
  ngOnInit(): void {
    this.obtenerEntidades()
    this.count();
  }

  private obtenerEntidades() {
    this.entidadServicio.listaEntidades().subscribe(data => {
      this.entidades = data;
    })
  }

  count(): number {
    let res = this.entidades.length
    return res;
  }

  delete(id: number): void {
    this.entidadServicio.borrarEntidad(id).subscribe( _data =>{
      Swal.fire('Se eliminó correctamente').then(
        function(){
          window.location.reload()
        },
        function(dismiss){
          window.location.reload()
        })
    })
  }

  buscarEntidad(id: number) {
    this.entidadServicio.buscarEntidad(id).subscribe(data => {
      this.currentEntidad = data
    })
  }
}
