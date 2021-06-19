package by.yurachel.web_app.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "aut", urlPatterns = {"/admin", "/addPhone", "/remove", "/change"})
public class AuthenticationFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();
        if (session == null) {
            res.sendError(401);
            return;
        }
        String userName = (String) session.getAttribute("username");
        if (userName == null || !userName.equalsIgnoreCase(getServletContext().getInitParameter("username"))) {
            req.getRequestDispatcher("WEB-INF/login.jsp").forward(req, res);
            return;
        }
        chain.doFilter(req, res);

    }
}
