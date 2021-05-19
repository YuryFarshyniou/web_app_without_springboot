package by.yurachel.web_app.command.impl;

import by.yurachel.web_app.command.ActionCommand;
import by.yurachel.web_app.dao.AbstractDAO;
import by.yurachel.web_app.dao.DAOProvider;
import by.yurachel.web_app.entity.Phone;
import by.yurachel.web_app.manager.ConfigurationManager;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PhonePageCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(PhonePageCommand.class);
    private static final String NAME = "name";
    private DAOProvider phoneProvider = DAOProvider.getInstance();
    private AbstractDAO<Phone> phoneListDAO = phoneProvider.getAbstractDAO();

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        try {
            Phone phone = phoneListDAO.findEntity(request.getParameter(NAME));
            if (!(phone == null)) {
                request.setAttribute("phone", phone);
                LOGGER.info("Attribute {} was successfully added", phone);
            }
            page = ConfigurationManager.getProperty("path.page.phonePage");

        } catch (Exception e) {
            LOGGER.error(e);
        }
        return page;
    }
}
