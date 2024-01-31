package model;

import java.util.List;

public class Playlists {
	
	
	// "/view/songImages/1.png", "Ave Maria", "David Bisbal"
	
	int pl_id;
	String pl_name;
	String pl_image;
	String[] pl_artists;
	String[] pl_songs;
	
	public Playlists(int pl_id,String pl_name, String[] pl_artists, String pl_image, String[] pl_songs) {
		this.pl_id = pl_id;
		this.pl_name = pl_name;
		this.pl_image = pl_image;
		this.pl_artists = pl_artists;
		this.pl_songs = pl_songs;
	}
}
