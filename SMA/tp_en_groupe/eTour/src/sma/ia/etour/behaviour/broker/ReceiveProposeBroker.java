package sma.ia.etour.behaviour.broker;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import sma.ia.etour.agent.BrokerAgent;
import sma.ia.etour.agent.ClientAgent;
import sma.ia.etour.ontology.Requirements;
import sma.ia.etour.ontology.Room;
import sma.ia.etour.ontology.Transport;

public class ReceiveProposeBroker extends CyclicBehaviour {

	private Requirements requirements = null;

	private BrokerAgent brokerAgent;
	private List<Transport> list = new LinkedList<Transport>();
	private List<Room> rooms = new LinkedList<Room>();
	private AID bestHotel = null;
	private AID bestTrans = null;
	private AID clientAgent = null;

	double bestPriceRoom = 0;
	double bestPrice = 0;
	String type = null;

	public ReceiveProposeBroker(BrokerAgent b, AID a) {
		this.brokerAgent = b;
		this.clientAgent = a;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void action() {
		// TODO Auto-generated method stub
		// Receive propose
		System.out.println("Broker ReceiveProposeBroker: Receiving...");
		ACLMessage msg = myAgent.receive();
		if (msg != null) {
			try {
				requirements = brokerAgent.getRequirements();
				// transport
				if (msg.getConversationId() == "Booking-Transport") {
					list = (List<Transport>) msg.getContentObject();
					if (msg.getPerformative() == ACLMessage.PROPOSE) {
						//
						for (Transport t : list) {
							if (bestPrice == 0 || (t.getPrice() < bestPrice)) {
								bestPrice = t.getPrice();
								requirements.setTypeVeh(t.getTypeVeh());
								brokerAgent.setTransport(t);
							}
						}
						requirements.setPriceVeh(bestPrice);
						bestTrans = msg.getSender();

					}// fin propose
					else if(msg.getPerformative() == ACLMessage.INFORM){
						//informer au client
						ACLMessage rep = new ACLMessage(ACLMessage.INFORM);
						rep.setConversationId("Requirements");
						rep.addReceiver(clientAgent);
						rep.setContentObject(msg.getContentObject());
						myAgent.send(rep);
					}else if(msg.getPerformative() == ACLMessage.REJECT_PROPOSAL){
						//informer au client
						ACLMessage rep = new ACLMessage(ACLMessage.INFORM);
						rep.setConversationId("Requirements");
						rep.addReceiver(clientAgent);
						rep.setContentObject("Pas de disponibilite");
						myAgent.send(rep);
					}
				} else if (msg.getConversationId() == "Booking-Hotel") {
					rooms = (List<Room>) msg.getContentObject();
					if (msg.getPerformative() == ACLMessage.PROPOSE) {
						//
						for (Room r : rooms) {
							if (bestPriceRoom == 0
									|| (r.getPrice() < bestPriceRoom)) {
								bestPriceRoom = r.getPrice();
								requirements.setTypeRoom(r.getTypeRoom());
								requirements.setHotel(r.getHotel().getName());
								brokerAgent.setRoom(r);
							}
						}
						requirements.setRoomPrice(bestPriceRoom);
						bestHotel = msg.getSender();

					}// fin propose
					else if(msg.getPerformative() == ACLMessage.INFORM){
						//informer au client
						ACLMessage rep = new ACLMessage(ACLMessage.INFORM);
						rep.setConversationId("Requirements");
						rep.addReceiver(clientAgent);
						rep.setContentObject(msg.getContentObject());
						myAgent.send(rep);
					}else if(msg.getPerformative() == ACLMessage.REJECT_PROPOSAL){
						//informer au client
						ACLMessage rep = new ACLMessage(ACLMessage.INFORM);
						rep.setConversationId("Requirements");
						rep.addReceiver(clientAgent);
						rep.setContentObject("Pas de disponibilite");
						myAgent.send(rep);
					}
				} else if (msg.getConversationId() == "Requirements") {
					if ((msg.getPerformative() == ACLMessage.REQUEST)
							&& ((brokerAgent.getTransport() != null) && (brokerAgent
									.getRoom() != null))) {
						//envoi de proposition au client
						ACLMessage reply = msg.createReply();
						reply.setPerformative(ACLMessage.PROPOSE);
						reply.setContentObject(requirements);
						myAgent.send(reply);
					}else if (msg.getPerformative() == ACLMessage.ACCEPT_PROPOSAL) {
						//envoi d'acceptation au meilleur hotelAgent
						ACLMessage rep = new ACLMessage(ACLMessage.ACCEPT_PROPOSAL);
						rep.setConversationId("Booking-Hotel");
						rep.addReceiver(bestHotel);
						rep.setContentObject(brokerAgent.getRoom());
						myAgent.send(rep);
						//acceptation pour le transporteur
						ACLMessage rep2 = new ACLMessage(ACLMessage.ACCEPT_PROPOSAL);
						rep2.setConversationId("Booking-Transport");
						rep2.addReceiver(bestTrans);
						rep2.setContentObject(brokerAgent.getTransport());
						myAgent.send(rep2);
					}
					
				} else if (msg.getPerformative() == ACLMessage.CFP) {
					// terminate
				}
				brokerAgent.setRequirements(requirements);
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
