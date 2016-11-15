package sma.ia.etour.ontology;

import jade.core.AID;

import java.io.Serializable;

public class Requirements implements Serializable{

	private String hotel;
	private String adr;
	private String typeRoom;
	private String typeVeh;
	
	private double roomPrice;
	private double priceVeh;

	private AID clientAgent;
	
	public Requirements() {
		
	}
	//hotel requirements
	public Requirements(String hotel, String adr, String typeRoom, double roomPrice) {
		this.hotel = hotel;
		this.adr = adr;
		this.typeRoom = typeRoom;
		this.roomPrice = roomPrice;
	}
	
	//transport requirements
	public Requirements(String typeVeh, double priceVeh) {
		this.typeVeh = typeVeh;
		this.priceVeh = priceVeh;
	}
	//
	public Requirements(String adr, String typeRoom, String typeVeh,
			double roomPrice, double priceVeh) {
		this.adr = adr;
		this.typeRoom = typeRoom;
		this.typeVeh = typeVeh;
		this.roomPrice = roomPrice;
		this.priceVeh = priceVeh;
	}
	//
	public Requirements(String hotel, String adr, String typeRoom, String typeVeh,
			double roomPrice, double priceVeh) {
		this.hotel = hotel;
		this.adr = adr;
		this.typeRoom = typeRoom;
		this.typeVeh = typeVeh;
		this.roomPrice = roomPrice;
		this.priceVeh = priceVeh;
	}
	public String getAdr() {
		return adr;
	}
	public void setAdr(String adr) {
		this.adr = adr;
	}
	public String getTypeRoom() {
		return typeRoom;
	}
	public void setTypeRoom(String typeRoom) {
		this.typeRoom = typeRoom;
	}
	public String getTypeVeh() {
		return typeVeh;
	}
	public void setTypeVeh(String typeVeh) {
		this.typeVeh = typeVeh;
	}
	public double getRoomPrice() {
		return roomPrice;
	}
	public void setRoomPrice(double roomPrice) {
		this.roomPrice = roomPrice;
	}
	public double getPriceVeh() {
		return priceVeh;
	}
	public void setPriceVeh(double priceVeh) {
		this.priceVeh = priceVeh;
	}
	public String getHotel() {
		return hotel;
	}
	public void setHotel(String hotel) {
		this.hotel = hotel;
	}
	public AID getClientAgent() {
		return clientAgent;
	}
	public void setClientAgent(AID clientAgent) {
		this.clientAgent = clientAgent;
	}
	
	
}
