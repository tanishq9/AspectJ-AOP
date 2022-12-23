package implemenation;

import interfaces.Speakers;
import model.Song;

public class BoseSpeakers implements Speakers {

	public String makeSound(Song song){
		return "Playing the song "+ song.getTitle()+ " by "
				+ song.getSingerName()+
				" with Bose speakers";
	}
}
