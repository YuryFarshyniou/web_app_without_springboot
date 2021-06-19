package by.yurachel.web_app.controller;

import by.yurachel.web_app.HttpInit;
import by.yurachel.web_app.dao.IDao;
import by.yurachel.web_app.entity.Phone;
import javax.servlet.ServletException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class ChangeServletTest extends HttpInit {

    @InjectMocks
    private UpdateServlet changeServlet;

    @Mock
    private IDao<Phone> daoProvider;

    @Test
    void doGet() throws ServletException, IOException {
        changeServlet.doGet(request, response);
    }

    @Test
    void doPost() throws IOException {
        //given
        when(request.getParameter("oldName")).thenReturn("oldName");
        when(request.getParameter("name")).thenReturn("someName");
        when(request.getParameter("price")).thenReturn("50");
        when(request.getParameter("processor")).thenReturn("exynos");
        when(daoProvider.updateById(anyLong(), any(Phone.class))).thenReturn(true);
        //when
        changeServlet.doPost(request, response);
        //then
        verify(daoProvider).updateById(anyLong(), any(Phone.class));
        verify(response).sendRedirect(anyString());
    }

    @Test
    void testPostWhenOldPhoneNameEqualsNull() throws IOException {
        //given
        when(request.getParameter("oldName")).thenReturn(null);
        //when
        changeServlet.doPost(request, response);
        //then
        verifyNoInteractions(daoProvider);
        verifyNoInteractions(response);
    }

    @Test
    void testPostWhenIsSuccessEqualsFalse() throws IOException {
        //given
        when(request.getParameter("oldName")).thenReturn("oldName");
        when(request.getParameter("name")).thenReturn("someName");
        when(request.getParameter("price")).thenReturn("50");
        when(request.getParameter("processor")).thenReturn("exynos");
        when(daoProvider.updateById(anyLong(), any(Phone.class))).thenReturn(false);
        //when
        changeServlet.doPost(request, response);
        //then
        verify(daoProvider).updateById(anyLong(), any(Phone.class));
        verify(response).sendRedirect(anyString());
    }
}