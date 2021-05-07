package by.yurachel.web_app.dao;

import by.yurachel.web_app.entity.Phone;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PhoneListDAO extends AbstractDAO<Phone> {

    public static final String SELECT_ALL_FROM_PHONES = "SELECT * FROM phones";
    public static final Logger ROOT_LOGGER = LogManager.getRootLogger();

    @Override
    public List<Phone> findAll() {
        List<Phone> phones = new ArrayList<>();
        try (Connection connection = ConnectorDB.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(SELECT_ALL_FROM_PHONES);
            while (rs.next()) {
                long id = rs.getLong(1);
                String name = rs.getString(2);
                double price = rs.getDouble(3);
                String processor = rs.getString(4);
                Phone phone = new Phone(id, name, price, processor);
                phones.add(phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            ROOT_LOGGER.error("SQL connection exception: {} {}", e.getMessage(), e);
        }
        return phones;
    }

    @Override
    public Phone findEntityById(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Phone object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean update(Phone object) {
        throw new UnsupportedOperationException();
    }
}
