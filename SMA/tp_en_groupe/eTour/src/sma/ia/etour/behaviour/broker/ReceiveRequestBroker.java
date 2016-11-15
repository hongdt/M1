package sma.ia.etour.behaviour.broker;


import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;
import sma.ia.etour.agent.BrokerAgent;
import sma.ia.etour.ontology.Requirements;

public class ReceiveRequestBroker extends CyclicBehaviour {

	private Requirements requirements = null;

	private BrokerAgent brokerAgent;

	public ReceiveRequestBroker(BrokerAgent b) {
		this.brokerAgent = b;
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		// Receive request from broker
		System.out.println("Broker ReceiveRequestBroker: Receiving...");
		ACLMessage msg = myAgent.receive(MessageTemplate
				.MatchConversationId("Requirements"));
		if (msg != null) {
			try {
				String content = msg.getContent();
				System.out.println(content);
				requirements = (Requirements) msg.getContentObject();
				// add
				if (msg.getPerformative() == ACLMessage.REQUEST) {
					brokerAgent.setRequirements(requirements);
					//envoyer la requete aux agents hotels et transports
					brokerAgent.getHotelAgents().add(new AID("HOTEL", AID.ISLOCALNAME));
					brokerAgent.getTranspAgent().add(new AID("TRANSPORT", AID.ISLOCALNAME));
					
					brokerAgent.addBehaviour(new SendRequestBroker(brokerAgent.getHotelAgents(), 
							brokerAgent.getTranspAgent(), requirements));
					brokerAgent.addBehaviour(new ReceiveProposeBroker(brokerAgent, msg.getSender()));
					
				} else if (msg.getPerformative() == ACLMessage.CFP) {
					// terminate
				}
			} catch (UnreadableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			block();
		}
	}

}
