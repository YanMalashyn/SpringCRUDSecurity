package app.dao;

import app.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getListUsers() {
        return sessionFactory.getCurrentSession().createQuery("from User").getResultList();
    }

    @Override
    public User getUserById(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from User u where u.id =: id");
        query.setParameter("id", id);
        return (User) query.getSingleResult();
    }

    @Override
    public void updateUser(User user) {
        //!!!!!!!!!!!!!!
    }

    @Override
    public void deleteUser(int id) {
        //!!!!!!!!!!!!!!
    }
}
