package by.yurachel.web_app.servlet;

import by.yurachel.web_app.repository.PhoneRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class RemoveServletTest {
    private RemoveServlet removeServlet;
    private PhoneRepository pr;

    @BeforeEach
    void setUp() {
        removeServlet = new RemoveServlet();
        pr = mock(PhoneRepository.class);
    }

    @Test
    void doPost() throws IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getParameter(anyString())).thenReturn("50");
        int id = Integer.parseInt(request.getParameter(anyString()));
        doNothing().when(pr).removePhone(id);
        doNothing().when(response).sendRedirect(anyString());
        removeServlet.doPost(request, response);
    }

    @Test
    void throw_Exception_when_illegal_ID(){

    }

}