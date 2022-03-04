package at.ac.htl.leonding.workloads.Song;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class SongRepoImpl  implements SongRepo {
    private final EntityManager entityManager;

    public SongRepoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Song> getAll() {
        TypedQuery<Song> query = this.entityManager
                .createQuery("select p from Song p",
                        Song.class);
        return query.getResultList();
    }

    @Override
    public Song getSong(Long id) {
        TypedQuery<Song> query = this.entityManager
                .createQuery("select p from Song p where p.id = :id",
                        Song.class);
        query.setParameter("id", id);
        return query.getResultList().stream().findFirst().orElse(null);
    }

    @Override
    public void update(Song song) {
        this.entityManager.merge(song);
    }

    @Override
    public void add(Song u) {
        this.entityManager.persist(u);
    }
}
