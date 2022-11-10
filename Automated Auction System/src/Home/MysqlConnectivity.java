package Home;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static java.lang.Class.forName;

public class MysqlConnectivity {

    public Statement s;
    Connection c;

    public MysqlConnectivity(){


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///auctionsystemdb","root","root");
            s = c.createStatement();
        } catch (Exception e){

            e.printStackTrace();
        }

    }


}
