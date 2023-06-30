package org.example.service.impl;

import jakarta.persistence.Query;
import org.example.config.HibernateUtil;
import org.example.model.User;
import org.example.service.Service;
import org.hibernate.Session;
import org.hibernate.SessionException;

import java.util.ArrayList;
import java.util.List;

public class UserService implements Service<User> {

    public void save(User user) {
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();

        session.persist(user);
        session.getTransaction().commit();
        session.close();
        System.out.println(user + " successfully saved!!!");
    }

    public void deleteById(int id) {
        try (Session session = HibernateUtil.getSession().openSession()) {
            session.beginTransaction();
            session.getTransaction().commit();
            Query query = session.createQuery("delete from User where id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            System.out.println("successfully deleted");
        } catch (SessionException e) {
            System.out.println(e.getMessage());
        }
        return "user successfully deleted!!!";
    }

    public User update(int id, User user) {
        User oldUSer = null;
        try (Session session = HibernateUtil.getSession().openSession()) {
            session.beginTransaction();
            oldUSer = session.get(User.class, id);
            oldUSer.setName(user.getName());
            oldUSer.setAge(user.getAge());
            session.persist(oldUSer);
            session.getTransaction().commit();
            System.out.println("user successfully updated");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return oldUSer;
    }

    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try (Session session = HibernateUtil.getSession().openSession()) {
            session.beginTransaction();
            users = session.createQuery("from User").getResultList();
            session.getTransaction().commit();
        } catch (SessionException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    public User findById(int id) {
        User user = null;
        try (Session session = HibernateUtil.getSession().openSession()) {
            session.beginTransaction();
            user = session.get(User.class, id);
            session.getTransaction().commit();
        } catch (SessionException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }
}
