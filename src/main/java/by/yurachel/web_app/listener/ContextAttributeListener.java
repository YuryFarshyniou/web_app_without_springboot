package by.yurachel.web_app.listener;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.annotation.WebListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@WebListener
public class ContextAttributeListener implements ServletContextAttributeListener {

    private static final Logger LOGGER = LogManager.getLogger(ContextAttributeListener.class);

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        LOGGER.info("Attribute added: {}: {}", event.getName(), event.getValue());

    }
}
