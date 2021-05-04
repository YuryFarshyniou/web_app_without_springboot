package by.yurachel.web_app.servlet;

import by.yurachel.web_app.entity.Phone;
import by.yurachel.web_app.repository.PhoneRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class AddPhoneServletTest {
    private AddPhoneServlet addPhoneServlet;
    private PhoneRepository pr;
    private MockedStatic<PhoneRepository> capPhoneRep;

    @BeforeEach
    void setUp() {
        addPhoneServlet = new AddPhoneServlet();
        pr = mock(PhoneRepository.class);
        capPhoneRep = Mockito.mockStatic(PhoneRepository.class);
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
        capPhoneRep.when(PhoneRepository::maxPhoneID).thenReturn(5);
        int id = PhoneRepository.maxPhoneID();
        Phone pe = new Phone(id,
                request.getParameter("name"),
                Double.parseDouble(request.getParameter("price")),
                request.getParameter("processor"));
        doNothing().when(pr).addProduct(pe);
        doNothing().when(response).sendRedirect(anyString());
        addPhoneServlet.doPost(request, response);
    }



}