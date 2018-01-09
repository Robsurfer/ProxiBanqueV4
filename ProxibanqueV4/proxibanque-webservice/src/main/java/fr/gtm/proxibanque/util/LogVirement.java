package fr.gtm.proxibanque.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogVirement {

	Logger logger = LogManager.getLogger(LogVirement.class);

	@Pointcut("execution(* *.virement(..))")
	public void loggingVirement() {
	}

	@Before(value = "loggingVirement()")
	public void enteteLog() {
		logger.info("Tentative de transaction");
	}

	@AfterReturning(pointcut = "loggingVirement()", returning = "result")
	public void virementOk(Object result) {
		logger.info(result.toString());
	}

	@AfterThrowing(pointcut = "loggingVirement()")
	public void virementErreur() {
		logger.info("Erreur lors de la transaction, le virement n'a pas été réalisé");
	}
}
