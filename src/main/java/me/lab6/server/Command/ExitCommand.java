package me.lab6.server.Command;

import me.lab6.common.Exception.MustBeEmptyException;
import me.lab6.common.Response;

/**
 * commands the shutdown
 *
 * @author Nikita and Vlad
 * @version 0.1
 */
public class ExitCommand extends AbstractCommand {
    public ExitCommand() {
        super("exit", "завершает программу (без сохранения в файл)");
    }

    @Override
    public Response execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new MustBeEmptyException();
            System.exit(0);

        } catch (MustBeEmptyException e) {
            System.out.println("Команда вводится без аргумента");
        }
        return null;
    }
}
