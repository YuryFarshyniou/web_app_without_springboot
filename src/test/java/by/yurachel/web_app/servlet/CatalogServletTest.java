package by.yurachel.web_app.servlet;

import by.yurachel.web_app.HttpInit;
import by.yurachel.web_app.PhoneArgumentsProvider;
import by.yurachel.web_app.entity.Phone;
import by.yurachel.web_app.repository.PhoneRepository;
import jakarta.servlet.ServletException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

// Для работы логики,Связанной с мокито.
class CatalogServletTest extends HttpInit {


    // Создает объект класса и вводит моки ,созданные с помощью @Mock and @Spy, этот объект.
    @InjectMocks
    private CatalogServlet catalogServlet;

    // Аналогична конструкции mock(HttpServletRequest.class).
    @Mock
    private PhoneRepository phoneRepository;

    /* В теле метода не должно быть строчек инициализации,
 в коде должен быть связан непосредственно с проверкой.В тесте должна быть только бизнес логика.
 * */
    @ParameterizedTest
    @ArgumentsSource(PhoneArgumentsProvider.class)
    void doGetTest(List<Phone> phones) throws ServletException, IOException {

        when(phoneRepository.getPhones()).thenReturn(phones);
        catalogServlet.doGet(request, response);
        verify(phoneRepository).getPhones(); // Проверяем,что у мока вызвался метод.
        verify(request).setAttribute("phones", phoneRepository.getPhones());
        verify(request).getRequestDispatcher("WEB-INF/catalog.jsp");
        verify(requestDispatcher).forward(request, response);
    }

    @Test
    void doGetNoProductsReturned() throws ServletException, IOException {
        when(phoneRepository.getPhones()).thenReturn(Collections.emptyList());
        catalogServlet.doGet(request, response);

        verify(phoneRepository).getPhones();
        verify(request, times(0)).setAttribute(anyString(), anyList());
        verify(request).getRequestDispatcher("WEB-INF/catalog.jsp");
        verify(requestDispatcher).forward(request, response);

    }

    @Test
    void doGetThrowException() throws ServletException, IOException {
        when(phoneRepository.getPhones()).thenThrow(new IllegalArgumentException("some message"));
        IllegalArgumentException illegalArgumentException =
                assertThrows(IllegalArgumentException.class, () ->
                        catalogServlet.doGet(request, response));
        assertNotNull(illegalArgumentException);
        assertEquals("some message", illegalArgumentException.getMessage());
        verify(phoneRepository).getPhones();
        verifyNoInteractions(request);
        verifyNoInteractions(requestDispatcher);
    }
}