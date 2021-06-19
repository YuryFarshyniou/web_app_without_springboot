package by.yurachel.web_app.dao.jdbc.impl;

import by.yurachel.web_app.dao.IDao;
import by.yurachel.web_app.dao.jdbc.ConnectorDb;
import by.yurachel.web_app.entity.Phone;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcPhoneDao implements IDao<Phone> {

    public static final String SELECT_ALL_FROM_PHONES =
            "SELECT * FROM phones";

    public static final String DELETE_FROM_PHONES_WHERE_ID =
            "DELETE FROM phones WHERE id = ?";

    public static final String ADD_NEW_PHONE_TO_PHONES =
            "INSERT INTO phones(name, price, processor,img)" +
                    "VALUES(?, ?, ?,?) ";

    public static final String UPDATE_PHONE =
            "UPDATE phones SET name=?, price=?, processor=?, img=?" +
                    "WHERE id = (?)";
    public static final String SELECT_PHONE_FROM_PHONES =
            "SELECT * FROM phones where name = (?)";
    public static final String SELECT_PHONE_FROM_PHONES_BY_ID =
            "SELECT * FROM phones where id = (?)";

    public static final Logger LOGGER = LogManager.getLogger(JdbcPhoneDao.class);
    private final ConnectorDb connector = ConnectorDb.getInstance();
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
    public Phone findById(long id) {
        Phone phone = new Phone();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_PHONE_FROM_PHONES_BY_ID)) {
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            rs.next();
            phone.setId(rs.getLong(1));
            phone.setName(rs.getString(2));
            phone.setPrice(rs.getDouble(3));
            phone.setProcessor(rs.getString(4));
            phone.setImg(rs.getString(5));

        } catch (SQLException e) {
            LOGGER.error("Operation findEntity with phone id: {} was failed", id);
        }
        return phone;
    }

    @Override
    public Phone findByName(String phoneName) {
        Phone phone = new Phone();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_PHONE_FROM_PHONES)) {
            statement.setString(1, phoneName);
            ResultSet rs = statement.executeQuery();
            rs.next();
            phone.setId(rs.getLong(1));
            phone.setName(rs.getString(2));
            phone.setPrice(rs.getDouble(3));
            phone.setProcessor(rs.getString(4));
            phone.setImg(rs.getString(5));

        } catch (SQLException e) {
            LOGGER.error("Operation findEntity with phone name: {} was failed", phoneName);
        }
        return phone;
    }

    @Override
    public boolean removeById(long id) {
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
    public boolean updateById(long id, Phone phone) {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_PHONE)) {
            statement.setString(1, phone.getName());
            statement.setDouble(2, phone.getPrice());
            statement.setString(3, phone.getProcessor());
            statement.setString(4, phone.getImg());
            statement.setLong(5, id);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            LOGGER.error("UpdateByName operation wasn't successfully: {},{}",
                    e, e.getMessage());
        }
        return false;
    }

    @Override
    public boolean create(Phone object) {
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
