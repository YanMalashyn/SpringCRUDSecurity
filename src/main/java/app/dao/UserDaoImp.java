package app.dao;

import app.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> getListUsers() {
        return entityManager.createQuery("select r from User r", User.class).getResultList();
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(Long id, User user) {
        TypedQuery<User> userShowQuery = entityManager.createQuery(
                "select u from User u where u.id = :id", User.class);
        userShowQuery.setParameter("id", id).getSingleResult();

        User userToBeUpdated = userShowQuery.getSingleResult();
        userToBeUpdated.setFirstName(user.getFirstName());
        userToBeUpdated.setLastName(user.getLastName());
        userToBeUpdated.setAge(user.getAge());
        userToBeUpdated.setUsername(user.getUsername());
        userToBeUpdated.setPassword(user.getPassword());
    }

    @Override
    public void deleteUser(Long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public User getUserByName(String username) {

        TypedQuery<User> typedQuery = entityManager.createQuery(
                "select u from User u where u.username = :username", User.class);

        typedQuery.setParameter("username", username);
        return typedQuery.getResultList().stream().findFirst().orElse(null);

    }
}
