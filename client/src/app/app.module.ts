import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { EntidadesComponent } from './components/entidades/entidades.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { EditComponent } from './components/entidades/edit/edit.component';
import { HttpClientModule } from '@angular/common/http';
import { AddComponent } from './components/entidades/add/add.component';
import { TiposContribuyenteComponent } from './components/tipos-contribuyente/tipos-contribuyente.component';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './components/security/login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    EntidadesComponent,
    EditComponent,
    AddComponent,
    TiposContribuyenteComponent,
    LoginComponent,

  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
