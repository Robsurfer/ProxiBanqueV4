import { Employe } from "./employe";

export class Virement {
    id : number;
    conseiller: Employe;
    compteEmetteur: string;
    compteCible: string;
    montant: number;
    dateVirement: Date;
    libelle: string;

}