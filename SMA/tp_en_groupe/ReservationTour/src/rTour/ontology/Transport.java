package rTour.ontology;

import jade.content.Concept;
import jade.content.Predicate;
import jade.core.AID;

public class Transport implements Concept {

	private AID AIDTransport;
	private String typeTransport;
	private String name;
	private String quality;
	private int price;
	private String destination;
	private String beginning;
	private int deviation;
	private int numberFree;
	private int time; //so thoi gian di
	private int numberSlot;
	public String getTypeTransport() {
		return typeTransport;
	}
	public void setTypeTransport(String typeTransport) {
		this.typeTransport = typeTransport;
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getBeginning() {
		return beginning;
	}
	public void setBeginning(String beginning) {
		this.beginning = beginning;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDeviation() {
		return deviation;
	}
	public void setDeviation(int deviation) {
		this.deviation = deviation;
	}
	
	public int getNumberFree() {
		return numberFree;
	}
	public void setNumberFree(int numberFree) {
		this.numberFree = numberFree;
	}
	public AID getAIDTransport() {
		return AIDTransport;
	}
	public void setAIDTransport(AID aIDTransport) {
		AIDTransport = aIDTransport;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getNumberSlot() {
		return numberSlot;
	}
	public void setNumberSlot(int numberSlot) {
		this.numberSlot = numberSlot;
	}
}
