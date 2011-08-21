package com.gis.server.entities;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "BIDS")
public class Bid implements Serializable {

	@Column(name = "BID_DATE")
	private Date bidDate;

	@SequenceGenerator(name = "BID_SEQ_GEN", sequenceName = "BID_SEQUENCE", initialValue = 1, allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BID_SEQ_GEN")
	@Column(name = "BID_ID")
	private Long bidId;

	@Column(name = "BID_PRICE")
	private Double bidPrice;

	@ManyToOne
	@JoinColumn(name = "BID_ITEM_ID", referencedColumnName = "ITEM_ID")
	private Item item;

	public Bid() {
	}


	public Long getBidId() {
		return bidId;
	}



	public Date getBidDate() {
		return bidDate;
	}


	public void setBidDate(Date bidDate) {
		this.bidDate = bidDate;
	}


	public void setBidId(Long bidId) {
		this.bidId = bidId;
	}



	public Double getBidPrice() {
		return bidPrice;
	}


	public void setBidPrice(Double bidPrice) {
		this.bidPrice = bidPrice;
	}



	public Item getItem() {
		return item;
	}


	public void setItem(Item item) {
		this.item = item;
	}
}