package ru.andrey.kvstorage.commandResult;

import ru.andrey.kvstorage.console.DatabaseCommandResult;

import java.util.Objects;
import java.util.Optional;

public class ResultDatabaseTable implements DatabaseCommandResult{
    private final String errorMessage;

    private ResultDatabaseTable() {
        this.errorMessage = null;
    }

    private ResultDatabaseTable(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public static ResultDatabaseTable createSuccessResult() {
        return new ResultDatabaseTable();
    }

    public static ResultDatabaseTable createFailedResult(String errorMessage) {
        return new ResultDatabaseTable(errorMessage);
    }

    public Optional<String> getResult() {
        return null;
    }

    public DatabaseCommandResult.DatabaseCommandStatus getStatus() {
        return isSuccess() ? DatabaseCommandResult.DatabaseCommandStatus.SUCCESS : DatabaseCommandResult.DatabaseCommandStatus.FAILED;
    }

    public boolean isSuccess() {
        return Objects.isNull(errorMessage);
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}