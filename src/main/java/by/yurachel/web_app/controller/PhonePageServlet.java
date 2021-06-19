package by.yurachel.web_app.controller;

import by.yurachel.web_app.dao.DaoProvider;
import by.yurachel.web_app.dao.IDao;
import by.yurachel.web_app.entity.Phone;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

@WebServlet(name = "phonePage", urlPatterns = "/phonePage")
public class PhonePageServlet extends HttpServlet {
    private IDao<Phone> dao = DaoProvider.getInstance().getIPhoneDAO();

    private static final Logger LOGGER = LogManager.getLogger(CatalogServlet.class);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phoneName = req.getParameter("name");
        Phone phone = dao.findByName(phoneName);

        if (phone != null) {
            req.setAttribute("phone", phone);
            LOGGER.info("Attribute {} was successfully added", phone);
        } else {
            LOGGER.error("Attribute for phoneName: {} wasn't added", phoneName);
        }
        req.getRequestDispatcher("WEB-INF/phonePage.jsp").forward(req, resp);
    }
}

