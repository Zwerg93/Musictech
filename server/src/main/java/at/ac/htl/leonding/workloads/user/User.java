package at.ac.htl.leonding.workloads.user;

import at.ac.htl.leonding.workloads.playlist.Playlist;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "\"User\"")
public class User extends PanacheEntity {

    public String username, name, lastname, email, password;


    @Transient
    @OneToMany(mappedBy = "user")
    public List<Playlist> playlistList = new ArrayList<>();


    public void addPlaylist( Playlist playlist) {

        playlistList.add(playlist);
        playlist.setUser(this);
        //playlist.setUser(this);
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Playlist> getPlaylistList() {
        return playlistList;
    }

    public void setPlaylistList(List<Playlist> playlistList) {
        this.playlistList = playlistList;
    }
}
