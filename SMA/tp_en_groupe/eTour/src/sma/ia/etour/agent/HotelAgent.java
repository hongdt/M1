package sma.ia.etour.agent;

import java.util.LinkedList;
import java.util.List;

import sma.ia.etour.behaviour.hotel.ReceiveRequestHotel;
import sma.ia.etour.ontology.Hotel;
import sma.ia.etour.ontology.Requirements;
import sma.ia.etour.ontology.Room;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class HotelAgent extends Agent {
	private Requirements requirements = null;

	protected void setup() {

		DFAgentDescription dfd = new DFAgentDescription();
		dfd.setName(getAID());

		ServiceDescription sd = new ServiceDescription();
		sd.setType("Hotel");
		sd.setName("HOTEL");
		dfd.addServices(sd);

		try {
			DFService.register(this, dfd);
		} catch (FIPAException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addBehaviour(new ReceiveRequestHotel(this));
	}

	public Requirements getRequirements() {
		return requirements;
	}

	public void setRequirements(Requirements requirements) {
		this.requirements = requirements;
	}

	// list des hotels et chambres
	public List<Room> getListHotel_and_Rooms() {
		List<Hotel> hotels = new Hotel().findByAddress(requirements.getAdr());
		List<Room> rooms = new LinkedList<Room>();
		for (Hotel h : hotels) {
			rooms.addAll(new Room().findByType_Price(
					requirements.getTypeRoom(), requirements.getRoomPrice(), h));
		}
		return rooms;
	}

	protected void takeDown() {
		try {
			DFService.deregister(this);
			System.out.println(getLocalName() + " termine.....");
		} catch (FIPAException e) {
			e.printStackTrace();
		}
	}
}
