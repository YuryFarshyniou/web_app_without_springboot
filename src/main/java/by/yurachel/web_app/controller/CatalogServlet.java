package by.yurachel.web_app.controller;

import by.yurachel.web_app.dao.IDao;
import by.yurachel.web_app.dao.hibernate.DAOProvider;
import by.yurachel.web_app.dao.hibernate.SessionFactoryCreator;
import by.yurachel.web_app.dao.hibernate.impl.HibPhoneListDao;
import by.yurachel.web_app.entity.Phone;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "catalog", urlPatterns = "/catalog")
public class CatalogServlet extends HttpServlet {

    //    private DAOProvider phoneProvider = DAOProvider.getInstance();
//    private IDao<Phone> phoneListDAO = phoneProvider.getAbstractDAO();
    private static final Logger LOGGER = LogManager.getLogger(CatalogServlet.class);
    private DAOProvider phoneProvider = DAOProvider.getInstance();
    private IDao<Phone> phoneListHib = phoneProvider.getIPhoneDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Phone> phones = phoneListHib.findAll();
        if (!phones.isEmpty()) {
            request.setAttribute("phones", phones);
        }
        LOGGER.info("Phone count: {} ", phones.size());
        LOGGER.info("Products retrieved successfully");
        request.getRequestDispatcher("WEB-INF/catalog.jsp").forward(request, response);

    }

}
