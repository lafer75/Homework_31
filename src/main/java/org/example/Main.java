package org.example;

import org.example.StudentDAO;

public class Main {
    public static void main(String[] args) {

        // Додавання записів
        StudentDAO.addStudent("Tom", "tom@gmail.com");
        StudentDAO.addStudent("Bob", "bob@gmail.com");
        StudentDAO.addStudent("Jack", "jack@gmail.com");
        StudentDAO.addStudent("Bill", "bill@gmail.com");

        // Отримання всіх записів
        StudentDAO.getAllStudents();

        // Отримання записів за іменем
        StudentDAO.getStudentByName("Bob");

        StudentDAO.getStudentByName("John");

        // Отримання записів за id
        StudentDAO.getStudentById(2);

        StudentDAO.getStudentById(134);

        // Оновлення запису за id (ім'я та email)
        StudentDAO.updateStudentById(2, "Phil", "phil@gmail.com");

        StudentDAO.getAllStudents();

        // Видалення запису за id
        StudentDAO.deleteStudentById(1);
        StudentDAO.getAllStudents();
    }
}
