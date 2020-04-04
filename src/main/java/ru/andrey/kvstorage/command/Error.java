package ru.andrey.kvstorage.command;

import ru.andrey.kvstorage.commandResult.ResultError;
import ru.andrey.kvstorage.console.DatabaseCommand;
import ru.andrey.kvstorage.console.DatabaseCommandResult;

public class Error implements DatabaseCommand {


    public static final Error INSTANCE = new Error();

    public DatabaseCommandResult execute() {
        return ResultError.INSTANCE;
    }
}