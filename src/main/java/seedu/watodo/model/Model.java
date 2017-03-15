package seedu.watodo.model;

import java.util.Set;

import seedu.watodo.commons.core.UnmodifiableObservableList;
import seedu.watodo.model.task.FloatingTask;
import seedu.watodo.model.task.ReadOnlyFloatingTask;
import seedu.watodo.model.task.UniqueTaskList;
import seedu.watodo.model.task.UniqueTaskList.DuplicateTaskException;

/**
 * The API of the Model component.
 */
public interface Model {
    /** Clears existing backing model and replaces with the provided new data. */
    void resetData(ReadOnlyTaskList newData);

    /** Returns the AddressBook */
    ReadOnlyTaskList getAddressBook();

    /** Deletes the given person. */
    void deleteTask(ReadOnlyFloatingTask target) throws UniqueTaskList.TaskNotFoundException;

    /** Adds the given person */
    void addTask(FloatingTask task) throws UniqueTaskList.DuplicateTaskException;

    /**
     * Updates the person located at {@code filteredPersonListIndex} with {@code editedPerson}.
     *
     * @throws DuplicateTaskException if updating the person's details causes the person to be equivalent to
     *      another existing person in the list.
     * @throws IndexOutOfBoundsException if {@code filteredPersonListIndex} < 0 or >= the size of the filtered list.
     */
    void updateTask(int filteredPersonListIndex, ReadOnlyFloatingTask editedPerson)
            throws UniqueTaskList.DuplicateTaskException;

    /** Returns the filtered person list as an {@code UnmodifiableObservableList<ReadOnlyTask>} */
    UnmodifiableObservableList<ReadOnlyFloatingTask> getFilteredTaskList();

    /** Updates the filter of the filtered person list to show all persons */
    void updateFilteredListToShowAll();

    /** Updates the filter of the filtered person list to filter by the given keywords*/
    void updateFilteredTaskList(Set<String> keywords);

}