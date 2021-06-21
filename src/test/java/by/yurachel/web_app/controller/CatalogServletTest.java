package by.yurachel.web_app.controller;

import by.yurachel.web_app.HttpInit;
import by.yurachel.web_app.PhoneArgumentsProvider;
import by.yurachel.web_app.dao.IDao;
import by.yurachel.web_app.entity.Phone;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
// Для работы логики,Связанной с мокито.

//class CatalogServletTest extends HttpInit {
//
//    // Создает объект класса и вводит моки ,созданные с помощью @Mock and @Spy, этот объект.
//    @InjectMocks
//    private CatalogServlet catalogServlet;
//
//    // Аналогична конструкции mock(HttpServletRequest.class).
//    @Mock
//    private IDao<Phone> daoProvider;
//
//
//    /* В теле метода не должно быть строчек инициализации,
// в коде должен быть связан непосредственно с проверкой.В тесте должна быть только бизнес логика.
// * */
//    @ParameterizedTest
//    @ArgumentsSource(PhoneArgumentsProvider.class)
//    void doGetTest(List<Phone> phones) throws ServletException, IOException {
//        //given
//        when(daoProvider.findAll()).thenReturn(phones);
//        //when
//        catalogServlet.doGet(request, response);
//        //then
//        verify(daoProvider).findAll(); // Проверяем,что у мока вызвался метод.
//        verify(request).setAttribute("phones", phones);
//        verify(request).getRequestDispatcher("WEB-INF/catalog.jsp");
//        verify(requestDispatcher).forward(request, response);
//    }
//
//    @Test
//    void doGetNoProductsReturned() throws ServletException, IOException {
//        //given
//        when(daoProvider.findAll()).thenReturn(Collections.emptyList());
//        //when
//        catalogServlet.doGet(request, response);
//        //then
//        verify(daoProvider).findAll();
//        verify(request, times(0)).setAttribute(anyString(), anyList());
//        verify(request).getRequestDispatcher("WEB-INF/catalog.jsp");
//        verify(requestDispatcher).forward(request, response);
//
//    }
//
//    @Test
//    void doGetThrowException() throws ServletException, IOException {
//        //given
//        when(daoProvider.findAll()).thenThrow(new IllegalArgumentException("some message"));
//        //when
//        IllegalArgumentException illegalArgumentException =
//                assertThrows(IllegalArgumentException.class, () ->
//                        catalogServlet.doGet(request, response));
//        //then
//        assertNotNull(illegalArgumentException);
//        assertEquals("some message", illegalArgumentException.getMessage());
//        verify(daoProvider).findAll();
//        verifyNoInteractions(request);
//        verifyNoInteractions(requestDispatcher);
//    }
//}