package com.gaz.web.dao;

import com.gaz.web.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

//    @Autowired
//    private SessionFactory sessionFactory;


    @Override
    public List<User> getAllUsers() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<User> allUsers = entityManager.createQuery("from User", User.class).getResultList();
//        Session session = sessionFactory.getCurrentSession();
//        List<User> allUsers = session.createQuery("from User", User.class).getResultList();
        return allUsers;
    }

    @Override
    public void saveUser(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Session session = (Session) entityManager.getDelegate();
//        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
    }

    @Override
    public User getUser(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Session session = (Session) entityManager.getDelegate();
//        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, id);
        return user;
    }

    @Override
    public void deleteUser(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Session session = (Session) entityManager.getDelegate();
//        Session session = entityManager.unwrap(Session.class);
//        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("delete from User where id =:userId");
        query.setParameter("userId", id);
//        User user = session.get(User.class,  id);
//        session.delete(user);
    }
}
