package service;

import aspects.LogAspect;
import interfaces.Speakers;
import interfaces.Tyres;
import java.util.logging.Logger;
import model.Song;

public class VehicleService {

	Logger logger = Logger.getLogger(VehicleService.class.getName());

	private final Tyres tyres;
	private final Speakers speakers;

	public VehicleService(Speakers speakers, Tyres tyres) {
		this.speakers = speakers;
		this.tyres = tyres;
	}

	@LogAspect
	public String playMusic(boolean vehicleStarted, Song song) {
		/*Instant start = Instant.now();
		logger.info("method execution start");
*/
		/*String music = "";

		if (vehicleStarted) {
			music = speakers.makeSound(song);
		} else {
			logger.log(Level.SEVERE, "Vehicle not started to perform the operation");
		}*/

		/*Instant finish = Instant.now();
		long timeElapsed = Duration.between(start, finish).toMillis();
		logger.info("Time took to execute the method : " + timeElapsed);
*/
		return speakers.makeSound(song);
	}

	public String moveVehicle(boolean vehicleStarted) {
		/*Instant start = Instant.now();
		logger.info("method execution start");*/
		/*String status = null;

		if (vehicleStarted) {
			status = tyres.rotate();
		} else {
			logger.log(Level.SEVERE, "Vehicle not started to perform the operation");
		}*/
		/*logger.info("method execution end");
		Instant finish = Instant.now();
		long timeElapsed = Duration.between(start, finish).toMillis();
		logger.info("Time took to execute the method : " + timeElapsed);
*/
		return tyres.rotate();
	}

	public String applyBrake(boolean vehicleStarted) {
		/*Instant start = Instant.now();
		logger.info("method execution start");*/
		/*String status = null;

		if (vehicleStarted) {
			status = tyres.stop();
		} else {
			logger.log(Level.SEVERE, "Vehicle not started to perform the" +
					" operation");
		}*/
		/*logger.info("method execution end");
		Instant finish = Instant.now();
		long timeElapsed = Duration.between(start, finish).toMillis();
		logger.info("Time took to execute the method : " + timeElapsed);
*/
		return tyres.stop();
	}
}
