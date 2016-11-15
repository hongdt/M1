package sma.ia.etour.behaviour.broker;

import java.util.List;

import sma.ia.etour.ontology.Requirements;
import jade.core.AID;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;

public class SendRequestBroker extends Behaviour {

	private Requirements requirements = null;
	
	private List<AID> hotels;
	private List<AID> transports;
	
	public SendRequestBroker(List<AID> h, List<AID> tr, Requirements req) {
		hotels = h;
		transports = tr;
		requirements = req;
	}

	@Override
	public void action() {
		//request pour hotels
		for (AID hotel : hotels) {
			ACLMessage cfp = new ACLMessage(ACLMessage.REQUEST);
			try {
				cfp.setContentObject(requirements);	
				cfp.setConversationId("Booking-Hotel");
				cfp.addReceiver(hotel);							
				myAgent.send(cfp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//request pour transports
		for (AID trans : transports) {
			ACLMessage cfp = new ACLMessage(ACLMessage.REQUEST);
			try {
				cfp.setContentObject(requirements);	
				cfp.setConversationId("Booking-Transport");
				cfp.addReceiver(trans);							
				myAgent.send(cfp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public boolean done() {
		// TODO Auto-generated method stub
		return true;
	}

}
