package by.yurachel.web_app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectorDB {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/phone_store";
        Properties prop = new Properties();
        prop.put("user", "Yurachel");
        prop.put("password", "17092015GhjcnjRbrbhtr1823");
        prop.put("autoReconnect", "true");
        prop.put("characterEncoding", "UTF-8");
        prop.put("useUnicode", "true");
        return DriverManager.getConnection(url, prop);
    }
}
