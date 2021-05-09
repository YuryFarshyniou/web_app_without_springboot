package by.yurachel.web_app.servlet;

import by.yurachel.web_app.entity.Phone;
import by.yurachel.web_app.repository.PhoneRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

@WebServlet(urlPatterns = "/remove")
public class RemoveServlet extends HttpServlet {
    private static final Logger ROOT_LOGGER = LogManager.getRootLogger();
    private PhoneRepository pr = PhoneRepository.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            long phoneIdToRemove = Long.parseLong(req.getParameter("id"));
            boolean wasRemovedId = pr.removeId(phoneIdToRemove);
            if (!wasRemovedId) {
                throw new IllegalArgumentException("Phone with this id wasn't found.");
            }
            ROOT_LOGGER.info("Phone {} was removed", pr.findPhoneById(phoneIdToRemove));
            pr.removePhone(phoneIdToRemove);

        } catch (IllegalArgumentException e) {
            ROOT_LOGGER.error("Exception occurred: {} {}", e.getMessage(), e);
        }
        resp.sendRedirect("catalog");
    }
}
