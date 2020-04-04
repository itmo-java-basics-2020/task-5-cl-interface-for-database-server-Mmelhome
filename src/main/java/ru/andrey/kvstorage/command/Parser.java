package ru.andrey.kvstorage.command;

import ru.andrey.kvstorage.console.DatabaseCommand;
import ru.andrey.kvstorage.console.ExecutionEnvironment;

public interface Parser {
    DatabaseCommand Parse(ExecutionEnvironment environment, String command);
}