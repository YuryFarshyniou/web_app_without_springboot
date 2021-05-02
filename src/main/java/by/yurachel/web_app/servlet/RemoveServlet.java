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
    private final PhoneRepository pr = PhoneRepository.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            int phoneIdToRemove = Integer.parseInt(req.getParameter("id"));
            PhoneRepository.removeId(phoneIdToRemove);
            ROOT_LOGGER.info("Phone {} was removed",  pr.findPhoneById(phoneIdToRemove));
            pr.removePhone(phoneIdToRemove);

        } catch (Exception e) {
            ROOT_LOGGER.debug("Exception occurred {} {}", e.getMessage(), e);
        }
        resp.sendRedirect("catalog");
    }
}
