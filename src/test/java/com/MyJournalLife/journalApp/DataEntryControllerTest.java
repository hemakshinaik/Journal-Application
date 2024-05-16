package com.MyJournalLife.journalApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.MyJournalLife.journalApp.controllers.DataEntryController;
import com.MyJournalLife.journalApp.entity.DataEntry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

@SpringBootTest
public class DataEntryControllerTest {
	
	@Autowired
	DataEntryController dec;
	
	@Test
	public void test_addData() {
		assertEquals(true, dec.addData(new DataEntry(1, "Good", "I'm Good")));
	}
	
	@Test
	public void test_updateDataById() {
		assertTrue(dec.updateDataById(2, new DataEntry(1, "Great", "I'm Great")));
		
	}
	
}
