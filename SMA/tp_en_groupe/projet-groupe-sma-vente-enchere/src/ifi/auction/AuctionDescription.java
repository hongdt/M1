package ifi.auction;


import jade.content.Concept;
import jade.core.AID;
import jade.util.leap.Serializable;

public class AuctionDescription implements Concept, Serializable{
	private String productName;
	private double initialPrice;
	private double minStep;
	private double currentPrice;
	private AID currentBidder;
	private String expire;
	private String description;
	private AID auction;
	//Auctionner
	private AID auctionner;
	//private Set<Good> goods = null;
	public AuctionDescription(String productName, double initialPrice, double minStep, 
			String expire, String description) {
		super();
		this.minStep = minStep;
		this.productName = productName;
		this.initialPrice = initialPrice;
		this.expire = expire;
		this.description = description;
		this.currentPrice = initialPrice;
		this.auction = null;
	}
	public double getMinStep() {
		return minStep;
	}
	public void setMinStep(double minStep) {
		this.minStep = minStep;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getInitialPrice() {
		return initialPrice;
	}
	public void setInitialPrice(double initialPrice) {
		this.initialPrice = initialPrice;
	}
	public String getExpire() {
		return expire;
	}
	public void setExpire(String expire) {
		this.expire = expire;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}
	public AID getCurrentBidder() {
		return currentBidder;
	}
	public void setCurrentBidder(AID currentBidder) {
		this.currentBidder = currentBidder;
	}
	public AID getAuction() {
		return auction;
	}
	public void setAuction(AID auction) {
		this.auction = auction;
	}	
	//Auctionner
	public AID getAuctionner() {
		return auctionner;
	}
	public void setAuctionner(AID auctionner) {
		this.auctionner = auctionner;
	}	
}
