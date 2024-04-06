package org.example.config;

import org.example.model.User;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {

    public static SessionFactory getSession() {
        SessionFactory sessionFactory = null;
        try {
            Configuration configuration = new Configuration()
                    .configure("hibernate.cfg.xml");
            sessionFactory = configuration.buildSessionFactory();
        } catch (SessionException e) {
            System.out.println(e.getMessage());
        }
        return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        SessionFactory sessionFactory = null;
        try {
            Configuration configuration = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(User.class);
            sessionFactory = configuration.buildSessionFactory();
        } catch (SessionException e) {
            System.out.println(e.getMessage());
        }
        return sessionFactory;
    }

    public static SessionFactory get() {
        return new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
    }

}
