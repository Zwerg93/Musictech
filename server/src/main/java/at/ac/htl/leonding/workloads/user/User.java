package at.ac.htl.leonding.workloads.user;

import at.ac.htl.leonding.workloads.playlist.Playlist;

import at.ac.htl.leonding.workloads.song.Song;
import io.quarkus.hibernate.orm.panache.PanacheEntity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "\"User\"")
public class User extends PanacheEntity {

    public String username, name, lastname, email, password;
    @Transient
    public List<Playlist> playlistList = new ArrayList<>();

    public void addPlaylist(Playlist playlist) {
        this.playlistList.add(playlist);
    }


    public User(String username, String name, String lastname, String email, String password) {
        this.username = username;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;

    }

    public User() {
    }
}
