package at.ac.htl.leonding.workloads.playlist;

import at.ac.htl.leonding.workloads.user.User;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Playlist extends PanacheEntity {

    @ManyToOne
    private User user;
    private String name;

    public Playlist(String name) {
        //this.user = user;
        this.name = name;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Playlist() {
    }

    public User getUser() {
        return user;
    }

    public String getName() {
        return name;
    }
}
