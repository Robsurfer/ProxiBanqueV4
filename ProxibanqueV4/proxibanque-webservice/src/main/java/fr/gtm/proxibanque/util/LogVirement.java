package fr.gtm.proxibanque.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Classe utilisation la Programmation Orienté Aspect avec Spring AOP. Les
 * méthodes de cette classe vont permettre de créer un fichier de log
 * (utilisation de log4j2) permettant de tracer chaque virement réalisé.
 * 
 * @author HLLRS
 *
 */
@Aspect
@Component
public class LogVirement {

	Logger logger = LogManager.getLogger(LogVirement.class);

	/**
	 * Création d'une coupe. La méthode va écouter les appels sur toutes les classes
	 * de tous les packages pour intercepter une méthode nommée "virement" (et ce
	 * peut importe ses paramètres).
	 */
	@Pointcut("execution(* *.virement(..))")
	public void loggingVirement() {
	}

	/**
	 * Mise en oeuvre d'un greffon s'exécutant avant l'appel de la méthode définie
	 * par @Pointcut.
	 * 
	 * Cette méthode va insérer dans le fichier log un entête
	 */
	@Before(value = "loggingVirement()")
	public void enteteLog(JoinPoint joinPoint) {
		logger.info("** Début de la transaction bancaire **");
		Object[] arguments = joinPoint.getArgs();

		logger.info("\tLe conseiller dont le login est " + arguments[0].toString()
				+ " souhaite effectuer le virement suivant :");
		logger.info("\t\t" + arguments[1].toString());
	}

	/**
	 * Mise en oeuvre d'un greffon s'exécutant après l'appel de la méthode définie
	 * par @Pointcut si celle-ci s'est déroulée sans erreur (a retourné quelque
	 * chose).
	 * 
	 * Cette méthode va insérer dans le fichier log les informations retournées par
	 * la méthode interceptée
	 * 
	 * @param Object
	 *            result : le résultat renvoyé par la méthode interceptée
	 */
	@AfterReturning(pointcut = "loggingVirement()", returning = "result")
	public void virementOk(Object result) {
		logger.info("\t" + result.toString());
		if (result.toString().contains("succès")) {
			logger.info("** Transaction bancaire effectuée **");
		} else {
			logger.info("** Transaction bancaire annulée **");
		}
	}

	/**
	 * Mise en oeuvre d'un greffon s'exécutant après l'appel de la méthode définie
	 * par @Pointcut si celle-ci s'est déroulée sans succès.
	 * 
	 * Cette méthode va insérer dans le fichier log un message d'erreur
	 */
	@AfterThrowing(pointcut = "loggingVirement()")
	public void virementErreur() {
		logger.info("** Erreur lors de la transaction **");
	}
}
