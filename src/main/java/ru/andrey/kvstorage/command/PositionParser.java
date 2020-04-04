package ru.andrey.kvstorage.command;

import ru.andrey.kvstorage.console.DatabaseCommand;
import ru.andrey.kvstorage.console.ExecutionEnvironment;

import java.util.Objects;

public class PositionParser implements Parser {

    public static final PositionParser INSTANCE = new PositionParser();

    private static final String CREATE_DATABASE_COMMAND = "CREATE_DATABASE";

    private static final String CREATE_TABLE_COMMAND = "CREATE_TABLE";

    private static final String UPDATE_KEY_COMMAND = "UPDATE_KEY";

    private static final String READ_KEY_COMMAND = "READ_KEY";

    private static final Character COMMAND_ARGUMENT_SEPARATOR = ' ';

    private PositionParser() {

    }

    private String[] InternalParse(String command) {
        String[] primaryResult = command.split("\\" + COMMAND_ARGUMENT_SEPARATOR);
        String[] result = new String[primaryResult.length - 1];
        for (int i = 1; i < primaryResult.length; ++i) {
            result[i - 1] = primaryResult[i];
        }
        return result;
    }

    public DatabaseCommand Parse(ExecutionEnvironment environment, String command) {
        if (Objects.isNull(command)) {
            return Error.INSTANCE;
        }
        String[] arguments = InternalParse(command);
        if (command.startsWith(CREATE_TABLE_COMMAND) && arguments.length == 2) {
            return new CreateDatabaseTable(environment, arguments[0], arguments[1]);
        }
        if (command.startsWith(UPDATE_KEY_COMMAND) && arguments.length == 4) {
            return new UpdateKey(environment, arguments[0], arguments[1], arguments[2], arguments[3]);
        }
        if (command.startsWith(READ_KEY_COMMAND) && arguments.length == 3) {
            return new ReadKey(environment, arguments[0], arguments[1], arguments[2]);
        }
        return Error.INSTANCE;
    }

}