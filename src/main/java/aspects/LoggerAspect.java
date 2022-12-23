package aspects;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclarePrecedence;

@Aspect
@DeclarePrecedence("LoggerAspect, VehicleStartCheckAspect")
public class LoggerAspect {

	private final Logger logger = Logger.getLogger(LoggerAspect.class.getName());

	// Advice(Pointcut expression) or Advice(Annotation configuration)
	@Around("execution(* service.*.*(..))")
	// @Around("@annotation(aspects.LogAspect) && execution(* *(..))")
	public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println(proceedingJoinPoint);
		// call(String service.VehicleService.playMusic(boolean, Song))
		// execution(String service.VehicleService.playMusic(boolean, Song))
		// https://stackoverflow.com/questions/64969593/why-does-aspectj-around-advice-execute-twice

		// Before requirements
		logger.info(proceedingJoinPoint.getSignature().toString() + " method execution starts.");
		Instant start = Instant.now();
		// Invoking actual method below
		Object proceed;
		proceed = proceedingJoinPoint.proceed();
		// After requirements
		Instant finish = Instant.now();
		long timeElapsed = Duration.between(start, finish).toMillis();
		logger.info("Time took to execute the method: " + timeElapsed);
		logger.info(proceedingJoinPoint.getSignature().toString() + " method execution end.");
		return proceed;
	}

	@AfterReturning(value = "execution(public * service.*.*(..))", returning = "retVal")
	public void logReturnedValue(JoinPoint joinPoint, Object retVal) throws Throwable {
		logger.info("Return Value: " + retVal);
	}

	@AfterThrowing(value = "execution(public * service.*.*(..))", throwing = "ex")
	public void logException(JoinPoint joinPoint, Exception ex) throws Throwable {
		logger.severe("Exception Message: " + ex.getMessage());
	}
}
