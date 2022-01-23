package app.dao;

import app.model.User;

import java.util.List;

public interface UserDao {
    void saveUser(User user);

    List<User> getListUsers();

    User getUserById(Long id);

    void updateUser(Long id, User user);

    void deleteUser(Long id);

    User getUserByName(String name);
}
