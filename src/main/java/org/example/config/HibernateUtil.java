package org.example.config;

import org.example.model.Car;
import org.example.model.User;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    public static SessionFactory getSession() {
        SessionFactory sessionFactory = null;
        try {
            Configuration configuration = new Configuration()
                    .addAnnotatedClass(User.class)
                    .addAnnotatedClass(Car.class)
                    .configure("hibernate.cfg.xml");
            sessionFactory = configuration.buildSessionFactory();
        } catch (SessionException e) {
            System.out.println(e.getMessage());
        }
        return sessionFactory;
    }

}
