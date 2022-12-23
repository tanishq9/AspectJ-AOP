package model;

public class Song {

	private String title;
	private String singerName;

	public Song(String title, String singerName) {
		this.title = title;
		this.singerName = singerName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSingerName() {
		return singerName;
	}

	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}
}