package me.lab6.server.Command;

import me.lab6.common.Data.LabWork;
import me.lab6.common.Response;

public interface CommandWithLabWork {
    String getDescription();
    String getName();
    Response execute(LabWork labWork);
}
