package at.ac.htl.leonding.workloads.Playlist;

import at.ac.htl.leonding.workloads.Song.Song;


import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class PlaylistServiceImpl implements PlaylistService {

    private final PlaylistRepo playlistRepo;


    public PlaylistServiceImpl(PlaylistRepo playlistRepo) {
        this.playlistRepo = playlistRepo;
    }


    @Override
    public List<Playlist> getAll() {
        return this.playlistRepo.getAll();
    }

    @Override
    public Object addPlaylist(String name, List<Song>  songList) {
        //var u =
        var u = Playlist.create(name, songList);
        this.playlistRepo.add(u);
        return u;
    }
}
