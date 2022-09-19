import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Entidades } from 'src/app/models/Entidades';
import { Message } from 'src/app/models/Message';
import { TipoContribuyente } from 'src/app/models/TipoContribuyente';
import { TipoDocumento } from 'src/app/models/TipoDocumento';
import { EntidadService } from 'src/app/services/entidad.service';
import { TipoContribuyenteService } from 'src/app/services/tipo-contribuyente.service';
import { TipoDocumentoService } from 'src/app/services/tipo-documento.service';
import Swal from 'sweetalert2'

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  tiposDoc: TipoDocumento[] = [{
    id: 0,
    nombre: 'Prueba',
    estado: false,
    codigo: '',
    descripcion: ''
  },]
  tiposCont: TipoContribuyente[] = [{
    id: 0,
    estado: false,
    nombre: ''
  }]

  nuevaEntidad = {} as Entidades

  constructor(private tipoDocServicio: TipoDocumentoService,
              private tipoContServicio: TipoContribuyenteService,
              private entidadService: EntidadService) { }

  ngOnInit(): void {
    this.obtenerTipos()
  }

  private obtenerTipos() {
    this.tipoContServicio.listaTipos().subscribe(data => {
      this.tiposCont = data
    });
    this.tipoDocServicio.listaTipoDoc().subscribe(data => {
      this.tiposDoc = data
    })
  }

  Guardar(nuevaEntidad: Entidades) {
    this.entidadService.guardarEntidad(nuevaEntidad).subscribe((data: Message) => {
      Swal.fire('Se guardó correctamente', data.mensaje).then(
      function(){
        window.location.reload()
      },
      function(dismiss){
        window.location.reload()
      })
    })
  }

}
