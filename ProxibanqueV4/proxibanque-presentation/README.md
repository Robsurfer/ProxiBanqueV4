# Pour le déploiement sur tomcat
Taper 'ng build --env=prod -bh /ProxibanqueV4/ -d /ProxibanqueV4/'
	- ProxibanqueV4 étant le dossier généré par le build (cf angular-cli.json outDir)
	- Cela va mettre le base-href à '/ProxibanqueV4' pour Tomcat (attention à n'avoir que des routerLink et pas de href du coup)
	- -d /ProxibanqueV4/ va mettre dans le nom du dossier dans le lien src = "nomduscript" 


	

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 1.6.3.

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `-prod` flag for a production build.
Pour le déploiement sur tomcat

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via [Protractor](http://www.protractortest.org/).

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI README](https://github.com/angular/angular-cli/blob/master/README.md).
