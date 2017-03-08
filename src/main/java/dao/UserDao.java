package dao;

import model.User;

import java.util.List;
import java.util.Optional;

/**
 * Created by User on 08.03.2017.
 */
public interface UserDao {
    int create(User user);

    default Optional<User> get(int id) {
        return getAll().stream()
                .filter(user -> user.getId() == id)
                .findAny();
    }

    void remove(User user);

    List<User> getAll();
}
