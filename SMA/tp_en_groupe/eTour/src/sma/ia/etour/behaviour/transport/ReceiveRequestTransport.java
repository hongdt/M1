package sma.ia.etour.behaviour.transport;

import java.io.IOException;
import java.io.Serializable;

import sma.ia.etour.agent.TransportAgent;
import sma.ia.etour.ontology.Requirements;
import sma.ia.etour.ontology.Room;
import sma.ia.etour.ontology.Transport;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;

public class ReceiveRequestTransport extends CyclicBehaviour {

	private Requirements requirements = null;

	private TransportAgent transpAgent;

	public ReceiveRequestTransport(TransportAgent t) {
		// TODO Auto-generated constructor stub
		transpAgent = t;
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		// Receive request from broker
		System.out.println("Transport ReceiveRequestTransport: Receiving...");
		ACLMessage msg = myAgent.receive(MessageTemplate
				.MatchConversationId("Booking-Transport"));
		if (msg != null) {
			try {
				String content = msg.getContent();
				System.out.println(content);
				requirements = (Requirements) msg.getContentObject();
				// add
				if (msg.getPerformative() == ACLMessage.REQUEST) {
					transpAgent.setRequirements(requirements);
					ACLMessage reply = msg.createReply();
					Object obj = transpAgent.getListTransport();
					if (obj != null) {
						reply.setPerformative(ACLMessage.PROPOSE);
						reply.setContentObject((Serializable) obj);
						myAgent.send(reply);
					} else {
						reply.setPerformative(ACLMessage.REJECT_PROPOSAL);
						reply.setContentObject("Pas Vehicules disponibles");
						myAgent.send(reply);
					}
				} else if (msg.getPerformative() == ACLMessage.ACCEPT_PROPOSAL) {
					Transport tr = (Transport) msg.getContentObject();
					ACLMessage reply = msg.createReply();
					reply.setPerformative(ACLMessage.INFORM);
					reply.setContentObject("Booking Transport effectue.....");
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
