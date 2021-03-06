package com.trade.tradejournal.service;

import com.trade.tradejournal.entity.Entry;
import com.trade.tradejournal.repository.JournalRepositoyInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.Instant;
import java.util.List;

@Service
public class JournalService {

    @Autowired
    private JournalRepositoyInterface journalRepository;

    public List<Entry> getAllJournalEntries(){
        return journalRepository.findAll();
    }

    /** Description
     *
     * @param - stuff
     * @param - stuff
     * @return fasle if error, true if successful
     */
    public boolean makeJournalEntry(){
        Entry mockEntry = Entry.builder()
                .tradeId(1)
                .date(Time.from(Instant.EPOCH))
                .ticker("AAPL")
                .entryPrice(120.05)
                .exitPrice(126.48)
                .comments("This trade was dank.")
                .build();
        try {
            journalRepository.save(mockEntry);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
