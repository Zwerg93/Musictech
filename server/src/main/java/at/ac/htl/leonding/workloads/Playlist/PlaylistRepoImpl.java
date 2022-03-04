package at.ac.htl.leonding.workloads.Playlist;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class PlaylistRepoImpl implements PlaylistRepo {
    private final EntityManager entityManager;

    public PlaylistRepoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void add(Playlist u) {
        this.entityManager.persist(u);

    }

    @Override
    public List<Playlist> getAll() {
        TypedQuery<Playlist> query = this.entityManager
                .createQuery("select p from Playlist p",
                        Playlist.class);
        return query.getResultList();
    }

    @Override
    public Playlist getplaylist(Long id) {
        TypedQuery<Playlist> query = this.entityManager
                .createQuery("select p from Playlist p where p.id = :id",
                        Playlist.class);
        query.setParameter("id", id);
        return query.getResultList().stream().findFirst().orElse(null);
    }

    @Override
    public void update(Playlist playlist) {
        this.entityManager.merge(playlist);
    }


}
