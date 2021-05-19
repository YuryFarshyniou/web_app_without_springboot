package by.yurachel.web_app.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectorDB {
    private Connection connection;
    public static final Logger LOGGER = LogManager.getLogger(ConnectorDB.class);

    public static class ConnectorDBHolder {
        public static final ConnectorDB INSTANCE = new ConnectorDB();
    }

    public static ConnectorDB getInstance() {
        return ConnectorDBHolder.INSTANCE;
    }

    private ConnectorDB() {

        String url = "jdbc:mysql://localhost:3306/phone_store";
        Properties prop = new Properties();
        prop.put("user", "Yurachel");
        prop.put("password", "17092015GhjcnjRbrbhtr1823");
        prop.put("autoReconnect", "true");
        prop.put("characterEncoding", "UTF-8");
        prop.put("useUnicode", "true");
        try {
            this.connection = DriverManager.getConnection(url, prop);
        } catch (SQLException e) {
            LOGGER.error("Can't get connection with DB.");
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
