package by.yurachel.web_app.controller;

import by.yurachel.web_app.dao.DaoProvider;
import by.yurachel.web_app.dao.IDao;
import by.yurachel.web_app.entity.Phone;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

@WebServlet(urlPatterns = "/change")
public class UpdateServlet extends HttpServlet {

    private IDao<Phone> dao = DaoProvider.getInstance().getIPhoneDAO();
    private static final Logger LOGGER = LogManager.getLogger(UpdateServlet.class);
    private long phoneId;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/update.jsp").forward(req, resp);
        phoneId = Long.parseLong(req.getParameter("id"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            Phone newPhone = new Phone(req.getParameter("name"),
                    Double.parseDouble(req.getParameter("price")),
                    req.getParameter("processor"),
                    req.getParameter("img"));
            boolean isSuccess = dao.updateById(phoneId, newPhone);
            if (isSuccess) {
                LOGGER.info("Old phone with id {} was changed by new phone {}", phoneId, newPhone);
                resp.sendRedirect("catalog");
            } else {
                LOGGER.info("Update entity operation was failed.");
                req.setAttribute("error", "Update entity operation was failed.");
                getServletContext().getRequestDispatcher("/WEB-INF/update.jsp").forward(req, resp);
            }

        } catch (NullPointerException | ServletException e) {
            LOGGER.error("Phone with id: {} wasn't found. {} {}", phoneId
                    , e.getMessage(), e);
        }
    }
}
