package at.ac.htl.leonding.workloads.song;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;

@Entity
public class Song extends PanacheEntity {

    public String name, url;


    public Song(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public Song() {
    }
}
