package dao;

import model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    int create(User user);

    default Optional<User> get(int id) {
        return getAll().stream()
                .filter(user -> user.getId() == id)
                .findAny();
    }

    void remove(User user);

    List<User> getAll();

    boolean LoginFree(String nickName);
    boolean isPasswordCorrect();
    void update(User user);
    User searchUser(String name);

}
