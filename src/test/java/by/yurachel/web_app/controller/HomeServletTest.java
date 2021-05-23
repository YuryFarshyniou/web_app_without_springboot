package by.yurachel.web_app.controller;

import by.yurachel.web_app.HttpInit;
import jakarta.servlet.ServletException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class HomeServletTest extends HttpInit {

    @InjectMocks
    private HomeServlet homeServlet;

    @Test
    void doGet() throws ServletException, IOException {
        homeServlet.doGet(request, response);
    }
}