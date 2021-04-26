package by.yurachel.web_app.servlet;

import by.yurachel.web_app.repository.PhoneRepository;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "catalog", urlPatterns = "/catalog")
public class CatalogServlet extends HttpServlet {

    private final PhoneRepository pr = PhoneRepository.getInstance();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("phones", pr.getPhones());
        request.getRequestDispatcher("WEB-INF/catalog.jsp").forward(request, response);
        ServletContext sc = getServletContext();
        sc.setAttribute("phones", pr.getPhones());
    }
}
