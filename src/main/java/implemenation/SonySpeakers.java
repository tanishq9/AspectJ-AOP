package implemenation;

import interfaces.Speakers;
import model.Song;

public class SonySpeakers implements Speakers {

	public String makeSound(Song song){
		return "Playing the song "+ song.getTitle()+ " by "
				+ song.getSingerName()+
				" with Sony speakers";
	}
}
