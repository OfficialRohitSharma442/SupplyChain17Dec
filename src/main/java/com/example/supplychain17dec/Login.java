package com.example.supplychain17dec;

import java.sql.ResultSet;

public class Login {
    public boolean customerLogin(String email, String password){
      String query = String.format("Select * from customer where email ='%s' AND password = '%s' ",email,password);
      try{
          DatabaseConnection dbConn = new DatabaseConnection();
          ResultSet rs = dbConn.getQueryTable(query);
          if(rs!=null && rs.next()){
              return true;
          }
      }catch (Exception e){
          e.printStackTrace();
      }
        return false;
    }

    public static void main(String[] args) {
        Login login = new Login();
        System.out.println(login.customerLogin("rohit@gmail.com","admin"));
    }
}
