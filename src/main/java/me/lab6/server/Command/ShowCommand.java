package me.lab6.server.Command;

import me.lab6.common.Data.LabWork;
import me.lab6.common.Exception.MustBeEmptyException;
import me.lab6.common.Response;
import me.lab6.server.Manager.CollectionManager;

import java.util.stream.Collectors;

/**
 * command class lab output command
 *
 * @author Nikita and Vlad
 * @version 0.1
 */
public class ShowCommand extends AbstractCommand{
    CollectionManager collectionManager;

    public ShowCommand(CollectionManager collectionManager){
        super("show", "выводит в стандартный поток вывода все элементы коллекции в строковом представлении");
        this.collectionManager =collectionManager;
    }
    @Override
    public Response execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new MustBeEmptyException();
            if (collectionManager.getLabWork().size() == 0) {
                return new Response("Коллекция пуста");
            }

            return new Response(collectionManager.getLabWork().stream().map(Object::toString).collect(Collectors.joining("\n")));
            
        }catch (MustBeEmptyException e) {
            return new Response("Команда вводится без аргумента");
        }
    }
}
