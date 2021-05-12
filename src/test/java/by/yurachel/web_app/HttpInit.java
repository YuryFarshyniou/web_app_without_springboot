package by.yurachel.web_app;

import by.yurachel.web_app.repository.PhoneRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public abstract class HttpInit {

    @Mock(lenient = true)
    protected HttpServletResponse response;

    @Mock(lenient = true)
    protected HttpServletRequest request;

    @Mock(lenient = true)
    protected RequestDispatcher requestDispatcher;

    @BeforeEach
    protected void setUp() throws ServletException, IOException {
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        doNothing().when(requestDispatcher).forward(request, response);
    }

    @BeforeEach
    protected void setResponse() throws IOException {
        doNothing().when(response).sendRedirect(anyString());
    }
}
