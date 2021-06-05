package by.yurachel.web_app.controller;

import by.yurachel.web_app.dao.DAOProviderCommon;
import by.yurachel.web_app.dao.IDao;
import by.yurachel.web_app.dao.hibernate.impl.HibPhoneListDao;
import by.yurachel.web_app.dao.jpa.impl.JPAPhoneListDAO;
import by.yurachel.web_app.entity.Phone;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

@WebServlet(name = "phonePage", urlPatterns = "/phonePage")
public class PhonePageServlet extends HttpServlet {
    private IDao<Phone> daoProvider = DAOProviderCommon.getInstance().getIPhoneDAO();

    private static final Logger LOGGER = LogManager.getLogger(CatalogServlet.class);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phoneName = req.getParameter("name");
        Phone phone = daoProvider.findByName(phoneName);

        if (!(phone == null)) {
            req.setAttribute("phone", phone);
            LOGGER.info("Attribute {} was successfully added", phone);
        } else {
            LOGGER.error("Attribute for phoneName {} wasn't added", phoneName);
        }
        req.getRequestDispatcher("WEB-INF/phonePage.jsp").forward(req, resp);
    }
}

