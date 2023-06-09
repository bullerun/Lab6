package me.lab6.server.Command;

import me.lab6.common.Data.LabWork;
import me.lab6.common.Exception.MustBeEmptyException;
import me.lab6.common.Exception.MustBeNotEmptyException;
import me.lab6.common.Response;
import me.lab6.server.Manager.CollectionManager;

import java.util.NavigableSet;
/**
 * command to output the values of the discipline field of all laboratory works in descending order
 *
 * @author Nikita and Vlad
 * @version 0.1
 */
public class PrintFieldDescendingDisciplineCommand extends AbstractCommand {
    CollectionManager collectionManager;

    public PrintFieldDescendingDisciplineCommand(CollectionManager collectionManager) {
        super("print_field_descending_discipline", "выводит значения поля discipline всех элементов в порядке убывания");
        this.collectionManager = collectionManager;
    }

    @Override
    public Response execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new MustBeEmptyException();
            NavigableSet<LabWork> labWork = collectionManager.getLabWork().descendingSet();
            if (labWork.isEmpty()) throw new MustBeNotEmptyException();
            for (LabWork i : labWork) {
                if (i.getDiscipline() == null) {
                    return new Response("У " + i.getId() + " " + i.getName() + " не указана дисциплина");
                } else {
                    return new Response("У " + i.getId() + " " + i.getName() + " дисциплина " + i.getDiscipline());
                }
            }
            
        } catch (MustBeEmptyException e) {
            return new Response("Команда вводится без аргумента");

        } catch (MustBeNotEmptyException e) {
            return new Response("Коллекция пуста");
            
        }
        return null;
    }
}