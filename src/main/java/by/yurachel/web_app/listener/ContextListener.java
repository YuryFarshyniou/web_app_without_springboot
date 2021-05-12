package by.yurachel.web_app.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebListener
public class ContextListener implements ServletContextListener {
    public static final Logger LOGGER = LogManager.getLogger(ContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            LOGGER.error("Exception was caught {} {}", e.getMessage(), e);
        }
        LOGGER.info("Initialized {} ", sce.getServletContext().getContextPath());

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        LOGGER.info("Destroyed {}", sce.getServletContext().getContextPath());
    }
}
