package by.yurachel.web_app.controller;

import by.yurachel.web_app.HttpInit;
import by.yurachel.web_app.dao.DAOProvider;
import by.yurachel.web_app.dao.impl.PhoneListDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RemoveServletTest extends HttpInit {

    @InjectMocks
    private RemoveServlet removeServlet;

    @Mock
    DAOProvider phoneProvider;

    @Mock
    private PhoneListDAO phoneListDAO;


    @Test
    void doPost() throws IOException {
        when(request.getParameter("id")).thenReturn("100");
        when(phoneListDAO.remove(anyLong())).thenReturn(true);
        removeServlet.doPost(request, response);
        verify(phoneListDAO).remove(anyLong());
        verify(response).sendRedirect(anyString());
    }

    @Test
    void testPostWithNullID() throws IOException {
        when(request.getParameter("id")).thenReturn(null);
        removeServlet.doPost(request, response);
        verifyNoInteractions(phoneListDAO);
    }

    @Test
    void testPostWhenIDEqualsNegativeNumber() throws IOException {
        when(request.getParameter("id")).thenReturn("-1");
        removeServlet.doPost(request, response);
    }
}