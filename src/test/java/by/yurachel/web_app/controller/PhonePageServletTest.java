package by.yurachel.web_app.controller;

import by.yurachel.web_app.HttpInit;
import by.yurachel.web_app.dao.AbstractDAO;
import by.yurachel.web_app.dao.DAOProvider;
import by.yurachel.web_app.dao.impl.PhoneListDAO;
import by.yurachel.web_app.entity.Phone;
import jakarta.servlet.ServletException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

class PhonePageServletTest extends HttpInit {

    @InjectMocks
    private PhonePageServlet phonePageServlet;

    @Mock
    private DAOProvider phoneProvider;
    @Mock
    private PhoneListDAO abstractDAO;

    @Test
    void doGet() throws ServletException, IOException {
        when(request.getParameter(eq("name"))).thenReturn("phone");
        when(abstractDAO.findEntity("phone")).thenReturn(any(Phone.class));
        doNothing().when(request).setAttribute(eq("phone"), any(Phone.class));
        phonePageServlet.doGet(request, response);
    }
}