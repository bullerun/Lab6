package me.lab6.server.Command;

import me.lab6.common.Data.LabWork;
import me.lab6.common.Response;

/**
 * interface from which all commands are implemented
 *
 * @author Nikita and Vlad
 * @version 0.1
 */
public interface Command {
    String getDescription();
    String getName();
    Response execute(String argument);
}
