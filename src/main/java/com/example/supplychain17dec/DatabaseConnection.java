package com.example.supplychain17dec;
import java.sql.*;

public class DatabaseConnection {
private static final String databaseUrl = "jdbc:mysql://localhost:3306/supply_chain_dec";
private static final String user = "root";
private static final String password = "Rohit@123";

public  Statement getStatement(){
Statement statement = null;
Connection conn;
try{
    conn = DriverManager.getConnection(databaseUrl,user,password);
    statement = conn.createStatement();
}catch (Exception e){
    e.printStackTrace();
}
    return statement;
}
public ResultSet getQueryTable(String query){
    Statement statement = getStatement();
    try{
        return statement.executeQuery(query);
    }catch (Exception e){
        e.printStackTrace();
    }
    return null;
}

    public static void main(String[] args) {

        DatabaseConnection databaseconnection = new DatabaseConnection();
        ResultSet rs =databaseconnection.getQueryTable("Select email,first_name from customer");
        try {
            while (rs.next()){
              System.out.println(rs.getString("email")+" "+rs.getString("first_name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
