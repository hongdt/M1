package rTour.Agents;

import java.io.IOException;
import java.util.ArrayList;

import frame.TransportFrame;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;
import rTour.ontology.Transport;
import tourism.ontology.Vehicle;


public class TransportAgent extends Agent {
	// Le catalogue des services
	private ArrayList<Transport> catalogue;
	private TransportFrame transportGui;

	protected void setup() {
		// Creer le catalogue
		catalogue = new ArrayList<Transport>();
		// Enregistrez le service transport dans les pages jaunes
		DFAgentDescription dfd = new DFAgentDescription();
		dfd.setName(getAID());
		ServiceDescription sd = new ServiceDescription();
		sd.setType("tourism - transport");
		sd.setName("JADE - tourism");

		dfd.addServices(sd);
		try {
			DFService.register(this, dfd);
		} catch (FIPAException fe) {
			// TODO: handle exception
			fe.printStackTrace();
		}

		// Creer les database disponible pour broker agent
		createDataBaseTransport();
		
		addBehaviour(new OfferRequestsServer());
		
		addBehaviour(new PurchaseOrdersServer());
				
		addBehaviour(new NegotiateRequestsSeruver());
		
	}

	private void createDataBaseTransport() {
		// TODO Auto-generated method stub

	}

	// Mettez les operations de nettoyage agents
	protected void takedown() {
		try {
			DFService.deregister(this);
		} catch (FIPAException fe) {
			// TODO: handle exception
			fe.printStackTrace();
		}
		// Fermer le GUI
		transportGui.dipose();
		System.out.println("Transport-agent " + getAID().getName() + " termine.");
	}

	public void updateCatalogue(final Transport transport) {
		addBehaviour(new OneShotBehaviour() {

			@Override
			public void action() {
				// TODO Auto-generated method stub
				transport.setAIDTransport(getAID());
				catalogue.add(transport);
				System.out.println("Transport agent:" + transport.getName() + " a ete ajoute");
			}
		});

	}

	// Comportement repondre les demandes des brokeragents
	private class OfferRequestsServer extends CyclicBehaviour {

		public void action() {
			// TODO Auto-generated method stub
			MessageTemplate mt = MessageTemplate.and(MessageTemplate.MatchPerformative(ACLMessage.CFP),
					MessageTemplate.MatchConversationId("request-transport"));
			ACLMessage msg = myAgent.receive(mt);
			if (msg != null) {
				System.out.println(
						"Transport agent: recu une demande demandant la disponibilite et la liste de prix du courtier");
				// Message recu. traiter
				ACLMessage reply = msg.createReply();
				Transport transport = null;
				try {
					transport = (Transport) msg.getContentObject();
				} catch (UnreadableException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				Transport bestTransport = null;
				// Recherche les transporteur et la qualite de jaune page
				if (transport != null) {
					String start = transport.getBeginning();
					String des = transport.getDestination();
					String quality = transport.getQuality();
					String typeTransport = transport.getTypeTransport();
					int bestPrice = 0;
					for (int i = 0; i < catalogue.size(); i++) {
						Transport t = catalogue.get(i);
						if (((t.getBeginning().contains(start) && t.getDestination().contains(des))
								|| (t.getBeginning().contains(des) && t.getDestination().contains(start)))
								&& t.getQuality().equalsIgnoreCase(quality)
								&& (bestPrice == 0 || bestPrice > t.getPrice())
								&& t.getTypeTransport().equalsIgnoreCase(typeTransport) && t.getNumberFree() > 0) {
							bestTransport = t;
							bestPrice = t.getPrice();
						}
					}
				}
				if (bestTransport.getName() != null) {
					// Le service demande est disponible a la fourni. Repondre
					// avec le prix
					reply.setPerformative(ACLMessage.PROPOSE);
					try {
						reply.setContentObject(bestTransport);
					} catch (IOException e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					System.out.println("Transport agent: envoyer les informations du meilleur transport choisis: ");
					System.out.println("==> Transport:" + bestTransport.getName());
					System.out.println("==> Nombre de places: " + bestTransport.getNumberFree());
					System.out.println("==> Prix:" + bestTransport.getPrice());
				} else {
					System.out.println("Transport agent: remarquer aucun choix que satisfaisant: ");
					reply.setPerformative(ACLMessage.REFUSE);
					reply.setContent("non disponible");
				}
				myAgent.send(reply);
			}
		}

		// Mettre fin de classe
		private class NegotiateRequestsServer extends CyclicBehaviour {
		
			public void action() {
				// TODO Auto-generated method stub
				MessageTemplate mt = MessageTemplate.and(MessageTemplate.MatchPerformative(ACLMessage.REQUEST),
						MessageTemplate.MatchConversationId("request - transport"));
				ACLMessage msg = myAgent.receive(mt);
				if (msg != null) {
					System.out.println(
							"Transport agent: Recu la demande des reduction des cout de: " + msg.getSender().getName());
					ACLMessage reply = msg.createReply();
					Transport transport = null;
					try {
						transport = (Transport) msg.getContentObject();
					} catch (UnreadableException e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					// Recherche les transporteur et la qualite de jaune page
					if (transport != null) {
						int devision = transport.getDeviation();
						int newPrice = transport.getPrice();
						for (int i = 0; i <= catalogue.size(); i++) {
							Transport t = catalogue.get(i);
							if (t.getBeginning().contains(transport.getBeginning())
									&& t.getDestination().contains(transport.getDestination())
									&& t.getQuality().equalsIgnoreCase(transport.getQuality())
									&& t.getName().equalsIgnoreCase(transport.getName())
									&& t.getTypeTransport().equalsIgnoreCase(transport.getTypeTransport())) {
								int price = t.getPrice();
								int diff = (price - newPrice) / 2;
								// Si la reduction de prix est la moitie
								// devision acceptée. sinon le taux sur la
								// demande diminue
								if (diff >= devision / 2) {
									newPrice = price - price * (diff - devision) / 100;
								}
								transport.setPrice(newPrice);
							}
						}
						transport.setPrice(newPrice);
					}
					if (transport != null) {
						System.out.println("Transport agent: acepte la demande des reductions de prix pour "
								+ msg.getSender().getName() + "avec le prix " + transport.getPrice());
						reply.setPerformative(ACLMessage.PROPOSE);
						try {
							reply.setContentObject(transport);
						} catch (IOException e) {
							// TODO: handle exception
							e.printStackTrace();
						}
					} else {
						System.out.println("Transport agent: refuse la demande des reductions de prix pour "
								+ msg.getSender().getName());
						reply.setPerformative(ACLMessage.REFUSE);
						reply.setContent("non - disponible");
					}
					myAgent.send(reply);

				} else
					block();
			}
		}

		// Mettre fin de classe
		
		//Accepter la demande des service et changer l'etat de service
		private class PurchaseOrdersServer extends CyclicBehaviour {
			
			public void action() {
				// TODO Auto-generated method stub
				MessageTemplate mt = MessageTemplate.and(MessageTemplate.MatchPerformative(ACLMessage.ACCEPT_PROPOSAL),
						MessageTemplate.MatchConversationId("request - transport"));
				ACLMessage msg = myAgent.receive(mt);
				if (msg != null) {
					System.out.println("Transport agent: recu une demande demandant la disponibilite et la liste de prix du courtier");
					ACLMessage reply = msg.createReply();
					Transport transport =null;
					try {
						transport = (Transport) msg.getContentObject();
					} catch (UnreadableException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Transport  bestTransport =null;
					if (transport!=null)
					{
						String start = transport.getBeginning();
						String  des = transport.getDestination();
						String quality = transport.getQuality();
						String typeTransport = transport.getTypeTransport();
						int bestPrice=0;
						for (int i=0 ; i<catalogue.size(); i++) {
							Transport t = catalogue.get(i);
							if (((t.getBeginning().contains(transport.getBeginning())
									&& t.getDestination().contains(transport.getDestination()))
									&& t.getQuality().equalsIgnoreCase(quality)
									&& (bestPrice==0 || bestPrice>t.getPrice())
									&& t.getTypeTransport().equalsIgnoreCase(typeTransport)
									&& t.getNumberFree()>0)) {
								bestTransport = t;
								bestPrice = t.getPrice();
							}
						}
					}
					if (bestTransport.getName()!=null) {
						reply.setPerformative(ACLMessage.PROPOSE);
						try {
							reply.setContentObject(bestTransport);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("Transport agent: Envoyer les information du meilleur transport: ");
						System.out.println("==> Transport:"+bestTransport.getName());
						System.out.println("==> Nombre de place: "+bestTransport.getNumberFree());
						System.out.println("==> Prix:"+bestTransport.getPrice());
						
					}
					else {
						System.out.println("Transport agent: remarquer aucun choix que satisfaisant ");
						reply.setPerformative(ACLMessage.REFUSE);
						reply.setContent("non - disposible");	
					}
					myAgent.send(reply);
				}
				else block();
			}
		}
	}
}
