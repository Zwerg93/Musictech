package at.ac.htl.leonding.workloads.user;


import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;


@ApplicationScoped
public class UserRepo implements PanacheRepository<User> {

    private final EntityManager entityManager;

    public UserRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public String getPassword(String username){

        TypedQuery<String> query = this.entityManager
                .createQuery("select p.password from User p where p.username = :username ",
                        String.class)
                .setParameter("username",username);

        return query.getResultList().stream().findFirst().orElse(null);
    }


    public List<User>
    getAll() {
        TypedQuery<User> query = this.entityManager
                .createQuery("select p from User p",
                        User.class);
        return query.getResultList();
    }


}
