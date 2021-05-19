package by.yurachel.web_app.command;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;

public class ActionFactory {
    private static final Logger LOGGER = LogManager.getLogger(ActionFactory.class);

    public ActionCommand defineCommand(HttpServletRequest request) {
        ActionCommand command = null;
        String action = request.getParameter("command");
        try {
            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase(Locale.ROOT));
            command = currentEnum.getCommand();
        } catch (IllegalArgumentException e) {
            LOGGER.error(e);
        }
        return command;
    }
}
