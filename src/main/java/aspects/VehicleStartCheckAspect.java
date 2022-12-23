package aspects;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class VehicleStartCheckAspect {

	private final Logger logger = Logger.getLogger(LoggerAspect.class.getName());

	@Before("execution(* service.*.*(..)) && args(vehicleStarted,..)")
	public void checkVehicleStarted(JoinPoint joinPoint, boolean vehicleStarted) {
		if (!vehicleStarted) {
			logger.log(Level.SEVERE, "Vehicle not started");
		}
	}
}
