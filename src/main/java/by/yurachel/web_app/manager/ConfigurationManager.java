package by.yurachel.web_app.manager;

import java.util.ResourceBundle;

public class ConfigurationManager {
    private final static ResourceBundle rb =
            ResourceBundle.getBundle("pages");

    private ConfigurationManager() {

    }

    public static String getProperty(String command) {
        return rb.getString(command);
    }
}
