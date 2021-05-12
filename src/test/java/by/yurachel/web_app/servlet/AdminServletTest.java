package by.yurachel.web_app.servlet;

import by.yurachel.web_app.HttpInit;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AdminServletTest extends HttpInit {

    @InjectMocks
    private AdminServlet adminServlet;

    @Test
    void doGet() throws ServletException, IOException {
        adminServlet.doGet(request, response);
    }
}