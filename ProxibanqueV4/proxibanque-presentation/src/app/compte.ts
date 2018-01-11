import { Client } from "./client";

//Classe compte
export class Compte {
    numero: number;
    solde: number;
    type: string;
    date_ouverture:Date; 
    decouvert: number;
    taux: number;
    client: Client;
  }