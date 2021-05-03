package by.yurachel.web_app.servlet;

import by.yurachel.web_app.entity.Phone;
import by.yurachel.web_app.repository.PhoneRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class AddPhoneServletTest {
    private AddPhoneServlet addPhoneServlet;
    private PhoneRepository pr;

    MockedStatic<PhoneRepository> dummy = Mockito.mockStatic(PhoneRepository.class);

    @BeforeEach
    void setUp() {
        addPhoneServlet = new AddPhoneServlet();
        pr = mock(PhoneRepository.class);
    }


    @Test
    void doGetTest() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);
        doNothing().when(requestDispatcher).forward(request, response);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        addPhoneServlet.doGet(request, response);
    }

    @Test
    void added_New_Phone_In_Our_DB_With_Do_Post_Method_Test() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getParameter("name")).thenReturn("anyString()");
        when(request.getParameter("price")).thenReturn("50");
        when(request.getParameter("processor")).thenReturn("snap");
        dummy.when(PhoneRepository::maxPhoneID).thenReturn(5);
        Phone pe = new Phone(PhoneRepository.maxPhoneID(),
                request.getParameter("name"),
                Double.parseDouble(request.getParameter("price")),
                request.getParameter("processor"));
        doNothing().when(pr).addProduct(pe);
        doNothing().when(response).sendRedirect(anyString());
        addPhoneServlet.doPost(request, response);
    }

}