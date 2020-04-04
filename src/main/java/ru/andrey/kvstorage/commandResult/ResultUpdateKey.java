package ru.andrey.kvstorage.commandResult;

import ru.andrey.kvstorage.console.DatabaseCommandResult;

import java.util.Objects;
import java.util.Optional;

public class ResultUpdateKey implements DatabaseCommandResult {
    private final String errorMessage;

    private ResultUpdateKey(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public static ResultUpdateKey CreateSuccessResult() {
        return new ResultUpdateKey(null);
    }

    public static ResultUpdateKey CreateFailedResult(String errorMessage) {
        return new ResultUpdateKey(errorMessage);
    }


    public Optional<String> getResult() {
        return null;
    }

    public DatabaseCommandResult.DatabaseCommandStatus getStatus() {
        return Objects.isNull(errorMessage) ? DatabaseCommandResult.DatabaseCommandStatus.SUCCESS : DatabaseCommandResult.DatabaseCommandStatus.FAILED;
    }

    public boolean isSuccess() {
        return Objects.isNull(errorMessage);
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}