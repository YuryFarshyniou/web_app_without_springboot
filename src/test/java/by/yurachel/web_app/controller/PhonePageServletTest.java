package by.yurachel.web_app.controller;

//class PhonePageServletTest extends HttpInit {
//
//    @InjectMocks
//    private PhonePageServlet phonePageServlet;
//
//    @Mock
//    IDao<Phone> daoProvider;
//    @Mock
//    Phone phone;
//
//    @Test
//    void doGet() throws ServletException, IOException {
//        when(request.getParameter("name")).thenReturn("phone");
//        when(daoProvider.findByName("phone")).thenReturn(phone);
//        doNothing().when(request).setAttribute(eq("phone"), eq(phone));
//        phonePageServlet.doGet(request, response);
//        verify(request).getParameter(anyString());
//        verify(daoProvider).findByName(anyString());
//        verify(request).setAttribute(anyString(), any(Phone.class));
//    }
//
//    @Test
//    void doGetWhenPhoneNameIsNull() {
//        when(request.getParameter("name")).thenReturn(null);
//        when(daoProvider.findByName(null))
//                .thenThrow(new IllegalArgumentException("Can't find such phone"));
//        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
//                phonePageServlet.doGet(request, response));
//        assertNotNull(ex);
//        assertEquals("Can't find such phone", ex.getMessage());
//        verifyNoInteractions(requestDispatcher);
//    }
//
//    @Test
//    void doGetWhenPhoneIsNull() throws ServletException, IOException {
//        when(request.getParameter("name")).thenReturn("anyPhone");
//        when(daoProvider.findByName("anyPhone")).thenReturn(null);
//        phonePageServlet.doGet(request, response);
//        verify(request).getParameter(anyString());
//        verify(daoProvider).findByName(anyString());
//    }
//
//    @Test
//    void doGetWhenSetAttributeIsFailed() throws ServletException, IOException {
//        when(request.getParameter("name")).thenReturn("anyPhone");
//        when(daoProvider.findByName("anyPhone")).thenReturn(phone);
//        doThrow(new IllegalArgumentException("exception"))
//                .when(request).setAttribute("anyPhone", phone);
//        phonePageServlet.doGet(request, response);
//        verify(request).getParameter(anyString());
//        verify(daoProvider).findByName(anyString());
//    }
//
//}