package by.yurachel.web_app.controller;

import by.yurachel.web_app.dao.AbstractDAO;
import by.yurachel.web_app.dao.DAOProvider;
import by.yurachel.web_app.entity.Phone;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

@WebServlet( name = "phonePage", urlPatterns = "/phonePage")
public class PhonePageServlet extends HttpServlet {
    private DAOProvider phoneProvider = DAOProvider.getInstance();
    private static final Logger LOGGER = LogManager.getLogger(CatalogServlet.class);
    private AbstractDAO<Phone> phoneListDAO = phoneProvider.getAbstractDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Phone phone = phoneListDAO.findEntity(req.getParameter("name"));

        if (!(phone == null)) {
            req.setAttribute("phone", phone);
            LOGGER.info("Attribute {} was successfully added", phone);
        }
        req.getRequestDispatcher("WEB-INF/phonePage.jsp").forward(req, resp);

    }
}

