package app.service;

import app.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user, Long id);

    List<User> getListUsers();

    User getUserById(Long id);

    void updateUser(Long id, User user, Long idRole);

    void deleteUser(Long id);

    User getUserByName(String name);
}

