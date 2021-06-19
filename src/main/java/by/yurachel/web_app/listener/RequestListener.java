package by.yurachel.web_app.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/* Обрабатывает события создания/удаления запроса.
 * */
@WebListener
public class RequestListener implements ServletRequestListener {
    private static final Logger LOGGER = LogManager.getLogger(RequestListener.class);

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        LOGGER.info("Request initialized {} ", sre.getServletRequest().getRemoteHost());
    }

}
