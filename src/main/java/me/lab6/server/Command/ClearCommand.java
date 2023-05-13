package me.lab6.server.Command;

import me.lab6.common.Exception.MustBeEmptyException;
import me.lab6.common.Exception.MustBeNotEmptyException;
import me.lab6.common.Response;
import me.lab6.server.Manager.CollectionManager;

/**
 * collection cleanup command
 *
 * @author Nikita and Vlad
 * @version 0.1
 */
public class ClearCommand extends AbstractCommand{
    CollectionManager collectionManager;
    public ClearCommand(CollectionManager collectionManager){
        super("clear", "очищает коллекцию");
        this.collectionManager = collectionManager;
    }
    @Override
    public Response execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new MustBeEmptyException();
            if (collectionManager.getLabWork().isEmpty()) throw new MustBeNotEmptyException();
            collectionManager.clearCollection();

        } catch (MustBeEmptyException e) {
            return new Response("Команда вводится без аргумента");

        }catch (MustBeNotEmptyException e){
            return new Response("Коллекция и так пуста");
        }
        return new Response("Коллекция очищена");
    }
}
