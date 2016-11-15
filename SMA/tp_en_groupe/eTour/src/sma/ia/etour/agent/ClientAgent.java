package sma.ia.etour.agent;

import java.util.List;
import java.util.Vector;

import sma.ia.etour.behaviour.client.AcceptProposalClient;
import sma.ia.etour.behaviour.client.ReceiveInfosClient;
import sma.ia.etour.behaviour.client.SendRequestClient;
import sma.ia.etour.gui.ClientGui;
import sma.ia.etour.ontology.Requirements;
import jade.core.AID;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class ClientAgent extends Agent {

	private ClientGui myGui;
	private Requirements requirements = null;

	private List<AID> brokerAgents = new Vector<AID>();

	protected void setup() {

		myGui = new ClientGui(this);
		myGui.showGui();
		
		// Imprimer un message de bienvenue
		String[] args = (String[]) getArguments();
		String str = "Salut! Agent - client: " + getAID().getName()
				+ "est pret.";
		this.getMyGui().returnInformTour(str);
		System.out.println(str);
		
		DFAgentDescription dfd = new DFAgentDescription();
		dfd.setName(getAID());

		ServiceDescription sd = new ServiceDescription();
		sd.setType("Client");
		sd.setName("CLIENT");
		dfd.addServices(sd);

		try {
			DFService.register(this, dfd);
		} catch (FIPAException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void sendRequest(Requirements requirements){
		requirements.setClientAgent(getAID());
		addBehaviour(new SendRequestClient(requirements));
		addBehaviour(new ReceiveInfosClient(this));		
	}
	
	public void acceptProposal(){
		addBehaviour(new AcceptProposalClient(this));
	}

	public Requirements getRequirements() {
		return requirements;
	}

	public void setRequirements(Requirements requirements) {
		this.requirements = requirements;
	}

	public List<AID> getBrokerAgents() {
		return brokerAgents;
	}

	public void setBrokerAgents(List<AID> brokerAgents) {
		this.brokerAgents = brokerAgents;
	}

	public ClientGui getMyGui() {
		return myGui;
	}

	public void setMyGui(ClientGui myGui) {
		this.myGui = myGui;
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
