package at.ac.htl.leonding.workloads.playlist;

import at.ac.htl.leonding.workloads.user.User;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.ManyToOne;

public class Playlist  extends PanacheEntity {


    private User user;
    private String name;

    public Playlist(User user, String name) {
        this.user = user;
        this.name = name;
    }

    public Playlist() {
    }
}
