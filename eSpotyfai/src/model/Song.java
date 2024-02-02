package model;

public class Song {

	int song_id;
	String song_name;
	String song_artist;
	String[] song_genres;
	String song_img;
	String song_path;

	public Song(int song_id, String song_name, String song_artist, String[] song_genres, String song_img, String song_path) {

		this.song_id = song_id;
		this.song_name = song_name;
		this.song_artist = song_artist;
		this.song_genres = song_genres;
		this.song_img = song_img;
		this.song_path = song_path;
	}


}
