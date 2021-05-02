package by.yurachel.web_app.listener;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebListener
public class RequestListener implements ServletRequestListener {
    private static final Logger ROOT_LOGGER = LogManager.getRootLogger();

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        ROOT_LOGGER.info("Request initialized {} ", sre.getServletRequest().getRemoteHost());
    }

}
