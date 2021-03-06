package com.trade.tradejournal.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder

@Entity
@Table(name="Journal")
public class Entry {

    @Id
    @NonNull
    private Integer tradeId;
    private Date date;
    private String ticker;
    private Double entryPrice;
    private Double exitPrice;
    private String comments;
}
