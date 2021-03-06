package com.trade.tradejournal.controller;

import com.trade.tradejournal.entity.Entry;
import com.trade.tradejournal.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class JournalController {

    @Autowired
    private JournalService journalService;

    @RequestMapping(value="/trade/journal", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllJournalEntries() {
        List<Entry> entries = journalService.getAllJournalEntries();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(entries);
    }

    @RequestMapping(value="/trade/falseget", method = RequestMethod.GET)
    public ResponseEntity<Object> getTest() {
        journalService.makeJournalEntry();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Collections.singletonMap("Response", "Ok"));
    }
}
