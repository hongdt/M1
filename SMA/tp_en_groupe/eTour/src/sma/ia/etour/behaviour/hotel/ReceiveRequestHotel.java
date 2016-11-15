package sma.ia.etour.behaviour.hotel;

import java.io.IOException;
import java.io.Serializable;

import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;
import sma.ia.etour.agent.HotelAgent;
import sma.ia.etour.ontology.Requirements;
import sma.ia.etour.ontology.Room;

public class ReceiveRequestHotel extends CyclicBehaviour {

	private Requirements requirements = null;

	private HotelAgent hotelAgent;

	public ReceiveRequestHotel(HotelAgent h) {
		this.hotelAgent = h;
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		// Receive request from broker
		System.out.println("Hotel ReceiveRequestHotel: Receiving...");
		ACLMessage msg = myAgent.receive(MessageTemplate
				.MatchConversationId("Booking-Hotel"));
		if (msg != null) {
			try {
				String content = msg.getContent();
				System.out.println(content);
				// add
				if (msg.getPerformative() == ACLMessage.REQUEST) {
					requirements = (Requirements) msg.getContentObject();
					hotelAgent.setRequirements(requirements);
					ACLMessage reply = msg.createReply();
					Object obj = hotelAgent.getListHotel_and_Rooms();
					if (obj != null) {
						reply.setPerformative(ACLMessage.PROPOSE);
						reply.setContentObject((Serializable) obj);
						myAgent.send(reply);
					} else {
						reply.setPerformative(ACLMessage.REJECT_PROPOSAL);
						reply.setContentObject("Pas de chambres disponibles");
						myAgent.send(reply);
					}
				} else if (msg.getPerformative() == ACLMessage.ACCEPT_PROPOSAL) {
					Room room = (Room) msg.getContentObject();
					ACLMessage reply = msg.createReply();
					reply.setPerformative(ACLMessage.INFORM);
					reply.setContentObject("Booking Hotel effectue.....");
					myAgent.send(reply);
				} else if (msg.getPerformative() == ACLMessage.CFP) {
					// terminate
				}
			} catch (UnreadableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			block();
		}
	}

}
