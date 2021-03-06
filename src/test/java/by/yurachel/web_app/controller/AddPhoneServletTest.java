package by.yurachel.web_app.controller;


//class AddPhoneServletTest extends HttpInit {
//
//    @InjectMocks
//    private AddPhoneServlet addPhoneServlet;
//
//    @Mock
//    private IDao<Phone> daoProvider;
//
//    @Test
//    void doGet() throws ServletException, IOException {
//        addPhoneServlet.doGet(request, response);
//    }
//
//    @Test
//    void testDoPost() throws IOException {
//        //given
//        when(request.getParameter("name")).thenReturn("anyString()");
//        when(request.getParameter("price")).thenReturn("2");
//        when(request.getParameter("processor")).thenReturn("snap");
//        when(daoProvider.create(any(Phone.class))).thenReturn(true);
//
//        //when
//        addPhoneServlet.doPost(request, response);
//
//        //then
//        verify(daoProvider).create(any(Phone.class));
//        verify(response).sendRedirect(anyString());
//    }
//
//    @Test
//    void testDoPostWhenNameEqualsNull() {
//        //given
//        when(request.getParameter("name")).thenReturn(null);
//        when(request.getParameter("price")).thenReturn("2");
//        when(request.getParameter("processor")).thenReturn("snap");
//        //when
//        IllegalArgumentException illegalArgumentException =
//                assertThrows(IllegalArgumentException.class,
//                        () -> addPhoneServlet.doPost(request, response));
//        //then
//        assertNotNull(illegalArgumentException);
//        verifyNoInteractions(response);
//        assertEquals("Name of the phone can't be null.", illegalArgumentException.getMessage());
//    }
//
//    @Test
//    void testDoPostWhenIsSuccessEqualsFalse() throws IOException {
//        //given
//        when(request.getParameter("name")).thenReturn("anyString()");
//        when(request.getParameter("price")).thenReturn("2");
//        when(request.getParameter("processor")).thenReturn("snap");
//        when(daoProvider.create(any(Phone.class))).thenReturn(false);
//        //when
//        addPhoneServlet.doPost(request, response);
//        //then
//        verify(daoProvider).create(any(Phone.class));
//        verify(response).sendRedirect(anyString());
//    }
//}