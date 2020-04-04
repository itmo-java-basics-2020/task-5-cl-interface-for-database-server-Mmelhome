package ru.andrey.kvstorage;

import ru.andrey.kvstorage.command.Parser;
import ru.andrey.kvstorage.command.PositionParser;
import ru.andrey.kvstorage.console.DatabaseCommandResult;
import ru.andrey.kvstorage.console.ExecutionEnvironment;

public class DatabaseServer {

    private static final Parser DEFAULT_COMMAND_PARSER = PositionParser.INSTANCE;

    private final ExecutionEnvironment env;

    private final Parser parser;

    public DatabaseServer(ExecutionEnvironment env) {
        this(env, DEFAULT_COMMAND_PARSER);
    }

    public DatabaseServer(ExecutionEnvironment env, Parser parser) {
        this.env = env;
        this.parser = parser;
    }

    public static void main(String[] args) {

    }

    DatabaseCommandResult executeNextCommand(String commandText) {
        try {
            return parser.Parse(env, commandText).execute();
        }catch (Exception e){
            return null;
        }
    }
}
