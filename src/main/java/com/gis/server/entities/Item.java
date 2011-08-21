package com.gis.server.entities;


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ITEMS")
public class Item implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ITEM_ID", nullable = false)
	private Long itemId;
	
	@Column(name = "ITEM_NAME")
    private String itemName;

	@Column(name = "BID_END_DATE")
    private Timestamp bidEndDate;

    @Column(name = "BID_START_DATE")
    private Timestamp bidStartDate;

    @Column(name = "CREATED_DATE")
    private Timestamp createdDate;

    @Column(name = "INITIAL_PRICE")
    private Double initialPrice;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private List<Bid> bids;

    public Item() {
    }


    public Item(Long itemId) {
        this.itemId = itemId;
    }
    public String getItemName() {
        return itemName;
    }


    public void setItemName(String itemName) {
        this.itemName = itemName;
    }


    
    public Timestamp getBidEndDate() {
        return bidEndDate;
    }


    public void setBidEndDate(Timestamp bidEndDate) {
        this.bidEndDate = bidEndDate;
    }



    public Timestamp getBidStartDate() {
        return bidStartDate;
    }


    public void setBidStartDate(Timestamp bidStartDate) {
        this.bidStartDate = bidStartDate;
    }


    
    public Timestamp getCreatedDate() {
        return createdDate;
    }


    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }



    public Double getInitialPrice() {
        return initialPrice;
    }


    public void setInitialPrice(Double initialPrice) {
        this.initialPrice = initialPrice;
    }

    public Long getItemId() {
        return itemId;
    }


    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    
    public List<Bid> getBids() {
        return bids;
    }


    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }


    public Bid addBid(Bid bid) {
        getBids().add(bid);
        return bid;
    }


    public Bid removeBid(Bid bid) {
        getBids().remove(bid);
        return bid;
    }
}