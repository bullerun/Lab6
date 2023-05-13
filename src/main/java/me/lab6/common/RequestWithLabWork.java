package me.lab6.common;

import me.lab6.common.Data.LabWork;

import java.io.Serializable;

public class RequestWithLabWork implements Serializable {
    private String command;
    private LabWork labWork;

    public RequestWithLabWork(String command, LabWork labWork) {
        this.command = command;
        this.labWork = labWork;
    }

    public String getCommands() {
        return command;
    }

    public LabWork getLabWork() {
        return labWork;
    }
}