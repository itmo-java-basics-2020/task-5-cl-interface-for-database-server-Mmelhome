package ru.andrey.kvstorage.command;

import ru.andrey.kvstorage.commandResult.ResultMessages;
import ru.andrey.kvstorage.commandResult.ResultUpdateKey;
import ru.andrey.kvstorage.console.DatabaseCommand;
import ru.andrey.kvstorage.console.DatabaseCommandResult;
import ru.andrey.kvstorage.console.ExecutionEnvironment;
import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.logic.Database;

import java.util.Optional;

public class UpdateKey implements DatabaseCommand {
    private final String databaseName;

    private final String tableName;

    private final String keyName;

    private final String valueName;

    private final ExecutionEnvironment context;

    public UpdateKey(ExecutionEnvironment context, String databaseName, String tableName, String keyName, String valueName) {
        this.databaseName = databaseName;
        this.tableName = tableName;
        this.keyName = keyName;
        this.valueName = valueName;
        this.context = context;
    }

    public DatabaseCommandResult execute() {
        Optional<Database> odb = context.getDatabase(databaseName);
        if (odb.isEmpty()) {
            return ResultUpdateKey.CreateFailedResult(ResultMessages.NO_SUCH_DATABASE);
        }
        try {
            odb.get().write(tableName, keyName, valueName);
            return ResultUpdateKey.CreateSuccessResult();
        }
        catch (DatabaseException e) {
            return ResultUpdateKey.CreateFailedResult(e.getMessage());
        }
    }
}