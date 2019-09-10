package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    Map<Long, TimeEntry> entries = new HashMap<>();

    private long index = 0;

    public TimeEntry create(TimeEntry timeEntry) {
        TimeEntry newEntry = new TimeEntry(++index, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
        entries.put(newEntry.getId(), newEntry);
        return newEntry;
    }

    public TimeEntry find(long id) {
        return entries.get(id);
    }

    public List<TimeEntry> list() {
        return new ArrayList(this.entries.values());
    }

    public TimeEntry update(long id, TimeEntry timeEntry) {
        if (!entries.containsKey(id)) {
            return null;
        }
        TimeEntry newEntry = new TimeEntry(id, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
        entries.put(id, newEntry);
        return newEntry;
    }

    public void delete(long id) {
        entries.remove(id);
    }
}
