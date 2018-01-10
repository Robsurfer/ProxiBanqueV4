# ProxiBanqueSI V4 
								   
Readme du projet ProxiBanqueV4 (Hattmann, Lise, Loriane, Robinson, Solène)

------------------------------------------------------------------------------------------------------------------------------------
## Description de l'application ProxibanqueSI
------------------------------------------------------------------------------------------------------------------------------------
#### A. ProxiBanqueSI est une application visant à exécuter des services bancaires pour les conseillers et les gerants des 
agences de la banque Proxibanque à travers une interface web.
Elle permet une gestion clientèle simplifiée, ergonomique et numérique.

#### B. Les fonctionnalités de l'application sont :

	1. Pour chaque conseiller de l'agence:
* gérer l'authentification des conseillers grâce à des identifiants et des mots de passe associés
* visualiser la liste des clients de chaque conseiller
* visualiser les informations d'un client
* visualiser la liste des comptes associés à chaque client
* éditer les informations d'un client
* effectuer des virements pour les clients
* garder une trace de chacun des virements effectués par un conseiller
* visualiser l'ensemble de virements effectués par un conseiller

	2. Pour les gérants des agences
* gérer l'authentification des gerants des agences grâce à des identifiants et des mots de passe associés
* observer graphiquement les performances de son agence et de ses conseillers
* visualiser la liste des conseillers de l'agence

/!\ Ces fonctionnalités ne sont pas disponibles dans cette version
* créer un nouveau compte à un client dejà existant
* créer un nouveau client avec une attribution de compte automatique (un nouveau client est forcement associé à nouveau compte)
* prendre la place d'un conseiller

#### C. L'application prend en compte un systeme de gestion des erreurs afin d'indiquer aux utilisateurs
les dysfonctionnements.

#### D. L'application utilise également uniquement des webservices permettant une interopérabilté des fonctions proposés par le serveur.

------------------------------------------------------------------------------------------------------------------------------------
## Prérequis pour l'utilisation
------------------------------------------------------------------------------------------------------------------------------------
* Installation Apache Tomcat v8.5
* Installation OracleXE

------------------------------------------------------------------------------------------------------------------------------------
## Documentation 
------------------------------------------------------------------------------------------------------------------------------------
La documentation est disponible dans le dossier du projet

	1. Veuillez accéder au dossier 'javadoc/'
	2. Double cliquez sur 'index.html'.

------------------------------------------------------------------------------------------------------------------------------------
## Execution de l'application 
------------------------------------------------------------------------------------------------------------------------------------
Avant de commencer, veuillez vous assurer de remplir les préquis d'utilisation listés ci-dessus.

Pour lancer l'application, veuillez suivre indications suivantes :
#### A. Lancer la base de données
	1. Lancez le programme Run SQL command line (nécessite l'installation d'OracleXE)
	
	2. Connectez vous au system en saisissant la commande suivante : 'connect system/motdepasse' en remplacant le 
	champ "motdepasse" par celui que vous avez configuré lors de l'installation d'OracleXE.
	
	3. Creez un nouvel utilisateur en tapant les commandes suivantes
		 create user proxibanque identified by proxibanque;
		 grant connect, resource to proxibanque;	 

#### B. Lancer l'application
	
	1. Telecharger le fichier excécutable Proxibanque-webservice.jar du github https://github.com/Robsurfer/ProxiBanqueV4/tree/master/ProxibanqueV4
	
		i. Copier le fichier contenant les webservices nommé Proxibanque-webservice.jar dans le dossier de votre choix
		ii. Pour le lancer, ouvrez l'invité de commande et changez le repertoire avec le chemin du dossier contenant le fichier .jar precedemment telechargé.
		iii. suite au changement de répertoire, tapez la commande:
		java -jar Proxibanque-webservice.jar
		
		--> votre jar est déployé
			
	2. Pour copier-coller dans le dossier /webapps de Tomcat la partie présentation de l'application (dossier ProxibanqueV4) :
		i. Dans le dossier d'intallation du programme Apache Tomcat 8.5.23,
		   -> accédez au dossier \conf
		ii. Ouvrez le fichier 'server.xml' avec un éditeur de texte 
		    (type bloc-note sous Windows, text-edit sous OS X)
		iii. Changez le port par défaut par le port 8081 (OBLIGATOIRE)
		iv. Sauvegardez et quittez
		v. Dans le dossier d'intallation du programme Apache Tomcat 8.5.23,
		   -> accédez au dossier \webapps
		vi. Copiez-collez dans le dossier \webapps le dossier 'ProxibanqueV4'
	
	3. Lancez le serveur :
		i. Dans le dossier d'intallation du programme Apache Tomcat 8.5.23,
		   -> accédez au dossier \bin
		ii. Double-cliquez sur le fichier 'startup.bat' -> le serveur et lancez	 

#### C. Accéder à la page d'accueil de l'application ProxibanqueSI
	1. Lancez votre navigateur et accédez à l'url : http://localhost:8081/ProxibanqueV4/
	   
	2. Pour vous identifier saisissez un login/mot de passe valides pour un conseiller ou un gerant dont la liste est la suivante 
	   (attention le login est sensible à la casse)
	   Conseillers:
	   1) psanchez / tata ==> compte conseiller à privilégier pour le test de l'application car le plus fourni en clients
	   2) pdupond / toto
	   3) jfontaine / tutu
	   4) pierre.sanchez / tyty
	   
	   Gerant:
	   1) gclaude / chef
		

	L'ensemble des données de connexion se trouve dans la table 'Conseiller' de la base de données créée à l'étape A)

#### D. Importer le projet Maven
	1. Rendez vous sur le repository Github à l'adresse suivante : https://github.com/Robsurfer/ProxiBanqueV4
	2. Choisissez "Clone or Download" et téléchargez l'archive zip nommée ProxibanqueV4
	3. Décompressez l'archive et importez le projet via votre IDE habituel 
	   (import -> existing Maven project dans la plupart)
	4. Lancez un invite de commande et faites un 'mvn install clean package'

Pour obtenir de l'aide, nous vous invitons à contacter notre support technique : google.com ;)

