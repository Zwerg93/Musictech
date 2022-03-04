package at.ac.htl.leonding.workloads.Playlist;


import at.ac.htl.leonding.workloads.Song.Song;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Playlist {

    //private static Playlist newSong;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "playlist", cascade = CascadeType.ALL)
    private List<Song> songList = new ArrayList<>();

    public void addSong(Song song) {
        var id = new PlaylistId();

        id.setPlaylist(this);
        id.setSong(song);


    }

    public static Playlist create(String name, List<Song> songlist) {
        var newPlaylist = new Playlist();
        newPlaylist.setName(name);
        newPlaylist.setSongList(songlist);
        return newPlaylist;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }


    //private String songname;
    //private Timestamp timestamp;
    //private String username;

    //@ManyToOne
    // Users users;


    //public void setUsers(Users users) {
    //   this.users = users;
    //}

}
