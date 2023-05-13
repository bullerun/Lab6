package me.lab6.server.Command;

import me.lab6.common.Data.LabWork;
import me.lab6.common.Exception.MustBeNotEmptyException;
import me.lab6.common.Response;
import me.lab6.server.Manager.CollectionManager;

/**
 * command that deletes all laboratory works is greater than the entered
 *
 * @author Nikita and Vlad
 * @version 0.1
 */
public class RemoveGreaterCommand extends AbstractCommand {
    CollectionManager collectionManager;

    public RemoveGreaterCommand(CollectionManager collectionManager) {
        super("remove_greater {element}", "удаляет из коллекции все элементы, превышающие заданный");
        this.collectionManager = collectionManager;
    }

    @Override
    public Response execute(String argument) {
        try {
            if (argument.isEmpty()) throw new MustBeNotEmptyException();
            long removeLabWorksId = Long.parseLong(argument.trim());
            LabWork removeLabWorks = collectionManager.getElementById(removeLabWorksId);
            if (removeLabWorks == null) throw new NullPointerException();
            collectionManager.removeGreater(removeLabWorks);
                return new Response("Удаления завершены успешно");
            
        } catch (MustBeNotEmptyException e) {
            return new Response("Id не введен");
            
        } catch (NullPointerException e) {
            return new Response("Лабораторной работы с таким Id отсутствует");
            
        } catch (NumberFormatException e) {
            return new Response("Некорректный ввод");
            
        }
    }
}