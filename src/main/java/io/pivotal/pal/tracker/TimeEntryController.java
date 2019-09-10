package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {

    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody TimeEntry timeEntryToCreate) {
        TimeEntry timeEntry = timeEntryRepository.create(timeEntryToCreate);
        return new ResponseEntity(timeEntry, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable long id) {
        TimeEntry timeEntry = timeEntryRepository.find(id);
        return new ResponseEntity<>(timeEntry, timeEntry== null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable long id, @RequestBody TimeEntry expected) {
        TimeEntry timeEntry = timeEntryRepository.update(id, expected);
        return new ResponseEntity(timeEntry, timeEntry== null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    @RequestMapping(path="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable long id) {
            timeEntryRepository.delete(id);
            return new ResponseEntity( HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {
        return new ResponseEntity<>(timeEntryRepository.list(), HttpStatus.OK);
    }
}
