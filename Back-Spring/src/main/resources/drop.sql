drop sequence seq_client;
drop sequence seq_compte;
drop sequence seq_virement;

drop table Conseiller cascade constraints purge;
drop table Client cascade constraints purge;
drop table Compte cascade constraints purge;
drop table Virement cascade constraints purge;
