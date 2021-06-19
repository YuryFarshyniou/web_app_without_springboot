package by.yurachel.web_app.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

@WebServlet(name = "login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private String userName;
    private String password;
    private static final Logger LOGGER = LogManager.getLogger(LoginServlet.class);

    @Override
    public void init() {
        userName = getServletContext().getInitParameter("username");
        password = getServletContext().getInitParameter("password");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String pass = req.getParameter("pass");
        if (login == null || pass == null) {
            resp.sendError(401);
            LOGGER.error("{} login or pass equals null. ", req.getSession().getId());
            return;
        }
        if (!login.equals(userName) || !pass.equals(password)) {
            resp.sendError(401);
            LOGGER.error("{} session can't login. ", req.getSession().getId());
            return;
        }
        HttpSession hs = req.getSession(true);
        hs.setAttribute("username", login);
        resp.sendRedirect("home");
    }
}
