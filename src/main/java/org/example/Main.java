package org.example;

import org.example.StudentDAO;

public class Main {
    public static void main(String[] args) {

        // Додавання записів
        StudentDAO.addStudent("Maria", "Maria475@gmail.com");
        StudentDAO.addStudent("Mike", "Mike562@gmail.com");
        StudentDAO.addStudent("Oleg", "Oleg4614f7@gmail.com");
        StudentDAO.addStudent("Anna", "Anna457q@gmail.com");

        // Отримання всіх записів
        StudentDAO.getAllStudents();

        // Отримання записів за іменем
        StudentDAO.getStudentByName("Maria");

        StudentDAO.getStudentByName("Anna");

        // Отримання записів за id
        StudentDAO.getStudentById(2);

        StudentDAO.getStudentById(134);

        // Оновлення запису за id (ім'я та email)
        StudentDAO.updateStudentById(2, "Tom", "tom153@gmail.com");

        StudentDAO.getAllStudents();

        // Видалення запису за id
        StudentDAO.deleteStudentById(1);
        StudentDAO.getAllStudents();
    }
}
