package by.yurachel.web_app.servlet;

import by.yurachel.web_app.HttpInit;
import by.yurachel.web_app.dao.DAOProvider;
import by.yurachel.web_app.dao.impl.PhoneListDAO;
import by.yurachel.web_app.entity.Phone;
import jakarta.servlet.ServletException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class ChangeServletTest extends HttpInit {

    @InjectMocks
    private ChangeServlet changeServlet;

    @Mock
    DAOProvider phoneProvider;

    @Mock
    PhoneListDAO phoneListDAO;

    @Test
    void doGet() throws ServletException, IOException {
        changeServlet.doGet(request, response);
    }

    @Test
    void doPost() throws IOException {
        when(request.getParameter("oldName")).thenReturn("oldName");
        when(request.getParameter("name")).thenReturn("someName");
        when(request.getParameter("price")).thenReturn("50");
        when(request.getParameter("processor")).thenReturn("exynos");
        when(phoneListDAO.update(anyString(), any(Phone.class))).thenReturn(true);
        changeServlet.doPost(request, response);
        verify(phoneListDAO).update(anyString(), any(Phone.class));
        verify(response).sendRedirect(anyString());
    }

    @Test
    void testPostWhenOldPhoneNameEqualsNull() throws IOException {
        when(request.getParameter("oldName")).thenReturn(null);
        changeServlet.doPost(request, response);
        verifyNoInteractions(phoneListDAO);
        verifyNoInteractions(response);
    }

    @Test
    void testPostWhenIsSuccessEqualsFalse() throws IOException {
        when(request.getParameter("oldName")).thenReturn("oldName");
        when(request.getParameter("name")).thenReturn("someName");
        when(request.getParameter("price")).thenReturn("50");
        when(request.getParameter("processor")).thenReturn("exynos");
        when(phoneListDAO.update(anyString(), any(Phone.class))).thenReturn(false);
        changeServlet.doPost(request, response);
        verify(phoneListDAO).update(anyString(), any(Phone.class));
        verify(response).sendRedirect(anyString());
    }
}