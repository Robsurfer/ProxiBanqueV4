--Script de creation des tables de la base COMPTE

Prompt *************************************************************************************
Prompt CONNEXION A LA BASE DE DONNEES 

connect system/bourne;
drop user Hattmann cascade;
create user Hattmann identified by hattmann;
grant connect, create view, resource to Hattmann;
connect Hattmann/hattmann;

Prompt *************************************************************************************
Prompt LANCEMENT DU SCRIPT DE CREATION DE LA BASE PROXIBANQUE - VERSION 4 - JANVIER 2018



--SUPPRESSION DES TABLES
Prompt *************************************************************************************
Prompt SUPPRESSION DES TABLES
Prompt *************************************************************************************

drop table employe cascade constraints purge;
drop table client cascade constraints purge;
drop table compte cascade constraints purge;
drop table virement cascade constraints purge;



--CREATION DES TABLES

Prompt *************************************************************************************
Prompt CREATION DES TABLES
Prompt *************************************************************************************


Prompt CREATION DE LA TABLE EMPLOYE

create table employe
( login  	  varchar(30) constraint pk_employe primary key, 
  password	  varchar(4) UNIQUE,
  prenom      varchar(20),
  nom         varchar(20),
  role 		  varchar(10));
 

Prompt CREATION DE LA TABLE CLIENT

drop sequence sequencecli;
create sequence sequencecli
start with 1;

create table client
( id			 number constraint pk_client primary key,
  prenom     	 varchar(20),
  nom       	 varchar(20),
  adresse        varchar(60),
  code_postal    varchar(5),
  ville          varchar(30),
  telephone      varchar(10),
  mail			 varchar(40),
  conseiller     varchar(30) constraint fk_conseiller_client references employe(login));
  
Prompt CREATION DE LA TABLE COMPTE

create table compte
( numero	     	varchar(6) constraint pk_compte primary key,
  type_compte		varchar(7),
  client         	number constraint fk_client_compte references client(id),
  date_ouverture	date,
  solde          	number(10,2), 
  decouvert      	number(10,2),
  taux        	 	number(10,2));
  

Prompt CREATION DE LA TABLE VIREMENT

drop sequence sequencevir;
create sequence sequencevir
start with 1;

create table virement
( id        		number constraint pk_virement primary key,
  conseiller  		varchar(30) constraint fk_conseiller_virement references employe(login),
  compte_emetteur   varchar(6),
  compte_cible      varchar(6),
  montant        	number (10,2),
  date_virement		date,
  libelle		    varchar(30));



Prompt *************************************************************************************

--INSERTION DES DONNEES

Prompt INSERTION DES DONNEES
Prompt *************************************************************************************


Prompt INSERTION DANS EMPLOYE

delete from EMPLOYE;

insert into employe values ('gclaude','chef','Guillaume','Claude','gerant'); 
insert into employe values ('pdupond','toto','Paul','Dupond','conseiller'); 
insert into employe values ('jfontaine','tutu','Jean','Fontaine','conseiller');
insert into employe values ('rhoareau','titi','Remi','Hoareau','conseiller');
insert into employe values ('psanchez','tata','Pierre','Sanchez','conseiller');
insert into employe values ('pierre.sanchez','tyty','Pierre','Sanchez','conseiller');


Prompt INSERTION DANS CLIENT

delete from client;

insert into client values(sequencecli.nextval,'Maxwell','Sheffield','145 boulevard des capucins',75005,'paris','0126597820','msheff@free.com','pierre.sanchez');
insert into client values(sequencecli.nextval,'John','Wayne','15 rue de la boeme',75007,'PARIS','0135678712','jwayne@gmail.com','rhoareau');
insert into client values(sequencecli.nextval,'Richard','FOSTER','9 RUE DU lac',45900,'LA SOURCE','0302345698','r.foster@forbes.com','pdupond');
insert into client values(sequencecli.nextval,'Jean-Filipo ','DE LATTRE DE FRANCE','13 avenue des Tilleuls',92310,'SEVRES','0134568934',null,'jfontaine');
insert into client values(sequencecli.nextval,'Mamadou','FAYE','67 rue des maraichers',13008,'MARSEILLE','0456788932','m.faye@live.com','psanchez');
insert into client values(sequencecli.nextval,'Paul','PRAT','89 rue des chevreaux',33000,'BORDEAUX','0455237806','p.prat@oticien.com','jfontaine');
insert into client values(sequencecli.nextval,'Lucien','VIGOT','78 rue eisenberg',75005,'paris','0126597820',null,'psanchez');
insert into client values(sequencecli.nextval,'Hattmann','BELLEUS','15 rue de la boheme',75007,'PARIS','0135678712','h.belleus@gmail.com','pierre.sanchez');
insert into client values(sequencecli.nextval,'Guillaume','CAPET','1 RUE JEAN MERMOZ',45980,'VILLEGRAND','0302345698','capet.g@gmail.com','psanchez');
insert into client values(sequencecli.nextval,'Loriane','EYMANN','13 avenue des Tilleuls',92310,'SEVRES','0134568934',null,'psanchez');
insert into client values(sequencecli.nextval,'Stanislas','DESORGES','60 rue de Biarritz',13008,'MARSEILLE','0456788932','desorges@desorges.fr','rhoareau');
insert into client values(sequencecli.nextval,'Liang','PIU','85 place de la Republique',33000,'BORDEAUX','0486746478','l.piu@free.com','psanchez');
insert into client values(sequencecli.nextval,'Christian','DIOR','150 boulevard Saint-Etienne',95400,'Villiers-le-bel','0455237806','c.dior@gmail.com','psanchez');
insert into client values(sequencecli.nextval,'Rene','GAMBA','909 rue de la ligne droite',33000,'BORDEAUX','0466668066','r.gamba@gambacoustique.com','psanchez');
insert into client values(sequencecli.nextval,'Georges','THOMAS','110 place de la Bastille',33000,'BORDEAUX','0455230265','g.thomas@systra.com','psanchez');
insert into client values(sequencecli.nextval,'John','SMITH','square du petit marin',13008,'MARSEILLE','0356999013','jsmith@hotmail.fr','psanchez');

prompt INSERTION DANS COMPTE

delete from compte;

insert into compte values ('711010','courant',1,'26/11/2017',-1501.89,500.00,null);
insert into compte values ('718303','courant',3,'07/11/2017',1000000.50,500.00,null);
insert into compte values ('716562','courant',6,'18/11/2017',2500.00,500.00,null);
insert into compte values ('717417','courant',7,'06/11/2017',-100.00,500.00,null);
insert into compte values ('718456','courant',2,'26/11/2017',6400.78,500.00,null);
insert into compte values ('714302','courant',8,'26/11/2017',-610.60,500.00,null);
insert into compte values ('714878','courant',9,'26/11/2017',15000.00,500.00,null);
insert into compte values ('711045','courant',10,'26/11/2017',3530.00,500.00,null);
insert into compte values ('718167','courant',12,'26/11/2017',7530.00,500.00,null);
insert into compte values ('712264','courant',11,'26/11/2017',112000.90,500.00,null);
insert into compte values ('717694','courant',5,'26/11/2017',12500.00,500.00,null);
insert into compte values ('711987','courant',13,'26/11/2017',125000.00,500.00,null);
insert into compte values ('719485','courant',14,'26/11/2017',7139.36,500.00,null);
insert into compte values ('714009','courant',15,'26/11/2017',-1000.07,500.00,null);
insert into compte values ('728457','epargne',2,'26/11/2017',75000.00,null,3);
insert into compte values ('724695','epargne',4,'26/11/2017',10000000.00,null,3);
insert into compte values ('727610','epargne',5,'26/11/2017',800000.00,null,3);
insert into compte values ('724545','epargne',3,'26/11/2017',3000000.10,null,3);
insert into compte values ('727646','epargne',8,'26/11/2017',100000.09,null,3);
insert into compte values ('721026','epargne',10,'26/11/2017',45000.00,null,3);
insert into compte values ('728181','epargne',11,'26/11/2017',958000.37,null,3);
insert into compte values ('728246','epargne',12,'26/11/2017',8601.98,null,3);
insert into compte values ('729930','epargne',13,'26/11/2017',7823.09,null,3);
insert into compte values ('728327','epargne',14,'26/11/2017',802223.74,null,3);
insert into compte values ('722892','epargne',15,'26/11/2017',320937,null,3);
insert into compte values ('728263','epargne',16,'26/11/2017',8609483.25,null,3);

Prompt INSERTION DANS VIREMENT

delete from VIREMENT

insert into virement values (sequencevir.nextval,'psanchez','717694','727610',5000,add_months(sysdate,-3),'appro compte epargne'); 
insert into virement values (sequencevir.nextval,'pdupond','718303','724545',1000,add_months(sysdate,-1),'appro compte epargne'); 
insert into virement values (sequencevir.nextval,'psanchez','729930','711987',30000,add_months(sysdate,-3), null);
insert into virement values (sequencevir.nextval,'pdupond','718303','724545',156000,sysdate,'appro compte epargne');
insert into virement values (sequencevir.nextval,'pierre.sanchez','727646','714302',1200,add_months(sysdate,-3), null);
insert into virement values (sequencevir.nextval,'jfontaine','716562','714302',800,add_months(sysdate,-2), null);
insert into virement values (sequencevir.nextval,'jfontaine','724695','718303',50000.90,add_months(sysdate,-3), null); 
insert into virement values (sequencevir.nextval,'psanchez','711045','721026',11908.89,add_months(sysdate,-3), null); 
insert into virement values (sequencevir.nextval,'psanchez','714878','728263',9800,add_months(sysdate,-3), null);
insert into virement values (sequencevir.nextval,'psanchez','714878','717417',1000,add_months(sysdate,-3), null);
insert into virement values (sequencevir.nextval,'rhoareau','712264','728181',400000,sysdate, null);
insert into virement values (sequencevir.nextval,'psanchez','719485','728327',120000,add_months(sysdate,-2), null);
insert into virement values (sequencevir.nextval,'pierre.sanchez','727646','714302',1550,add_months(sysdate,-1), null); 
insert into virement values (sequencevir.nextval,'pdupond','718303','711987',12500,add_months(sysdate,-3), null); 
insert into virement values (sequencevir.nextval,'psanchez','717694','727610',15000,add_months(sysdate,-2),'appro compte epargne');
insert into virement values (sequencevir.nextval,'pdupond','718303','724545',50000,sysdate, null);
insert into virement values (sequencevir.nextval,'psanchez','719485','728327',140000,add_months(sysdate,-1), null);
insert into virement values (sequencevir.nextval,'psanchez','711045','721026',500,add_months(sysdate,-3), null);
insert into virement values (sequencevir.nextval,'jfontaine','716562','714302',500,add_months(sysdate,-2), null); 
insert into virement values (sequencevir.nextval,'psanchez','717694','728263',4200,add_months(sysdate,-3), null); 
insert into virement values (sequencevir.nextval,'pierre.sanchez','711010','718303',160,add_months(sysdate,-1),'remboursement');
insert into virement values (sequencevir.nextval,'psanchez','711045','721026',3480,add_months(sysdate,-1), null);
insert into virement values (sequencevir.nextval,'rhoareau','718456','717417',500,add_months(sysdate,-3), null);
insert into virement values (sequencevir.nextval,'psanchez','719485','711987',14250,add_months(sysdate,-1), null);

Prompt *************************************************************************************


commit;


Prompt *************************************************************************************
Prompt **********************FIN DE CREATION DE LA BASE PROXIBANQUE*************************                           