package com.jdbs;


import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class main {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "12TomatO_=";
    private static final String URL1 = "jdbc:mysql://localhost:3306/onfreetube?useSSL=false";

    public static void main(String[] args) throws SQLException {


        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException ex) {
            System.out.println("Ошибка регистрации драйвкра");
            return;
        }
        try (Connection connection = DriverManager.getConnection(URL1, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {

         //   statement.execute("INSERT INTO onfreetube.products (product_name, price, shop_id) VALUE(\"apple\", 16, 3)");

          //  int t = statement.executeUpdate("UPDATE onfreetube.products SET product_name=\"Snikers\" where product_id=7");
           // System.out.println(t);
//            statement.addBatch("INSERT INTO onfreetube.products (product_name, price, shop_id) VALUE(\"Sosigise\", 33, 1)");
//            statement.addBatch("INSERT INTO onfreetube.products (product_name, price, shop_id) VALUE(\"Cola\", 38, 3)");
//            statement.addBatch("INSERT INTO onfreetube.products (product_name, price, shop_id) VALUE(\"Snip\", 35, 2)");
//            statement.executeBatch();
//            statement.clearBatch();
            ResultSet resSet = statement.executeQuery("SELECT * FROM onfreetube.products");
            int res = 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }


    }
}