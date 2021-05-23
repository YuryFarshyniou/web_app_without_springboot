package by.yurachel.web_app.dao.impl;

import by.yurachel.web_app.entity.Phone;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


class PhoneListDAOTest {

    @InjectMocks
    PhoneListDAO phoneList;
    @Mock
    Connection connection;
    @Mock
    Statement statement;
    @Mock
    ResultSet resultSet;
    @Mock
    Phone phone;
    @Mock
    PreparedStatement preparedStatement;
    @Mock
    List<Phone> phones;
    public static final String SELECT_ALL_FROM_PHONES =
            "SELECT * FROM phones";

    @Test
    void findAll() throws SQLException {

        when(connection.createStatement()).thenReturn(statement);
        when(statement.executeQuery(SELECT_ALL_FROM_PHONES)).thenReturn(resultSet);
        when(resultSet.getLong(1)).thenReturn(1L);
        when(resultSet.getString(2)).thenReturn("String");
        when(resultSet.getDouble(3)).thenReturn(1.0);
        when(resultSet.getString(4)).thenReturn("Pr");
        when(resultSet.getString(5)).thenReturn("Img");
        doNothing().when(phones).add(phone);
        phoneList.findAll();
    }

    @Test
    void findEntity() {
    }

    @Test
    void testFindEntity() {
    }

    @Test
    void remove() {
    }

    @Test
    void update() {
    }

    @Test
    void addEntity() {
    }
}