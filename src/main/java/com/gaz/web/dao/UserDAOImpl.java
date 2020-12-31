package com.gaz.web.dao;

import com.gaz.web.entity.User;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        List<User> allUsers = entityManager.createQuery("from User", User.class).getResultList();
        return allUsers;
    }

    @Override
    public void saveUser(User user) {
        Session session = (Session) entityManager.getDelegate();
        session.saveOrUpdate(user);
    }

    @Override
    public User getUser(int id) {
        Session session = (Session) entityManager.getDelegate();
        User user = session.get(User.class, id);
        return user;
    }

    @Override
    public void deleteUser(int id) {
        Session session = (Session) entityManager.getDelegate();
        User user = getUser(id);
        session.delete(user);
    }
}
