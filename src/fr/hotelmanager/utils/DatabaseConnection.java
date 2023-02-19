package fr.hotelmanager.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection connection;

    private DatabaseConnection() {
        String bdd = "hotel";
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres", "afpa2020");
            System.out.println("connexion etablie a la BDD " + bdd);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static DatabaseConnection getInstance() {
        if(instance == null)
            instance = new DatabaseConnection();
        return instance;
    }

    public Connection getCOnnection() {
        return connection;
    }
}
