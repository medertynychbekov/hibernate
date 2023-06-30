package org.example.service.impl;

import org.example.config.HibernateUtil;
import org.example.exceptions.ObjectEqual;
import org.example.exceptions.ObjectIsEmpty;
import org.example.exceptions.ObjectNotFoundException;
import org.example.model.Car;
import org.example.service.Service;
import org.hibernate.Session;
import org.hibernate.SessionException;

import java.util.ArrayList;
import java.util.List;

public class CarService implements Service<Car> {

    @Override
    public void save(Car car) {
        try (Session session = HibernateUtil.getSession().openSession()) {
            session.beginTransaction();
            session.persist(car);
            session.getTransaction().commit();
            System.out.println("Object car successfully saved!!!");
        } catch (SessionException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteById(int id) {
        try (Session session = HibernateUtil.getSession().openSession()) {
            session.beginTransaction();

            Car car = session.get(Car.class, id);

            if (car == null) {
                throw new ObjectNotFoundException("Object with id " + id + " not found and I didn't delete it!!!");
            }
            session.remove(car);

            //------------------------------------------------------------

//            session.remove(session.get(Car.class, id));
//
//            // -------------------------------------------------------------
//
//            Query query = session.createQuery("delete from Car where id = :id");
//            query.setParameter("id", id);
//            query.executeUpdate();

            //---------------------------------------------------
            session.getTransaction().commit();
            System.out.println("Car successfully deleted!!!");

        } catch (SessionException | ObjectNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Car update(int id, Car car) {
        Car oldCar = null;
        try (Session session = HibernateUtil.getSession().openSession()) {
            session.beginTransaction();

            oldCar = session.get(Car.class, id);

            if (oldCar == null) {
                throw new ObjectIsEmpty(String.format("Car with id:%d not found!!!", id));
            }

            if (car.equals(oldCar)) {
                throw new ObjectEqual("Old car and new car are equals!!!");
            }

            oldCar.setName(car.getName());
            oldCar.setNumber(car.getNumber());
            oldCar.setModel(car.getModel());
            session.merge(oldCar);
            session.getTransaction().commit();

        } catch (SessionException | ObjectEqual e) {
            System.out.println(e.getMessage());
        }
        return oldCar;
    }

    @Override
    public List<Car> getAll() {
        List<Car> cars = new ArrayList<>();
        try (Session session = HibernateUtil.getSession().openSession()) {

            session.beginTransaction();

            cars = session.createQuery("from Car").list();

            if (cars.isEmpty()) {
                throw new ObjectIsEmpty("Your list are empty");
            }

            session.getTransaction().commit();

        } catch (SessionException | ObjectIsEmpty e) {
            System.out.println(e.getMessage());
        }
        return cars;
    }

    @Override
    public Car findById(int id) {
        Car car = null;
        try (Session session = HibernateUtil.getSession().openSession()) {
            session.beginTransaction();

            car = session.get(Car.class, id);

            if (car == null) {
                throw new ObjectIsEmpty(String.format("Car with id:%d not found!!!", id));
            }

            session.getTransaction().commit();
        } catch (SessionException | ObjectIsEmpty e) {
            System.out.println(e.getMessage());
        }

        return car;
    }
}
