package by.yurachel.web_app.dao.jdbc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectorDb {
    private Connection connection;
    public static final Logger LOGGER = LogManager.getLogger(ConnectorDb.class);

    public static class ConnectorDBHolder {
        public static final ConnectorDb INSTANCE = new ConnectorDb();
    }

    public static ConnectorDb getInstance() {
        return ConnectorDBHolder.INSTANCE;
    }

    private ConnectorDb() {

        String url = "jdbc:mysql://localhost:3306/phone_store";
        Properties prop = new Properties();
        prop.put("user", "Yurachel");
        prop.put("password", "17092015GhjcnjRbrbhtr1823");
        prop.put("autoReconnect", "true");
        prop.put("characterEncoding", "UTF-8");
        prop.put("useUnicode", "true");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, prop);
            LOGGER.info("Connection established successfully");
        } catch (SQLException e) {
            LOGGER.error("Can't get connection with DB. {}", e.getMessage());
        } catch (ClassNotFoundException e) {
            LOGGER.error("Exception was caught {} {}", e.getMessage(), e);
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
