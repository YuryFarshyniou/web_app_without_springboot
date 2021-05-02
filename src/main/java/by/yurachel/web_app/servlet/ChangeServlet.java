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

@WebServlet(urlPatterns = "/change")
public class ChangeServlet extends HttpServlet {
    private PhoneRepository pr = PhoneRepository.getInstance();
    private static final Logger ROOT_LOGGER = LogManager.getRootLogger();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/change.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String oldPhoneName = req.getParameter("oldName");
        int oldPhoneId = pr.findPhoneIDByName(oldPhoneName);
        Phone newPhone = new Phone(oldPhoneId, req.getParameter("name"), Double.parseDouble(req.getParameter("price")), req.getParameter("processor"));
        ROOT_LOGGER.info("Old phone {} was changed by new phone {}", oldPhoneName, newPhone);
        pr.changePhoneParam(newPhone, oldPhoneName);
        resp.sendRedirect("catalog");
    }
}
