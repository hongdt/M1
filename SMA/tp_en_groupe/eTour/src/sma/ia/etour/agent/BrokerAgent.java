package sma.ia.etour.agent;


import java.util.List;
import java.util.Vector;

import sma.ia.etour.behaviour.broker.ReceiveProposeBroker;
import sma.ia.etour.behaviour.broker.ReceiveRequestBroker;
import sma.ia.etour.ontology.Requirements;
import sma.ia.etour.ontology.Room;
import sma.ia.etour.ontology.Transport;
import jade.core.AID;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class BrokerAgent extends Agent {

	private Requirements requirements = null;
	private Transport transport = null;
	private Room room = null;

	private List<AID> hotelAgents = new Vector<AID>();
	private List<AID> transpAgent = new Vector<AID>();

	protected void setup() {

		DFAgentDescription dfd = new DFAgentDescription();
		dfd.setName(getAID());

		ServiceDescription sd = new ServiceDescription();
		sd.setType("Broker");
		sd.setName("BROKER");
		dfd.addServices(sd);

		try {
			DFService.register(this, dfd);
		} catch (FIPAException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addBehaviour(new ReceiveRequestBroker(this));
	}

	public Requirements getRequirements() {
		return requirements;
	}

	public void setRequirements(Requirements requirements) {
		this.requirements = requirements;
	}

	public List<AID> getHotelAgents() {
		return hotelAgents;
	}

	public void setHotelAgents(List<AID> hotelAgents) {
		this.hotelAgents = hotelAgents;
	}

	public List<AID> getTranspAgent() {
		return transpAgent;
	}

	public void setTranspAgent(List<AID> transpAgent) {
		this.transpAgent = transpAgent;
	}
	
	public Transport getTransport() {
		return transport;
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
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
