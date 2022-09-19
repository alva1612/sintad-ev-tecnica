import { TipoContribuyente } from "./TipoContribuyente";
import { TipoDocumento } from "./TipoDocumento";

export interface Entidades {
  id: number;
  tipoDocumento: TipoDocumento;
  numdocumento: string;
  razonSocial: string;
  nomComercial: string;
  tipoContribuyente: TipoContribuyente;
  direccion:  string;
  telefono: string;
  estado: boolean;

}
