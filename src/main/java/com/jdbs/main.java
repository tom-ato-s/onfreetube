package com.jdbs;


import com.mysql.cj.jdbc.Driver;

import java.net.URL;
import java.sql.*;

public class main {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "12TomatO_=";
    private static final String URL1 = "jdbc:mysql://localhost:3306/onfreetube?useSSL=false";

    public static void main(String[] args) throws SQLException {
        DBProcessor db = new DBProcessor();                  // класс, который даст нам соединение
        Connection conn =  db.getConnection(URL1, USERNAME, PASSWORD);
        String query = "select * from onfreetube.products where product_id = 7";                                       // без where product_id = 7 - выводится вся таблица
        Statement statement = conn.createStatement();  // для выполнения запроса
        ResultSet resSet = statement.executeQuery(query);    // выполнение sql команды эта для выполения запросов

        while (resSet.next()) { //next() - если имеется следуующий после счетчика элемент то             // вывод того что имеется в таблице Products
            int id;
            String name;
            Double price;
            int shopId;
            id = resSet.getInt("product_id");
            name = resSet.getString("product_name");
            price = resSet.getDouble("price");
            shopId = resSet.getInt("shop_id");
            Product product = new Product(id, name, price, shopId);
            System.out.println(product);

        }
        statement.close();
        conn.close();


    }
}