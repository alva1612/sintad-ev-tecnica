import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { TipoDocumento } from '../models/TipoDocumento';

@Injectable({
  providedIn: 'root'
})
export class TipoDocumentoService {

  private baseURL = "http://localhost:8090/tdocumento"

  constructor(private httpclient: HttpClient) { }

  listaTipoDoc(): Observable<TipoDocumento[]> {
    return this.httpclient.get<TipoDocumento[]>(`${this.baseURL}`)
  }
}
