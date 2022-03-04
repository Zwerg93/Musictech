package at.ac.htl.leonding.workloads.Song;


import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class SongServiceImpl implements SongService {

    private final SongRepo songRepo;

    public SongServiceImpl(SongRepo songRepo) {
        this.songRepo = songRepo;
    }


    @Override
    public Object addSong(String name, String artist, String url) {
        var u = Song.create(name, artist, url);
        this.songRepo.add(u);
        return u;
    }

    @Override
    public Song getSong(Long id) {
        return this.songRepo.getSong(id);
    }

    @Override
    public List<Song> getAll() {
        return this.songRepo.getAll();
    }


}
