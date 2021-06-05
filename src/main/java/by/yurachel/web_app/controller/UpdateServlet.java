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

@WebServlet(urlPatterns = "/change")
public class UpdateServlet extends HttpServlet {

    private IDao<Phone> daoProvider = DAOProviderCommon.getInstance().getIPhoneDAO();
    private static final Logger LOGGER = LogManager.getLogger(UpdateServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String oldPhoneName = req.getParameter("oldName");
        try {

            Phone newPhone = new Phone(req.getParameter("name"),
                    Double.parseDouble(req.getParameter("price")),
                    req.getParameter("processor"),
                    req.getParameter("img"));
            boolean isSuccess = daoProvider.update(oldPhoneName, newPhone);
            if (isSuccess) {
                LOGGER.info("Old phone {} was changed by new phone {}", oldPhoneName, newPhone);
            } else {
                LOGGER.info("Change entity operation was failed.");
            }
            resp.sendRedirect("catalog");
        } catch (NullPointerException e) {
            LOGGER.error("Phone with name: {} wasn't found. {} {}", oldPhoneName
                    , e.getMessage(), e);
        }
    }
}
