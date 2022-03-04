package at.ac.htl.leonding.workloads.Song;

import at.ac.htl.leonding.workloads.Playlist.PlaylistId;

import javax.persistence.*;


@Entity
public class Song {

    private static Song newSong;

    @EmbeddedId
    private PlaylistId id;

    private String url;
    private String name;
    private String artist;

    public PlaylistId getId() {
        return id;
    }

    public void setId(PlaylistId id) {
        this.id = id;
    }

    public static Song getNewSong() {
        return newSong;
    }

    public static void setNewSong(Song newSong) {
        Song.newSong = newSong;
    }


    public static Song create(String name, String artist, String url) {
        var newSong = new Song();
        newSong.setName(name);
        newSong.setArtist(artist);
        newSong.setUrl(url);
        return newSong;
    }


    public String getUrl() {return url;}
    public void setUrl(String url) {this.url = url;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getArtist() {return artist;}
    public void setArtist(String artist) {this.artist = artist;}}