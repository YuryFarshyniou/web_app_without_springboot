package by.yurachel.web_app.servlet;

import by.yurachel.web_app.dao.AbstractDAO;
import by.yurachel.web_app.dao.DAOProvider;
import by.yurachel.web_app.entity.Phone;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

@WebServlet(urlPatterns = "/remove")
public class RemoveServlet extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(RemoveServlet.class);
    private DAOProvider phoneProvider = DAOProvider.getInstance();
    private AbstractDAO<Phone> phoneListDAO = phoneProvider.getAbstractDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            long phoneIdToRemove = Long.parseLong(req.getParameter("id"));
            boolean isSuccess = phoneListDAO.remove(phoneIdToRemove);
            if (isSuccess) {
                LOGGER.info("Phone with id {} was successfully removed", phoneIdToRemove);
            } else {
                LOGGER.info("Remove phone operation was failed.");
            }

        } catch (IllegalArgumentException e) {
            LOGGER.error("Exception occurred: {} {}", e.getMessage(), e);
        }
        resp.sendRedirect("catalog");
    }
}
