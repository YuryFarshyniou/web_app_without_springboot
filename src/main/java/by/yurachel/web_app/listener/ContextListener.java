package by.yurachel.web_app.listener;

import by.yurachel.web_app.dao.DAOProviderCommon;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/* Обрабатывает события создания/удаления контекста сервлета.
 * Событие инициализации контекста сервлета производится только один раз за его жизненный цикл.*/

@WebListener
public class ContextListener implements ServletContextListener {
    public static final Logger LOGGER = LogManager.getLogger(ContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String db = sce.getServletContext().getInitParameter("db_approach");
        DAOProviderCommon.init(db);
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("Without errors");
//        } catch (ClassNotFoundException e) {
//            LOGGER.error("Exception was caught {} {}", e.getMessage(), e);
//        }
        LOGGER.info("Initialized {} ", sce.getServletContext().getContextPath());

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        LOGGER.info("Destroyed {}", sce.getServletContext().getContextPath());
    }
}
