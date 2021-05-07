package by.yurachel.web_app.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebListener
public class ContextListener implements ServletContextListener {
    public static final Logger ROOT_LOGGER = LogManager.getRootLogger();

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ROOT_LOGGER.info("Initialized {} ", sce.getServletContext().getContextPath());
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            ROOT_LOGGER.error("Exception was caught {} {}", e.getMessage(), e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ROOT_LOGGER.info("Destroyed {}", sce.getServletContext().getContextPath());
    }
}
