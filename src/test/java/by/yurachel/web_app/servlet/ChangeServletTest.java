package by.yurachel.web_app.servlet;

import by.yurachel.web_app.HttpInit;
import by.yurachel.web_app.entity.Phone;
import by.yurachel.web_app.repository.PhoneRepository;
import jakarta.servlet.ServletException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class ChangeServletTest extends HttpInit {

    @InjectMocks
    private ChangeServlet changeServlet;

    @Mock
    PhoneRepository phoneRepository;

    @Test
    void doGet() throws ServletException, IOException {
        changeServlet.doGet(request, response);
    }

    @Test
    void doPost() throws IOException {
        when(request.getParameter("oldName")).thenReturn("oldName");
        when(phoneRepository.findPhoneIDByName(anyString())).thenReturn(3L);
        when(request.getParameter("name")).thenReturn("someName");
        when(request.getParameter("price")).thenReturn("50");
        when(request.getParameter("processor")).thenReturn("exynos");
        doNothing().when(phoneRepository).changePhoneParam(any(Phone.class), anyString());
        changeServlet.doPost(request, response);
        verify(phoneRepository).findPhoneIDByName(anyString());
        verify(phoneRepository).changePhoneParam(any(Phone.class), anyString());
        verify(response).sendRedirect(anyString());
    }

    @Test
    void test_Post_When_OldPhoneName_Equals_Null() throws IOException {
        when(request.getParameter("oldName")).thenReturn(null);
        changeServlet.doPost(request, response);
        verify(phoneRepository).findPhoneIDByName(request.getParameter("oldName"));
        verifyNoMoreInteractions(phoneRepository);
        verifyNoInteractions(response);
    }
}