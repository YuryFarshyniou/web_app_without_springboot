package by.yurachel.web_app.servlet;

import by.yurachel.web_app.HttpInit;
import by.yurachel.web_app.repository.PhoneRepository;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


class LoginServletTest extends HttpInit {
    @InjectMocks
    private LoginServlet loginServlet;
    @Mock
    private ServletConfig config;
    @Mock
    private ServletContext context;
    @Mock
    private HttpSession session;

    @Test
    void init() {
        when(config.getServletContext()).thenReturn(context);
        when(context.getInitParameter("username")).thenReturn("yurachel");
        when(context.getInitParameter("password")).thenReturn("admin");
        loginServlet.init();
    }

    @Test
    void doGet() throws ServletException, IOException {
        loginServlet.doGet(request, response);
        verify(request).getRequestDispatcher(anyString());
        verify(requestDispatcher).forward(request, response);
    }

    @Test
    void doPost() throws ServletException, IOException {
        when(config.getServletContext()).thenReturn(context);
        when(context.getInitParameter("username")).thenReturn("yurachel");
        when(context.getInitParameter("password")).thenReturn("admin");

        when(request.getParameter("login")).thenReturn("yurachel");
        when(request.getParameter("pass")).thenReturn("admin");
        when(request.getSession(true)).thenReturn(session);
        doNothing().when(session).setAttribute(eq("username"), any(Object.class));

        loginServlet.init();
        loginServlet.doPost(request, response);
        verify(request).getSession(anyBoolean());
        verify(session).setAttribute(eq("username"), any(Object.class));
        verify(response).sendRedirect(anyString());
    }

    @Test
    void test_Post_When_Login_Or_Pass_Equals_Null() throws ServletException, IOException {
        when(request.getParameter("login")).thenReturn(null);
        when(request.getParameter("pass")).thenReturn("admin");
        when(request.getSession()).thenReturn(session);
        when(session.getId()).thenReturn("5");
        loginServlet.doPost(request, response);
    }

    @Test
    void test_Post_When_Login_Or_Pass_Not_Equals_UserName_Or_Password() throws ServletException, IOException {
        when(request.getParameter("login")).thenReturn("yurachel");
        when(request.getParameter("pass")).thenReturn("admin");
        when(request.getSession()).thenReturn(session);
        when(session.getId()).thenReturn("5");

        when(config.getServletContext()).thenReturn(context);
        when(context.getInitParameter("username")).thenReturn("yurachels");
        when(context.getInitParameter("password")).thenReturn("admin");
        loginServlet.init();

        loginServlet.doPost(request, response);
    }
}