package by.yurachel.web_app.servlet;

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

@WebServlet(urlPatterns = "/addPhone")
public class AddPhoneServlet extends HttpServlet {

    private DAOProvider phoneProvider = DAOProvider.getInstance();
    private AbstractDAO<Phone> phoneListDAO = phoneProvider.getAbstractDAO();
    public static final Logger LOGGER = LogManager.getLogger(AddPhoneServlet.class);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/new-phone.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {


        String name = req.getParameter("name");
        if (name == null) {
            throw new IllegalArgumentException("Name of the phone can't be null.");
        }
        double price = Double.parseDouble(req.getParameter("price"));
        String processor = req.getParameter("processor");
        Phone pe = new Phone(name, price, processor);
        boolean isSuccess = phoneListDAO.addEntity(pe);
        if (isSuccess) {
            LOGGER.info("New phone {} was added", pe);
        } else {
            LOGGER.info("Phone {} wasn't added", pe);
        }
        resp.sendRedirect("catalog");
    }
}
