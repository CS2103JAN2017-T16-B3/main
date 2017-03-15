package seedu.watodo.logic.commands;

import seedu.watodo.model.TaskList;

/**
 * Clears the task manager.
 */
public class ClearCommand extends Command {

    public static final String COMMAND_WORD = "clear";
    public static final String MESSAGE_SUCCESS = "All tasks have been cleared!";


    @Override
    public CommandResult execute() {
        assert model != null;
        model.resetData(new TaskList());
        return new CommandResult(MESSAGE_SUCCESS);
    }
}