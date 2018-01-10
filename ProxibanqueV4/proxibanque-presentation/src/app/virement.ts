import { Employe } from "./employe";
import { Compte } from "./compte";

export class Virement {
    id : number;
    conseiller: Employe;
    compteEmetteur: Compte;
    compteCible: Compte;
    montant: number;
    dateVirement: Date;
    libelle: string;

}