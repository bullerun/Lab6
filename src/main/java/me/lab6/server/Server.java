package me.lab6.server;


import me.lab6.server.Manager.CollectionManager;
import me.lab6.server.Manager.CommandManager;
import me.lab6.server.Utility.FileHanding;
//import me.lab6.server.Utility.LabAsk;
import me.lab6.common.utilities.RunMode;
import me.lab6.server.Utility.LabAsk;

import java.io.*;
import java.net.InetAddress;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Logger;


public class Server {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String envVariable = System.getenv("LAB");
        CollectionManager collectionManager = new CollectionManager();
        RunMode runMode = new RunMode();
        FileHanding fileHanding = new FileHanding(collectionManager, envVariable, runMode);
        CommandManager commandManager = new CommandManager(collectionManager, fileHanding, new LabAsk(scanner));
        fileHanding.setCommandManager(commandManager);
        fileHanding.xmlFileReader();
        ServerInstance serverInstance = new ServerInstance(10643, commandManager, scanner);
        Runtime.getRuntime().addShutdownHook(new Thread(commandManager::save));
        serverInstance.start();
    }
}