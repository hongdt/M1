package sma.ia.etour.agent;

import java.util.List;

import sma.ia.etour.behaviour.transport.ReceiveRequestTransport;
import sma.ia.etour.ontology.Requirements;
import sma.ia.etour.ontology.Transport;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class TransportAgent extends Agent {

	private Requirements requirements = null;

	protected void setup() {

		DFAgentDescription dfd = new DFAgentDescription();
		dfd.setName(getAID());

		ServiceDescription sd = new ServiceDescription();
		sd.setType("Transport");
		sd.setName("TRANSPORT");
		dfd.addServices(sd);

		try {
			DFService.register(this, dfd);
		} catch (FIPAException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addBehaviour(new ReceiveRequestTransport(this));
	}

	public Requirements getRequirements() {
		return requirements;
	}

	public void setRequirements(Requirements requirements) {
		this.requirements = requirements;
	}

	// recuperation de la liste des transports
	public List<Transport> getListTransport() {
		return new Transport().findByType_Price(requirements.getTypeVeh(),
				requirements.getPriceVeh());
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
