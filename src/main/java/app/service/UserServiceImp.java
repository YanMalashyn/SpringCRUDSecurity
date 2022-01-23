package app.service;

import app.dao.UserDao;
import app.model.Role;
import app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImp implements UserService {


    private final UserDao userDao;
    private final RoleService roleService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImp(UserDao userDao, RoleService roleService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDao = userDao;
        this.roleService = roleService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Transactional
    @Override
    public void saveUser(User user, Long id) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(roleService.getRoleById(id));
        user.setRoles(roleSet);
        userDao.saveUser(user);

    }

    @Transactional
    @Override
    public List<User> getListUsers() {
        return userDao.getListUsers();
    }

    @Transactional
    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Transactional
    @Override
    public void updateUser(Long id, User user) {
        userDao.updateUser(id, user);
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    @Override
    public User getUserByName(String name){
       return userDao.getUserByName(name);
    }
}
