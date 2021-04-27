package by.yurachel.web_app.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
//            res.sendError(401);
            req.getRequestDispatcher("WEB-INF/login.jsp").forward(req,res);
            return;
        }
        chain.doFilter(req, res);

    }
}
