package at.ac.htl.leonding.workloads.playlist;

import at.ac.htl.leonding.workloads.song.Song;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class PlaylistRepo implements PanacheRepository<Playlist> {

    private final EntityManager entityManager;

    public PlaylistRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Playlist> getAll() {
        TypedQuery<Playlist> query = this.entityManager
                .createQuery("select p from User p",
                        Playlist.class);
        return query.getResultList();
    }

    public void addSong(Song song) {
        this.entityManager.persist(song);
    }
}
