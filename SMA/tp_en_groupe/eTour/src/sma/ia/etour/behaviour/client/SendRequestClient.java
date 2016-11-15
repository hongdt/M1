package sma.ia.etour.behaviour.client;

import java.io.IOException;
import java.util.List;

import sma.ia.etour.ontology.Requirements;
import jade.core.AID;
import jade.core.behaviours.Behaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;

public class SendRequestClient extends Behaviour {

	private Requirements requirements = null;

	public SendRequestClient(Requirements req) {
		requirements = req;
	}

	@Override
	public void action() {
		DFAgentDescription template = new DFAgentDescription();
		ServiceDescription serviceDescription = new ServiceDescription();
		serviceDescription.setType("Client");
		template.addServices(serviceDescription);
		DFAgentDescription[] results = null;
		try {
			results = DFService.search(myAgent, new AID("BROKER",
					AID.ISLOCALNAME), template);
		} catch (FIPAException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (results != null && results.length > 0) {
			for (int i = 0; i < results.length; i++) {
				ACLMessage cfp = new ACLMessage(ACLMessage.REQUEST);
				try {
					cfp.setContentObject(requirements);
					cfp.setConversationId("Requirements");
					cfp.addReceiver(results[i].getName());
					myAgent.send(cfp);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public boolean done() {
		// TODO Auto-generated method stub
		return true;
	}

}
