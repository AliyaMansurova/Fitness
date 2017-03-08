package dao.H2;

import dao.UserDao;
import model.User;

import java.util.List;

public class H2UserDao implements UserDao {

    @Override
    public int create(User user) {
        return 0;
    }

    @Override
    public void remove(User user) {

    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
