package by.yurachel.web_app.controller;

import static org.mockito.ArgumentMatchers.any;

//class ChangeServletTest extends HttpInit {
//
//    @InjectMocks
//    private UpdateServlet changeServlet;
//
//    @Mock
//    private IDao<Phone> daoProvider;
//
//    @Test
//    void doGet() throws ServletException, IOException {
//        changeServlet.doGet(request, response);
//    }
//
//    @Test
//    void doPost() throws IOException {
//        //given
//        when(request.getParameter("oldName")).thenReturn("oldName");
//        when(request.getParameter("name")).thenReturn("someName");
//        when(request.getParameter("price")).thenReturn("50");
//        when(request.getParameter("processor")).thenReturn("exynos");
//        when(daoProvider.updateById(anyLong(), any(Phone.class))).thenReturn(true);
//        //when
//        changeServlet.doPost(request, response);
//        //then
//        verify(daoProvider).updateById(anyLong(), any(Phone.class));
//        verify(response).sendRedirect(anyString());
//    }
//
//    @Test
//    void testPostWhenOldPhoneNameEqualsNull() throws IOException {
//        //given
//        when(request.getParameter("oldName")).thenReturn(null);
//        //when
//        changeServlet.doPost(request, response);
//        //then
//        verifyNoInteractions(daoProvider);
//        verifyNoInteractions(response);
//    }
//
//    @Test
//    void testPostWhenIsSuccessEqualsFalse() throws IOException {
//        //given
//        when(request.getParameter("oldName")).thenReturn("oldName");
//        when(request.getParameter("name")).thenReturn("someName");
//        when(request.getParameter("price")).thenReturn("50");
//        when(request.getParameter("processor")).thenReturn("exynos");
//        when(daoProvider.updateById(anyLong(), any(Phone.class))).thenReturn(false);
//        //when
//        changeServlet.doPost(request, response);
//        //then
//        verify(daoProvider).updateById(anyLong(), any(Phone.class));
//        verify(response).sendRedirect(anyString());
//    }
//}