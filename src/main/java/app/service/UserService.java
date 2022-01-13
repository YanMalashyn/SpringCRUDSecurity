package app.service;

import app.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    User findUserByCar(String model, int series);
}
