package app.service;

import app.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    List<User> getListUsers();

    User getUserById(int id);

    void updateUser(User user);

    void deleteUser(int id);
}

