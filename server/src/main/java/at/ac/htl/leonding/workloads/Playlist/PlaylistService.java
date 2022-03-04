package at.ac.htl.leonding.workloads.Playlist;

import at.ac.htl.leonding.workloads.Song.Song;


import java.util.List;

public interface PlaylistService {
    List<Playlist> getAll();

    Object addPlaylist(String name, List<Song>  songList);


}
