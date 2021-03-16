package com.trade.tradejournal.controller;

import com.trade.tradejournal.entity.Entry;
import com.trade.tradejournal.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value="/trade/post", method = RequestMethod.POST)
    public ResponseEntity<Object> postJournalEntry(
            @RequestBody @Validated Entry entry) {
        System.out.println(entry.toString());
        boolean response = journalService.makeJournalEntry(entry);
        System.out.println(response);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Collections.singletonMap("Response", "Ok"));
    }
}
