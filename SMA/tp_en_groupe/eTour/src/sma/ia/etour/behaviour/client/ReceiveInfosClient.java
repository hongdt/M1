package sma.ia.etour.behaviour.client;

import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;
import sma.ia.etour.agent.ClientAgent;
import sma.ia.etour.ontology.Requirements;

public class ReceiveInfosClient extends CyclicBehaviour {

	private Requirements requirements = null;

	private ClientAgent clientAgent;

	public ReceiveInfosClient(ClientAgent c) {
		clientAgent = c;
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		// Receive request from broker
		System.out.println("Broker ReceiveProposal: Receiving...");
		ACLMessage msg = myAgent.receive(MessageTemplate
				.MatchConversationId("Requirements"));
		if (msg != null) {
			try {
				String content = (String)msg.getContentObject();
				// System.out.println(content);
				requirements = (Requirements) msg.getContentObject();
				// add
				if (msg.getPerformative() == ACLMessage.PROPOSE) {
					// 
					requirements.setAdr(msg.getSender().getName());
					String str = "Hotel: " + requirements.getHotel()
							+ ", Type Chambre: " + requirements.getTypeRoom()
							+ ", Prix: " + requirements.getRoomPrice()
							+ ", Vehicule: " + requirements.getTypeVeh()
							+ ", Prix: " + requirements.getPriceVeh();

					clientAgent.getMyGui().returnInformBroker("Acceptation.........!");
					clientAgent.getMyGui().returnInformTour(str);
				} else{
					// 
					clientAgent.getMyGui().returnInformTour(content);

				}

				clientAgent.setRequirements(requirements);
			} catch (UnreadableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			block();
		}
	}

}
