package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main
{
    public static void main(String[] args)
    {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "developer", "developer");
             Statement statement = connection.createStatement())
        {
            statement.executeUpdate("ALTER TABLE students ADD country VARCHAR(30);");

            statement.executeUpdate("UPDATE students SET country = 'Italy' WHERE student_id IN (1, 2);");
            statement.executeUpdate("UPDATE students SET country = 'Germany' WHERE student_id IN (3, 4);");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}