package by.yurachel.web_app.controller;

import by.yurachel.web_app.HttpInit;
import by.yurachel.web_app.dao.IDao;
import by.yurachel.web_app.entity.Phone;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

//@ExtendWith(MockitoExtension.class)
//class RemoveServletTest extends HttpInit {
//
//    @InjectMocks
//    private RemoveServlet removeServlet;
//
//    @Mock
//    IDao<Phone> daoProvider;
//
//
//    @Test
//    void doPost() throws IOException {
//        when(request.getParameter("id")).thenReturn("100");
//        when(daoProvider.removeById(anyLong())).thenReturn(true);
//        removeServlet.doPost(request, response);
//        verify(daoProvider).removeById(anyLong());
//        verify(response).sendRedirect(anyString());
//    }
//
//    @Test
//    void testPostWithNullID() throws IOException {
//        when(request.getParameter("id")).thenReturn(null);
//        removeServlet.doPost(request, response);
//        verifyNoInteractions(daoProvider);
//    }
//
//    @Test
//    void testPostWhenIDEqualsNegativeNumber() throws IOException {
//        when(request.getParameter("id")).thenReturn("-1");
//        removeServlet.doPost(request, response);
//    }
//}