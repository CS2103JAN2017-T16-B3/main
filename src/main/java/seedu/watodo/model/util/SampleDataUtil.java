package seedu.watodo.model.util;

import seedu.watodo.commons.exceptions.IllegalValueException;
import seedu.watodo.model.ReadOnlyTaskList;
import seedu.watodo.model.TaskList;
import seedu.watodo.model.tag.UniqueTagList;
import seedu.watodo.model.task.Address;
import seedu.watodo.model.task.Description;
import seedu.watodo.model.task.Email;
import seedu.watodo.model.task.FloatingTask;
import seedu.watodo.model.task.Phone;
import seedu.watodo.model.task.UniqueTaskList.DuplicateTaskException;

public class SampleDataUtil {
    public static FloatingTask[] getSampleTasks() {
        try {
            return new FloatingTask[] {
                new FloatingTask(new Description("Read Lord of The Rings"),
                    new UniqueTagList("reading")),
                new FloatingTask(new Description("Do CS2103 V0.1"),
                    new UniqueTagList("school", "homework")),
                new FloatingTask(new Description("Learn airflares"),
                    new UniqueTagList("dance")),
                new FloatingTask(new Description("Design RPG using RPG Maker VX Ace"),
                    new UniqueTagList("gamedesign"))
            };
        } catch (IllegalValueException e) {
            throw new AssertionError("sample data cannot be invalid", e);
        }
    }

    public static ReadOnlyTaskList getSampleWatodo() {
        try {
            TaskList sampleAB = new TaskList();
            for (FloatingTask sampleTask : getSampleTasks()) {
                sampleAB.addTask(sampleTask);
            }
            return sampleAB;
        } catch (DuplicateTaskException e) {
            throw new AssertionError("sample data cannot contain duplicate tasks", e);
        }
    }
}