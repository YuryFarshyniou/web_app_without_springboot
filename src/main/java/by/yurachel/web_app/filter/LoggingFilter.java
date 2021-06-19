package by.yurachel.web_app.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

@WebFilter(filterName = "logging", urlPatterns = "/*")
public class LoggingFilter extends HttpFilter {
    private static final Logger LOGGER = LogManager.getLogger(LoggingFilter.class);

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        LOGGER.info("Entered filter, request: {} ", req.getRemoteHost());
        chain.doFilter(req, res);
    }
}
