package org.example;

import org.example.Student;
import jakarta.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDAO {

    private final static SessionFactory sessionFactory = HibernateSession.getSessionFactory();

    public static void addStudent(String name, String email) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Student student = new Student(name, email);
            session.save(student);
            session.getTransaction().commit();
            System.out.println("Ви успішно додали користувача: " + name + " email: " + email);
        }
    }

    public static void deleteStudentById(Integer id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Student student = session.get(Student.class, id);
            if (student != null) {
                session.remove(student);
            }
            session.getTransaction().commit();
            System.out.println("Ви успішно видалили користувача під номером: " + id);
        }
    }

    public static void updateStudentById(Integer id, String newName, String newEmail) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Student student = session.get(Student.class, id);
            if (student != null) {
                if (!newName.isBlank()) student.setName(newName);
                if (!newEmail.isBlank()) student.setEmail(newEmail);
            }
            session.getTransaction().commit();
            System.out.println("Ви успішно оновили користувача, його id: " + id + ", нове ім'я: "+newName+", новий email: " + newEmail);
        }
    }

    public static List<Student> getAllStudents() {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Query<Student> query = session.createQuery("FROM Student ORDER BY id", Student.class);
            List<Student> list = query.getResultList();
            session.getTransaction().commit();
            System.out.println("Всі студенти: " + list);
            return list;
        }
    }

    public static Student getStudentById(Integer id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Query<Student> query = session.createQuery("FROM Student WHERE id = :id", Student.class);
            query.setParameter("id", id);
            Student student = query.uniqueResult();
            session.getTransaction().commit();
            System.out.println("Студент за номером : " + id);
            return student;
        } catch (NoResultException e) {
            return null;
        }

    }

    public static List<Student> getStudentByName(String name) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Query<Student> query = session.createQuery("FROM Student WHERE name = :name", Student.class);
            query.setParameter("name", name);
            List<Student> list = query.getResultList();
            session.getTransaction().commit();
            System.out.println("Студент за ім'ям : " + name);
            return list;
        }
    }
}

