import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Entidades } from '../models/Entidades';
import { Message } from '../models/Message';

@Injectable({
  providedIn: 'root'
})
export class EntidadService {

  private baseURL = "http://localhost:8090/entidad"

  constructor(private httpclient: HttpClient) { }

  listaEntidades(): Observable<Entidades[]> {
    return this.httpclient.get<Entidades[]>(`${this.baseURL}`)
  }
  guardarEntidad(entidad: Entidades): Observable<any> {
    return this.httpclient.post<Entidades>(this.baseURL, entidad)
  }
  borrarEntidad(id: number): Observable<Entidades> {
    return this.httpclient.delete<Entidades>(`${this.baseURL}/${id}`)
  }
  buscarEntidad(id: number): Observable<Entidades> {
    return this.httpclient.get<Entidades>(`${this.baseURL}/${id}`)
  }
  actualizarEntidad(entidad: Entidades): Observable<any> {
    return this.httpclient.put<Entidades>(`${this.baseURL}`, entidad)
  }

}
