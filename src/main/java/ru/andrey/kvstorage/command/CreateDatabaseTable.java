package ru.andrey.kvstorage.command;

import ru.andrey.kvstorage.commandResult.ResultDatabaseTable;
import ru.andrey.kvstorage.commandResult.ResultMessages;
import ru.andrey.kvstorage.console.DatabaseCommand;
import ru.andrey.kvstorage.console.DatabaseCommandResult;
import ru.andrey.kvstorage.console.ExecutionEnvironment;
import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.logic.Database;

import java.util.Optional;

public class CreateDatabaseTable implements DatabaseCommand {
    private final String databaseName;
    private final String tableName;
    private final ExecutionEnvironment environment;

    @Override
    public DatabaseCommandResult execute() throws DatabaseException {
        Optional<Database> database = environment.getDatabase(databaseName);

        if (database.isEmpty()) return ResultDatabaseTable.createFailedResult(ResultMessages.NO_SUCH_DATABASE);;

        try {
            database.get().createTableIfNotExists(tableName);
            return ResultDatabaseTable.createSuccessResult();
        }
        catch (DatabaseException e) {
            return ResultDatabaseTable.createFailedResult(e.getMessage());
        }
    }

    public CreateDatabaseTable(ExecutionEnvironment environment, String databaseName, String tableName) {
        this.databaseName = databaseName;
        this.tableName = tableName;
        this.environment = environment;
    }
}