# ProxiBanqueV4
GitHub du projet ProxiBanqueV4 (Hattmann, Lise, Loriane, Robinson, Solène)

# Description de l'application ProxibanqueSI
1) ProxiBanqueSI est une application visant à exécuter des services bancaires pour les conseillers et les gerants des agences de la banque Proxibanque à travers une interface web.
Elle permet une gestion clientèle simplifiée, ergonomique et numérique.

2) Les fonctionnalités de l'application sont :

a) Pour chaque conseiller de l'agence:
* gérer l'authentification des conseillers grâce à des identifiants et des mots de passe associés
* visualiser la liste des clients de chaque conseiller
* visualiser les informations d'un client
* visualiser la liste des comptes associés à chaque client
* éditer les informations d'un client
* effectuer des virements pour les clients
* garder une trace de chacun des virements effectués par un conseiller
* visualiser l'ensemble de virements effectués par un conseiller

/!\ Dans une future version
* créer un nouveau compte à un client dejà existant
* créer un nouveau client avec une attribution de compte automatique (un nouveau client est forcement associé à nouveau compte)

b) Pour les gérants des agences
* gérer l'authentification des gerants des agences grâce à des identifiants et des mots de passe associés
* observer graphiquement les performances de son agence et de ses conseillers
* visualiser la liste des conseillers de l'agence

/!\ Dans une future version
* prendre la place d'un conseiller

3) L'application prend en compte un systeme de gestion des erreurs afin d'indiquer aux utilisateurs
les dysfonctionnements.

4) L'application utilise également uniquement des webservices permettant une interopérabilté des fonctions proposés par le serveur.

## Prérequis pour l'utilisation
* Installation Apache Tomcat v8.5
* Installation OracleXE

## Documentation :
La documentation est disponnible dans le dossier du projet

	1. Veuillez accéder au dossier 'javadoc/'
	2. Double cliquez sur 'index.html'.

## Execution de l'application :
Avant de commencer, veuillez vous assurer de remplir les préquis d'utilisation listés ci-dessus.

Pour lancer l'application, veuillez suivre indications suivantes :
#### A. Lancer la base de données
	1. Lancez le programme Run SQL command line (nécessite l'installation d'OracleXE)
	2. Connectez vous au system en saisissant la commande suivante : 'connect identifiant/motdepasse' en remplacant les 
	champs "identifiant" et "motdepasse" par ceux que vous avez configuré lors de l'installation d'OracleXE.
	3. Creez un nouvel utilisateur en tapant les commandes suivantes
		 create user proxibanque identified by proxibanque;
		 grant connect, resource to proxibanque;	 

#### B. Lancer le serveur Apache Tomcat
	1. Vérifiez que le programme n'utilise pas le port 8080 (utilisé par défaut par Oracle et Tomcat)
		i. Dans le dossier d'intallation du programme Apache Tomcat 8.5.23,
		   -> accédez au dossier \conf
		ii. Ouvrez le fichier 'server.xml' avec un éditeur de texte 
		    (type bloc-note sous Windows, text-edit sous OS X)
		iii. Vérifiez que le port 8080 n'apparait pas.
		     S'il apparait remplacez toutes les occurences par un autre port
		     (nous recommandons le port 8081)
		iv. Sauvegardez et quittez
	2. Charger l'application dans le serveur Apache Tomcat
		i. Dans le dossier d'intallation du programme Apache Tomcat 8.5.23,
		   -> accédez au dossier \webapps
		ii. Copiez-collez dans le dossier \webapps le fichier 'ProxibanqueV3.war'
	   	    (le fichier 'ProxibanqueV3.war' se trouve à la racine du dossier du projet)
	3. Lancez le serveur
		i. Dans le dossier d'intallation du programme Apache Tomcat 8.5.23,
		   -> accédez au dossier \bin
		ii. Double-cliquez sur le fichier 'startup.bat' -> le serveur et lancez	 

#### C. Accéder à la page d'acceuil de l'application ProxibanqueV3
	1. Lancez votre navigateur et accédez à l'url : http://localhost:8081/ProxibanqueV3/
	   Veillez à remplacer 8081 par le port indiqué à l'étape B.1.iii précédente
	2. Pour vous identifier saisissez un login/mot de passe valides pour un conseiller dont la liste est la suivante 
	   (attention le login est sensible à la casse)
	   	i. Conseiller1 / password1
		ii. Conseiller2 / password2
		iii. Conseiller3 / password3

	L'ensemble des données de connexion se trouve dans la table 'Conseiller' de la base de données créée à l'étape A)

#### D. Importer le projet Maven
	1. Rendez vous sur le repository Github à l'adresse suivante : https://github.com/Liyukimi/ProxibanqueV3
	2. Choisissez "Clone or Download" et téléchargez l'archive zip
	3. Décompressez l'archive et importez le projet via votre IDE habituel 
	   (import -> existing Maven project dans la plupart)
	4. Lancez un invite de commande et faites un 'mvn install clean package'

Pour obtenir de l'aide, nous vous invitons à contacter notre support technique : google.com ;)

