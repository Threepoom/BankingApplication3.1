package BankingApplication3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BankConnection {
        public static Connection connect() {
            String URL = "jdbc:mysql://localhost:3306/mydb3";
            String username = "root";
            String password = "mysql@sit";
            Connection con = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(URL, username, password);

            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return con;
        }
    }

