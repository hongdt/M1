package rTour.ontology;

import jade.content.Predicate;


public class Clients  implements Predicate {
	private String name;
	private Tourism tourism;
	private int minCost;
	private int maxCost;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Tourism getTourism() {
		return tourism;
	}
	public void setTourism(Tourism tourism) {
		this.tourism = tourism;
	}
	public int getMinCost() {
		return minCost;
	}
	public void setMinCost(int minCost) {
		this.minCost = minCost;
	}
	public int getMaxCost() {
		return maxCost;
	}
	public void setMaxCost(int maxCost) {
		this.maxCost = maxCost;
	}
}
