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

@WebServlet(urlPatterns = "/addPhone")
public class AddPhoneServlet extends HttpServlet {
    private PhoneRepository pr = PhoneRepository.getInstance();
    public static final Logger LOGGER = LogManager.getRootLogger();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/new-phone.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        PhoneRepository.ID.add(PhoneRepository.maxPhoneID() + 1);
        int id = PhoneRepository.maxPhoneID();
        Phone pe = new Phone(id, req.getParameter("name"), Double.parseDouble(req.getParameter("price")), req.getParameter("processor"));

        LOGGER.info("New phone {} was added", pe);
        resp.sendRedirect("catalog");
    }
}
