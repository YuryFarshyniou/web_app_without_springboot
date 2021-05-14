package by.yurachel.web_app.dao.impl;

import by.yurachel.web_app.dao.AbstractDAO;
import by.yurachel.web_app.dao.ConnectorDB;
import by.yurachel.web_app.entity.Phone;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneListDAO extends AbstractDAO<Phone> {

    public static final String SELECT_ALL_FROM_PHONES =
            "SELECT * FROM phones";

    public static final String DELETE_FROM_PHONES_WHERE_ID =
            "DELETE FROM phones WHERE id = ?";

    public static final String ADD_NEW_PHONE_TO_PHONES =
            "INSERT INTO phones(name, price, processor,img)" +
                    "VALUES(?, ?, ?,?) ";

    public static final String UPDATE_PHONE =
            "UPDATE phones SET name=?, price=?, processor=?" +
                    "WHERE name = (?)";

    public static final Logger LOGGER = LogManager.getLogger(PhoneListDAO.class);
    private final ConnectorDB connector = ConnectorDB.getInstance();
    private final Connection connection = connector.getConnection();

    @Override
    public List<Phone> findAll() {
        List<Phone> phones = new ArrayList<>();
        try (Statement statement = this.connection.createStatement()) {
            ResultSet rs = statement.executeQuery(SELECT_ALL_FROM_PHONES);
            while (rs.next()) {
                long id = rs.getLong(1);
                String name = rs.getString(2);
                double price = rs.getDouble(3);
                String processor = rs.getString(4);
                String img = rs.getString(5);
                Phone phone = new Phone(id, name, price, processor, img);
                phones.add(phone);

            }
        } catch (SQLException e) {
            LOGGER.error("SQL connection exception: {} {}", e.getMessage(), e);
        }
        return phones;
    }

    @Override
    public Phone findEntityById(long id) {
        throw new UnsupportedOperationException();
    }


    @Override
    public boolean remove(long id) {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_FROM_PHONES_WHERE_ID)) {
            statement.setLong(1, id);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            LOGGER.error("Remove operation wasn't successfully: {}; {} "
                    , e, e.getMessage());
        }
        return false;
    }

    @Override
    public boolean updateByName(String oldName, Phone phone) {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_PHONE)) {
            statement.setString(1, phone.getName());
            statement.setDouble(2, phone.getPrice());
            statement.setString(3, phone.getProcessor());
            statement.setString(4, oldName);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            LOGGER.error("UpdateByName operation wasn't successfully: {},{}",
                    e, e.getMessage());
        }
        return false;
    }

    @Override
    public boolean addEntity(Phone object) {
        try (PreparedStatement statement = connection.prepareStatement(ADD_NEW_PHONE_TO_PHONES)) {
            statement.setString(1, object.getName());
            statement.setDouble(2, object.getPrice());
            statement.setString(3, object.getProcessor());
            statement.setString(4, object.getImg());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            LOGGER.error("Insert operation wasn't successfully: {}; {}",
                    e, e.getMessage());
        }

        return false;
    }
}
