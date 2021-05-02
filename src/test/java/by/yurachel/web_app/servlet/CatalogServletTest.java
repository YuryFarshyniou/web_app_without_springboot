package by.yurachel.web_app.servlet;

import by.yurachel.web_app.entity.Phone;
import by.yurachel.web_app.repository.PhoneRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class CatalogServletTest {
    private CatalogServlet catalogServlet;
    private PhoneRepository pr;
    private List<Phone> lists;

    @BeforeEach
    void setUp() {
        catalogServlet = new CatalogServlet();
        pr = mock(PhoneRepository.class);
        lists = mock(List.class);
    }

    @Test
    void doGetTest() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);

        when(pr.getPhones()).thenReturn(lists);
        doNothing().when(request).setAttribute(anyString(), pr.getPhones());
        verify(request).setAttribute(anyString(), pr.getPhones());

        doNothing().when(requestDispatcher).forward(request, response);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        catalogServlet.doGet(request, response);
    }


}