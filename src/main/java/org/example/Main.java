package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {
        try (Connection conn = ConnectionManager.getConnection()) {
            System.out.println("Konekcija uspešna!");
        } catch (Exception e) {
            e.printStackTrace();
        }


        UserDao userDao = new UserDaoImpl();

        // Dodavanje novog usera
        User newUser = new User(0, "pera", "sifra123", "pera@example.com", "CUSTOMER");
        userDao.save(newUser);

        // Prikaz svih usera
        List<User> users = userDao.findAll();
        users.forEach(System.out::println);

        // Traženje usera po ID
        User found = userDao.findById(1);
        System.out.println("Pronađen: " + found);


    }
}