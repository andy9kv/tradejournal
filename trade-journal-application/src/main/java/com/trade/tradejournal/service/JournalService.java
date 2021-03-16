package com.trade.tradejournal.service;

import com.trade.tradejournal.entity.Entry;
import com.trade.tradejournal.repository.JournalRepositoyInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public boolean makeJournalEntry(Entry entry){
        try {
            journalRepository.save(entry);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
