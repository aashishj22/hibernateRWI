package org.example;

import org.example.Employee.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        Employee emp = new Employee();
        emp.setName("Aashish");
        emp.setCity("Raipur");

        String imagePath = "E:\\xyz\\myData\\src\\main\\resources\\image1.jpeg";

        try (FileInputStream is = new FileInputStream(imagePath)) {
            byte[] img = is.readAllBytes();
            System.out.println("Image size read from file: " + img.length + " bytes");
            emp.setImage(img);

            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            session.save(emp);
            tx.commit();
            session.close();

            System.out.println("Image uploaded successfully");
        } catch (IOException e) {
            System.err.println("Error reading image file: " + e.getMessage());
        } finally {
            factory.close(); // Close session factory
        }
    }
}
