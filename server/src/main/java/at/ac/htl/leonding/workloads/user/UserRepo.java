package at.ac.htl.leonding.workloads.user;

import java.util.List;

public interface UserRepo {
    List<User> getAll();

    User getUser(Long id);

    void update(User user);

    void add(User p);
}
