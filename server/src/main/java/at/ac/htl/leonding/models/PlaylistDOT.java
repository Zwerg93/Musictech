package at.ac.htl.leonding.models;

import at.ac.htl.leonding.workloads.Song.Song;


import java.util.ArrayList;
import java.util.List;

public class PlaylistDOT {
    String name;
    String songname;
    List<Song> songList = new ArrayList<>();

    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }

    //Users user;
/*
    public Users getUser() {
        return user;
    }

    public void setUser(Users users) {
        this.user = users;
    }
*/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSongname() {
        return songname;
    }

    public void setSongname(String songname) {
        this.songname = songname;
    }




}
