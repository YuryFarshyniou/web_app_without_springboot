package by.yurachel.web_app.command;

import by.yurachel.web_app.command.impl.PhonePageCommand;

public enum CommandEnum {
    MORE_INFO(new PhonePageCommand());

    private ActionCommand command;

    CommandEnum(ActionCommand command) {
        this.command = command;
    }


    public ActionCommand getCommand() {
        return command;
    }
}
