package by.yurachel.web_app.servlet;

import by.yurachel.web_app.HttpInit;
import jakarta.servlet.ServletException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


class LoginServletTest extends HttpInit {
    @InjectMocks
    private LoginServlet loginServlet;


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
    void testPostWhenLoginOrPassEqualsNull() throws ServletException, IOException {
        when(request.getParameter("login")).thenReturn(null);
        when(request.getParameter("pass")).thenReturn("admin");
        when(request.getSession()).thenReturn(session);
        when(session.getId()).thenReturn("5");
        loginServlet.doPost(request, response);
    }

    @Test
    void testPostWhenLoginOrPassNotEqualsUserNameOrPassword() throws ServletException, IOException {
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