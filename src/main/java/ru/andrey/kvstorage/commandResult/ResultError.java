package ru.andrey.kvstorage.commandResult;

import ru.andrey.kvstorage.console.DatabaseCommandResult;

import java.util.Optional;

public class ResultError implements DatabaseCommandResult {

    public static final DatabaseCommandResult INSTANCE = new ResultError();

    private static final String ERROR_UNSUPPORTED_COMMAND = "Unsupported command";

    private ResultError() {

    }

    public Optional<String> getResult() {
        return null;
    }

    public DatabaseCommandStatus getStatus() {
        return DatabaseCommandStatus.FAILED;
    }

    public boolean isSuccess() {
        return false;
    }

    public String getErrorMessage() {
        return ERROR_UNSUPPORTED_COMMAND;
    }

}