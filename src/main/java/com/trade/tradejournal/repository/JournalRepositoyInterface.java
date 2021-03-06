package com.trade.tradejournal.repository;

import com.trade.tradejournal.entity.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JournalRepositoyInterface extends JpaRepository<Entry, Integer> {

    public List<Entry> findByTicker(String ticker);

}
