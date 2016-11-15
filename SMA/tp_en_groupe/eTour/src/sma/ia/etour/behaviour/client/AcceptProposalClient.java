package sma.ia.etour.behaviour.client;

import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;
import sma.ia.etour.agent.ClientAgent;
import sma.ia.etour.ontology.Requirements;

public class AcceptProposalClient extends CyclicBehaviour {

	private Requirements requirements = null;

	private ClientAgent clientAgent;

	public AcceptProposalClient(ClientAgent c) {
		clientAgent = c;
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		ACLMessage msg = myAgent.receive(MessageTemplate
				.MatchConversationId("Requirements"));
		if (msg != null) {
			try {
				String content = (String)msg.getContentObject();
				// System.out.println(content);
				// add
				if (msg.getPerformative() == ACLMessage.PROPOSE) {
					// 
				requirements = (Requirements) msg.getContentObject();
					requirements.setAdr(msg.getSender().getName());
					
					clientAgent.getMyGui().returnInformTour("Acceptation.........!");
					
					ACLMessage reply = msg.createReply();
					reply.setPerformative(ACLMessage.ACCEPT_PROPOSAL);
					reply.setContent("Acceptation");
					myAgent.send(reply);
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
