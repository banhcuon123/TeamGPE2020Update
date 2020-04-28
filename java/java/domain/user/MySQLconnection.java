package domain.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MySQLconnection {

    private static Connection connection;

    private static final MySQLconnection INSTANCE = new MySQLconnection();

    private MySQLconnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/booking_app?noAccessToProcedureBodies=true"
                            ,"root","1234");


        }catch (Exception ex){
        }
    }



    public static MySQLconnection getInstance() {

        return INSTANCE;

    }
    public static Connection getConnection() {
        if (connection == null){
            new MySQLconnection();
        }
        return connection;
    }
}
