package com.MyJournalLife.journalApp.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MyJournalLife.journalApp.configuration.DataServiceConfiguration;
import com.MyJournalLife.journalApp.entity.DataEntry;
import com.MyJournalLife.journalApp.service.DataEntryService;

@RequestMapping("/journal")
@RestController
public class DataEntryController {
	
	private Map<Long, DataEntry> data = new HashMap<>();
	
//	@Autowired
//	DataEntryService des;
	
	@Autowired
	DataServiceConfiguration dataServiceConfig;
	
	//Adding data from request body to the map
	@PostMapping
	public boolean addData(@RequestBody DataEntry requestBody) {
		//des.addData(requestBody);
		data.put(requestBody.getId(), requestBody);
		return true;
	}

	//It will return all the values of data entry records
	@GetMapping
	public List<DataEntry> getData() {
		//return des.getData();
		return new ArrayList<>(data.values());
	}
	
	//@PathVariable & @RequestParam is same
	
	//Updating based on id and sending updated data in the request body
	@PutMapping("/id/{myId}")
	public boolean updateDataById(@PathVariable long myId, @RequestBody DataEntry requestBody ) {
		//des.updateDataById(requestBody);
		data.put(myId, requestBody);
		return true;
	}
	
	
	//It will return the values of data entry of ID provided as i/p
	@GetMapping("/id/{myId}")
	public DataEntry getDataById(@PathVariable long myId) {
		//des.getDataById(myId);
		return data.get(myId);
	}
	
	//It will delete the record from map based on the ID(i.e, Key) passed 
	@DeleteMapping("id/{id}")
	public boolean deleteDataById(@PathVariable long id) {
		//des.deleteDataById(id);
		data.remove(id);
		return true;
	}
	
	//calling config values from application properties file
	@GetMapping("/configuration")
	public DataServiceConfiguration getConfiguration() {
		return dataServiceConfig;
	}
	
}
