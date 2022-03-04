package at.ac.htl.leonding.workloads.song;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class SongRepo implements PanacheRepository<Song> {

    EntityManager entityManager;

    public List<Song> getAll() {
        TypedQuery<Song> query = this.entityManager
                .createQuery("select p from Song p",
                        Song.class);
        return query.getResultList();
    }

}

