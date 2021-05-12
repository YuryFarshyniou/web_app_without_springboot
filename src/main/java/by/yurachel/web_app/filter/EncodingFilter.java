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
import java.nio.charset.StandardCharsets;

@WebFilter(filterName = "encoding", urlPatterns = "/*")
public class EncodingFilter extends HttpFilter {
    private static final Logger LOGGER = LogManager.getLogger(EncodingFilter.class);

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        LOGGER.info("Set encoding");
        req.setCharacterEncoding(StandardCharsets.UTF_8.name());
        chain.doFilter(req, res);
    }
}
