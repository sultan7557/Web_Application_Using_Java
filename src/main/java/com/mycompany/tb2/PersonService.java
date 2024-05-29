package com.mycompany.tb2;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class PersonService {
    public void savePerson(Person person) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(person);
            session.getTransaction().commit();
        }
    }

    public void updatePerson(Person person) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.merge(person);
            session.getTransaction().commit();
        }
    }

    public void deletePerson(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Person person = session.get(Person.class, id);
            if (person != null) {
                session.delete(person);
            }
            session.getTransaction().commit();
        }
    }

    public boolean validate(String email, String password) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM Person WHERE email = :email");
            query.setParameter("email", email);
            Person person = (Person) query.uniqueResult();

            if (person != null && person.getPassword().equals(password)) { // Make sure to hash the password before comparing
                return true;
            }
        }

        return false;
    }

    public Person getPerson(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Person person = session.get(Person.class, id);
            session.getTransaction().commit();

            return person;
        }
    }

    public List<Person> getAllPerson() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            List<Person> listofPerson = session.createQuery("from Person").getResultList();
            session.getTransaction().commit();

            return listofPerson;
        }
    }
}