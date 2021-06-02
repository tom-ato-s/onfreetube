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
        String query = "select * from onfreetube.products";


        String INSERT = "insert into onfreetube.products (product_name, price, shop_id) value (?, ?, ?)";
        PreparedStatement prepInsert = conn.prepareStatement(INSERT);
        prepInsert.setString(1,"Ege");
        prepInsert.setDouble(2,9.9);
        prepInsert.setInt(3, 1);
        prepInsert.execute();


        PreparedStatement prepStat = conn.prepareStatement(query);                              //запрос вводится в память PreparedStatement и может повторяться много раз подняд на разных значениях
        ResultSet resSet = prepStat.executeQuery();

        while (resSet.next()) {
            System.out.println(resSet.getInt("product_id") + " " + resSet.getString("product_name"));
        }
        prepStat.close();
        conn.close();

    }
}