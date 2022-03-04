package at.ac.htl.leonding.workloads.Song;



import java.util.List;

public interface SongRepo {
    List<Song> getAll();

    Song getSong(Long id);

    void update(Song song);

    void add(Song u);
}
