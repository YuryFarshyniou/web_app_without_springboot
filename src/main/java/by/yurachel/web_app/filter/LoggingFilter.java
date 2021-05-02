package by.yurachel.web_app.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

@WebFilter(filterName = "logging", urlPatterns = "/*")
public class LoggingFilter extends HttpFilter {
    private static final Logger ROOT_LOGGER = LogManager.getRootLogger();

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        ROOT_LOGGER.info("Entered filter, request: {} ", req.getRemoteHost());
        chain.doFilter(req, res);
    }
}
