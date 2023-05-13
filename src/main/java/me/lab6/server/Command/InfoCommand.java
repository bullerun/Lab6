package me.lab6.server.Command;

import me.lab6.common.Exception.MustBeEmptyException;
import me.lab6.common.Response;
import me.lab6.server.Manager.CollectionManager;

/**
 * command outputs information about the collection
 *
 * @author Nikita and Vlad
 * @version 0.1
 */
public class InfoCommand extends AbstractCommand {
    private CollectionManager collectionManager;

    public InfoCommand(CollectionManager collectionManager) {
        super("info", "выводит в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
        this.collectionManager = collectionManager;
    }

    @Override
    public Response execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new MustBeEmptyException();
            return new Response("Тип " + collectionManager.getLabWork().getClass() + "\n"
                    + "Количество элементов: " + collectionManager.getLabWork().size() + "\n"
                    + "Дата инициализации: " + collectionManager.getCreatingCollection());
        } catch (MustBeEmptyException e) {
            return new Response("Команда вводится без аргумента");

        }
    }
}
