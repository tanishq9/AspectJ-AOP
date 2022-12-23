package main;

import implemenation.MichelinTyres;
import implemenation.SonySpeakers;
import interfaces.Speakers;
import interfaces.Tyres;
import model.Song;
import service.VehicleService;

public class Example {
	public static void main(String[] args) {
		Tyres tyres = new MichelinTyres();
		Speakers speakers = new SonySpeakers();

		var vehicleService = new VehicleService(speakers, tyres);
		boolean vehicleStarted = false;

		String playMusicStatus = vehicleService.playMusic(vehicleStarted, new Song("T1", "S1"));
		// String moveVehicleStatus = vehicleService.moveVehicle(vehicleStarted);
		// String applyBrakeStatus = vehicleService.applyBrake(vehicleStarted);

		System.out.println(playMusicStatus);
		// System.out.println(moveVehicleStatus);
		// System.out.println(applyBrakeStatus);
	}
}
