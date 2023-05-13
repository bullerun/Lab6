package me.lab6.server.Command;

import me.lab6.common.Data.LabWork;
import me.lab6.common.Exception.MustBeEmptyException;
import me.lab6.common.Response;
import me.lab6.server.Manager.CollectionManager;

/**
 * class sum of minimal point command
 *
 * @author Nikita and Vlad
 * @version 0.1
 */
public class SumOfMinimalPointCommand extends AbstractCommand {
    CollectionManager collectionManager;

    public SumOfMinimalPointCommand(CollectionManager collectionManager) {
        super("sum_of_minimal_point", "выводит сумму значений поля minimalPoint для всех элементов коллекции");
        this.collectionManager = collectionManager;
    }

    @Override
    public Response execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new MustBeEmptyException();
            long SumOfMinimalPoints = 0;
            for (LabWork i : collectionManager.getLabWork()) {
                SumOfMinimalPoints += i.getMinimalPoint();
            }
            return new Response("сумму значений поля minimalPoint для всех элементов коллекции = " + SumOfMinimalPoints);
            
        } catch (MustBeEmptyException e) {
            return new Response("Команда вводится без аргумента");
            
        }
    }
}