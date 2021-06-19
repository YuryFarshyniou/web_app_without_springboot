package by.yurachel.web_app.controller;

import by.yurachel.web_app.HttpInit;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import javax.servlet.ServletException;
import java.io.IOException;

class HomeServletTest extends HttpInit {

    @InjectMocks
    private HomeServlet homeServlet;

    @Test
    void doGet() throws ServletException, IOException {
        homeServlet.doGet(request, response);
    }
}