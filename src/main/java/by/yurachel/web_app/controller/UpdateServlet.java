package by.yurachel.web_app.controller;

import by.yurachel.web_app.dao.DaoProvider;
import by.yurachel.web_app.dao.IDao;
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

    private IDao<Phone> dao = DaoProvider.getInstance().getIPhoneDAO();
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
                    req.getParameter("processor"),
                    req.getParameter("img"));
            boolean isSuccess = dao.updateByName(oldPhoneName, newPhone);
            if (isSuccess) {
                LOGGER.info("Old phone {} was changed by new phone {}", oldPhoneName, newPhone);
                resp.sendRedirect("catalog");
            } else {
                LOGGER.info("Change entity operation was failed.");
                String error = "Change entity operation was failed.";
                req.setAttribute("error", error);
                getServletContext().getRequestDispatcher("/WEB-INF/update.jsp").forward(req, resp);
            }

        } catch (NullPointerException | ServletException e) {
            LOGGER.error("Phone with name: {} wasn't found. {} {}", oldPhoneName
                    , e.getMessage(), e);
        }
    }
}
