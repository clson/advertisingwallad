package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class ddd {
    public static String uri="jdbc:mysql://127.0.0.1:3306/guanggao_db?user=root&password=root&useSSL=true&&characterEncoding=utf-8";
    public Connection con;
    public final void ConnectDatabase(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection(uri);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

}
