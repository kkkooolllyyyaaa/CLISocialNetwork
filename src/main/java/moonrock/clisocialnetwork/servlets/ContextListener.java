package moonrock.clisocialnetwork.servlets;

import moonrock.clisocialnetwork.commandLogic.command_storage.CommandStorage;
import moonrock.clisocialnetwork.commandLogic.command_storage.CommandStorageImpl;
import moonrock.clisocialnetwork.commandLogic.commands.WriteCommand;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
public class ContextListener implements ServletContextListener {
    private final CommandStorage commandStorage = new CommandStorageImpl();

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        final ServletContext servletContext =
                sce.getServletContext();
        initCommands();
        servletContext.setAttribute("commands", commandStorage);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
    }

    private void initCommands() {
//        commandStorage.addCommand(new WriteCommand("write", "writes to user"));
    }
}
