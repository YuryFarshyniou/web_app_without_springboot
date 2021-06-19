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
import java.util.List;

@WebServlet(name = "catalog", urlPatterns = "/catalog")
public class CatalogServlet extends HttpServlet {

    private IDao<Phone> dao = DaoProvider.getInstance().getIPhoneDAO();

    private static final Logger LOGGER = LogManager.getLogger(CatalogServlet.class);


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Phone> phones = dao.findAll();
        if (!phones.isEmpty()) {
            request.setAttribute("phones", phones);
        }
        LOGGER.info("Phone count: {} ", phones.size());
        LOGGER.info("Products retrieved successfully");
        request.getRequestDispatcher("WEB-INF/catalog.jsp").forward(request, response);

    }

}
