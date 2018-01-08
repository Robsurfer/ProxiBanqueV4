insert into Conseiller(login,password,nom,prenom) values ('Conseiller1','password1','Potter','Harry');
insert into Conseiller(login,password,nom,prenom) values ('Conseiller2','password2','Whisley','Ron');
insert into Conseiller(login,password,nom,prenom) values ('Conseiller3','password3','Granger','Hermione');
insert into Conseiller(login,password,nom,prenom) values ('1','1','Bunny','Bugs');

insert into Client(id_client,nom,prenom,adresse,code_postal,ville,telephone,mail,login_conseiller) values(seq_client.nextval,'SARKOZY','Nicolas','10 rue de larnaque','75005','paris','0126597820','arnaqueur@devieux.com','Conseiller1');
insert into Client(id_client,nom,prenom,adresse,code_postal,ville,telephone,mail,login_conseiller) values(seq_client.nextval,'HOLLANDE','Francois','10 rue de la mollesse','75005','paris','0226597820','zerocharisme@flan.com','Conseiller1');
insert into Client(id_client,nom,prenom,adresse,code_postal,ville,telephone,mail,login_conseiller) values(seq_client.nextval,'MACRON','Emmanuel','10 rue de largent','75005','paris','0326597820','pourlesriches@jetprivee.com','Conseiller2');
insert into Client(id_client,nom,prenom,adresse,code_postal,ville,telephone,mail,login_conseiller) values(seq_client.nextval,'MELANCHON','JL','10 rue de la revolte','75005','paris','0426597820','insoumis@revolution.com','Conseiller2');
insert into Client(id_client,nom,prenom,adresse,code_postal,ville,telephone,mail,login_conseiller) values(seq_client.nextval,'LEPEN','Marine','10 rue de la racaille','75005','paris','0526597820','pourzerzer@france.com','Conseiller1');

insert into Compte(numero_compte,solde,date_ouverture,type_compte,decouvert,taux,id_client) values (seq_compte.nextval,5875,sysdate, 'courant', 1000, 0, 1);
insert into Compte(numero_compte,solde,date_ouverture,type_compte,decouvert,taux,id_client) values (seq_compte.nextval,10000,sysdate, 'epargne', 0, 0.5, 2);
insert into Compte(numero_compte,solde,date_ouverture,type_compte,decouvert,taux,id_client) values (seq_compte.nextval,60000,sysdate, 'epargne', 0, 0.5, 1);
insert into Compte(numero_compte,solde,date_ouverture,type_compte,decouvert,taux,id_client) values (seq_compte.nextval,1000,sysdate, 'courant', 1000, 0, 3);
insert into Compte(numero_compte,solde,date_ouverture,type_compte,decouvert,taux,id_client) values (seq_compte.nextval,5875,sysdate, 'courant', 1000, 0, 4);
insert into Compte(numero_compte,solde,date_ouverture,type_compte,decouvert,taux,id_client) values (seq_compte.nextval,20000,sysdate, 'epargne', 0, 0.5, 4);

insert into Virement(id_virement,num_compte_debiteur,num_compte_crediteur,montant,date_virement,login_conseiller) values (seq_virement.nextval,1001,1002,212,sysdate, 'Conseiller1');
insert into Virement(id_virement,num_compte_debiteur,num_compte_crediteur,montant,date_virement,login_conseiller) values (seq_virement.nextval,1000,1002,12,sysdate, 'Conseiller1');
insert into Virement(id_virement,num_compte_debiteur,num_compte_crediteur,montant,date_virement,login_conseiller) values (seq_virement.nextval,1004,1002,121,sysdate, 'Conseiller2');
insert into Virement(id_virement,num_compte_debiteur,num_compte_crediteur,montant,date_virement,login_conseiller) values (seq_virement.nextval,1002,1005,100,sysdate, 'Conseiller2');

commit;