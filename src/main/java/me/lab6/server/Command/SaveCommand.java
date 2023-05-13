package me.lab6.server.Command;

import me.lab6.common.Exception.MustBeEmptyException;
import me.lab6.common.Response;
import me.lab6.server.Manager.CollectionManager;
import me.lab6.server.Utility.FileHanding;

/**
 * command of saving laboratory work to a file
 *
 * @author Nikita and Vlad
 * @version 0.1
 */
public class SaveCommand extends AbstractCommand {
    private FileHanding fileHanding;
    private CollectionManager collectionManager;

    public SaveCommand(FileHanding fileHanding, CollectionManager collectionManager) {
        super("save", "сохраняет коллекцию в файл");
        this.fileHanding = fileHanding;
        this.collectionManager = collectionManager;
    }

    @Override
    public Response execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new MustBeEmptyException();
            fileHanding.xmlFileWrite(collectionManager);
            System.out.println("Коллекция сохранена");
            
        } catch (MustBeEmptyException e) {
            System.out.println("Команда вводится без аргумента");
            
        }
        return null;
    }
}