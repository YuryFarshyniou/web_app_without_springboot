package by.yurachel.web_app.servlet;

import by.yurachel.web_app.HttpInit;
import by.yurachel.web_app.entity.Phone;
import by.yurachel.web_app.repository.PhoneRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


class AddPhoneServletTest extends HttpInit {

    @InjectMocks
    private AddPhoneServlet addPhoneServlet;

    @Mock
    private PhoneRepository phoneRepository;


    @Test
    void testDoPost() throws IOException {
        when(phoneRepository.maxPhoneID()).thenReturn(5L);
        when(request.getParameter("name")).thenReturn("anyString()");
        when(request.getParameter("price")).thenReturn("2");
        when(request.getParameter("processor")).thenReturn("snap");
        doNothing().when(phoneRepository).addPhone(any(Phone.class));
        addPhoneServlet.doPost(request, response);
        verify(phoneRepository).addPhone(any(Phone.class));

    }

    @Test
    void test_Do_Post_When_Name_Equals_Null() {
        when(request.getParameter("name")).thenReturn(null);
        when(request.getParameter("price")).thenReturn("2");
        when(request.getParameter("processor")).thenReturn("snap");
        when(phoneRepository.maxPhoneID()).thenReturn(5L);
        IllegalArgumentException illegalArgumentException =
                assertThrows(IllegalArgumentException.class, () -> addPhoneServlet.doPost(request, response));

        assertNotNull(illegalArgumentException);
        verifyNoInteractions(response);
        assertEquals("Name of the phone can't be null.", illegalArgumentException.getMessage());
    }
}