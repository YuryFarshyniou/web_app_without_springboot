package by.yurachel.web_app.servlet;

import by.yurachel.web_app.entity.Phone;
import by.yurachel.web_app.repository.PhoneRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/change")
public class ChangeServlet extends HttpServlet {
    private PhoneRepository pr = PhoneRepository.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/change.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Phone newPhone = new Phone(req.getParameter("name"), Double.parseDouble(req.getParameter("price")), req.getParameter("processor"));
        String oldPhoneName = req.getParameter("oldName");
        pr.changePhoneParam(newPhone, oldPhoneName);
        resp.sendRedirect("catalog");
    }
}
