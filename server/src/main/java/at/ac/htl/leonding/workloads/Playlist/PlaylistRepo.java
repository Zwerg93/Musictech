package at.ac.htl.leonding.workloads.Playlist;

import java.util.List;

public interface PlaylistRepo {
    void add(Playlist u);
    List<Playlist> getAll();

    Playlist getplaylist(Long id);

    void update(Playlist playlist);
}
