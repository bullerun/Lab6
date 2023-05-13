package me.lab6.server.Command;

import me.lab6.common.Data.LabWork;
import me.lab6.common.Response;
import me.lab6.server.Manager.CollectionManager;

public class AddCommandWithPerson extends AbstractCommandWithLabWork {
    private CollectionManager collectionManager;


    public AddCommandWithPerson(CollectionManager collectionManager) {
        super("add", "добавляет новый элемент в коллекцию");
        this.collectionManager = collectionManager;
    }

    @Override
    public Response execute(LabWork labWork) {
        collectionManager.addToCollection(labWork);
        return new Response("Лабораторная успешно добавлена");
    }
}
