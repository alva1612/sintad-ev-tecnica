import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { TipoContribuyente } from '../models/TipoContribuyente';

@Injectable({
  providedIn: 'root'
})
export class TipoContribuyenteService {

  private baseURL = "http://localhost:8090/tcontribuyente"

  constructor(private httpclient:  HttpClient) { }

  listaTipos(): Observable<TipoContribuyente[]> {
    return this.httpclient.get<TipoContribuyente[]>(`${this.baseURL}`)
  }
}
