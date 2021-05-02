package by.yurachel.web_app.listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebListener
public class SessionListener implements HttpSessionListener {
    private static final Logger ROOT_LOGGER = LogManager.getRootLogger();

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ROOT_LOGGER.info("Session initialized, ID:{}", se.getSession().getId());
    }
}
