package by.yurachel.web_app.servlet;

import by.yurachel.web_app.HttpInit;
import by.yurachel.web_app.PhoneArgumentsProvider;
import by.yurachel.web_app.entity.Phone;
import by.yurachel.web_app.repository.PhoneRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class RemoveServletTest extends HttpInit {

    @InjectMocks
    private RemoveServlet removeServlet;

    @Mock
    private PhoneRepository phoneRepository;


    @Test
    void doPost() throws IOException {
        when(request.getParameter("id")).thenReturn("2");
        doNothing().when(phoneRepository).removePhone(anyLong());
        when(phoneRepository.removeId(anyLong())).thenReturn(true);
        removeServlet.doPost(request, response);
        verify(phoneRepository).removePhone(Long.parseLong(request.getParameter("id")));
    }

    @Test
    void testPostWithNullID() throws IOException {
        when(request.getParameter("id")).thenReturn(null);
        removeServlet.doPost(request, response);
        verifyNoInteractions(phoneRepository);
    }

    @Test
    void testPostWhenIDEqualsNegativeNumber() throws IOException {
        when(request.getParameter("id")).thenReturn("-1");
        removeServlet.doPost(request, response);
    }
}