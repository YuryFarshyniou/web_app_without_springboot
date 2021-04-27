package by.yurachel.web_app.servlet;

import by.yurachel.web_app.entity.Phone;
import by.yurachel.web_app.repository.PhoneRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/remove")
public class RemoveServlet extends HttpServlet {
    private final PhoneRepository pr = PhoneRepository.getInstance();
    private final Phone phone = new Phone();



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        phone.setName(req.getParameter("name"));
        phone.setPrice(Double.parseDouble(req.getParameter("price")));
        phone.setProcessor(req.getParameter("processor"));
        System.out.println(phone);
        pr.removePhone(phone);
        resp.sendRedirect("catalog");
    }
}
