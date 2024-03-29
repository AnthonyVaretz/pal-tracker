package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {


    public TimeEntry create(TimeEntry any);
    public TimeEntry update(long id, TimeEntry timeEntry);
    public void delete(long id);
    public TimeEntry find(long timeEntryId);
    public List<TimeEntry> list();
}
