package by.yurachel.web_app.servlet;

import by.yurachel.web_app.entity.Phone;
import by.yurachel.web_app.repository.PhoneRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class RemoveServletTest {
    private RemoveServlet removeServlet;
    private PhoneRepository pr;
    private MockedStatic<PhoneRepository> capPhoneRep;

    @BeforeEach
    void setUp() {
        removeServlet = new RemoveServlet();
        pr = mock(PhoneRepository.class);
        capPhoneRep = Mockito.mockStatic(PhoneRepository.class);
    }

    @Test
    void doPost() throws IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        doNothing().when(pr).removePhone(anyInt());
        doNothing().when(response).sendRedirect(anyString());

        when(request.getParameter(anyString())).thenReturn("1");

        int id = Integer.parseInt(request.getParameter(anyString()));

        when(pr.findPhoneById(id)).thenThrow(IllegalArgumentException.class);

        removeServlet.doPost(request, response);
    }

}