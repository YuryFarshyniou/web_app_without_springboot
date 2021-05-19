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

@WebServlet(urlPatterns = "/change")
public class UpdateServlet extends HttpServlet {

    private DAOProvider phoneProvider = DAOProvider.getInstance();
    private AbstractDAO<Phone> phoneListDAO = phoneProvider.getAbstractDAO();
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
                    req.getParameter("processor"));
            boolean isSuccess = phoneListDAO.update(oldPhoneName, newPhone);
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
