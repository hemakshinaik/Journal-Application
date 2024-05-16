package com.MyJournalLife.journalApp.repository;

import org.springframework.data.repository.CrudRepository;
import com.MyJournalLife.journalApp.entity.DataEntry;

public interface DataEntryRepository extends CrudRepository<DataEntry, Long> {

}
