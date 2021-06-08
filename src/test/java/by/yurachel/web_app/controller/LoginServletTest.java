package by.yurachel.web_app.controller;

import by.yurachel.web_app.HttpInit;
import jakarta.servlet.ServletException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


class LoginServletTest extends HttpInit {

  @InjectMocks
    private LoginServlet loginServlet;



    @Test
    void init() {
        //given
        when(config.getServletContext()).thenReturn(context);
        when(context.getInitParameter("username")).thenReturn("yurachel");
        when(context.getInitParameter("password")).thenReturn("admin");
        //when
        loginServlet.init();

    }

    @Test
    void doGet() throws ServletException, IOException {
        //when
        loginServlet.doGet(request, response);
        //then
        verify(request).getRequestDispatcher(anyString());
        verify(requestDispatcher).forward(request, response);
    }

    @Test
    void doPost() throws ServletException, IOException {
        //given
        when(config.getServletContext()).thenReturn(context);
        when(context.getInitParameter("username")).thenReturn("yurachel");
        when(context.getInitParameter("password")).thenReturn("admin");
        when(request.getParameter("login")).thenReturn("yurachel");
        when(request.getParameter("pass")).thenReturn("admin");
        when(request.getSession(true)).thenReturn(session);
        doNothing().when(session).setAttribute(eq("username"), anyString());
        //when
        loginServlet.init();
        loginServlet.doPost(request, response);
        //then
        verify(session).setAttribute(eq("username"), anyString());
        verify(response).sendRedirect(anyString());
    }

    @Test
    void testPostWhenLoginOrPassEqualsNull() throws ServletException, IOException {
        //given
        when(request.getParameter("login")).thenReturn(null);
        when(request.getParameter("pass")).thenReturn("admin");
        when(request.getSession()).thenReturn(session);
        when(session.getId()).thenReturn("5");
        //when
        loginServlet.doPost(request, response);
    }

    @Test
    void testPostWhenLoginOrPassNotEqualsUserNameOrPassword() throws ServletException, IOException {
        //given
        when(request.getParameter("login")).thenReturn("yurachel");
        when(request.getParameter("pass")).thenReturn("admin");
        when(request.getSession()).thenReturn(session);
        when(session.getId()).thenReturn("5");

        when(config.getServletContext()).thenReturn(context);
        when(context.getInitParameter("username")).thenReturn("yurachels");
        when(context.getInitParameter("password")).thenReturn("admin");

        //when
        loginServlet.init();
        loginServlet.doPost(request, response);
    }
}