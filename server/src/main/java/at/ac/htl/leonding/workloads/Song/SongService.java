package at.ac.htl.leonding.workloads.Song;

import java.util.List;

public interface SongService {
    Object addSong(String name, String artist, String url);

    Song getSong(Long id);

    List<Song> getAll();


}
