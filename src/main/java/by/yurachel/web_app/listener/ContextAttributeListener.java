package by.yurachel.web_app.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/* Обрабатывает события создания/удаления/модификации атрибутов контекста сервлета. */

@WebListener
public class ContextAttributeListener implements ServletContextAttributeListener {

    private static final Logger LOGGER = LogManager.getLogger(ContextAttributeListener.class);

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        LOGGER.info("Attribute added: {}: {}", event.getName(), event.getValue());

    }
}
