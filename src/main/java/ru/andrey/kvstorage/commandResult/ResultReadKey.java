package ru.andrey.kvstorage.commandResult;

import ru.andrey.kvstorage.console.DatabaseCommandResult;

import java.util.Objects;
import java.util.Optional;

public class ResultReadKey implements DatabaseCommandResult{
    private final String errorMessage;

    private String keyValue;

    private ResultReadKey() {
        this.errorMessage = null;
    }

    private ResultReadKey(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public static ResultReadKey CreateSuccessResult(String keyValue) {
        ResultReadKey result = new ResultReadKey();
        result.keyValue = keyValue;
        return new ResultReadKey();
    }

    public static ResultReadKey CreateFailedResult(String errorMessage) {
        return new ResultReadKey(errorMessage);
    }

    public Optional<String> getResult() {
        return Optional.of(keyValue);
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
