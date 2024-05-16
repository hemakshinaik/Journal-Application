package com.MyJournalLife.journalApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyJournalLife.journalApp.entity.DataEntry;
import com.MyJournalLife.journalApp.repository.DataEntryRepository;

@Service
public class DataEntryService {

	@Autowired
	DataEntryRepository der;
	
	//adds data into db
	public void addData(DataEntry data) {
		der.save(data);
	}
	
	//gets all data from db
	public List<DataEntry> getData(){
		List<DataEntry> data = new ArrayList<>();
		der.findAll().forEach(d-> data.add(d));
		return data;
	}
	
	//gets data based on Id passed
	public Optional<DataEntry> getDataById(long id) {
		return der.findById(id);
	}
	
	//updates data if already exists or inserts a new data record in db
	public void updateDataById(DataEntry d) {
		der.save(d);
	}
	
	//deletes data from db based on Id
	public void deleteDataById(long id) {
		der.deleteById(id);
	}
	
	//deletes all data from db
	public void delete() {
		der.deleteAll();
	}
}
