package rTour.Agents;

import java.io.IOException;
import java.util.ArrayList;

import frame.brokerFrame;
import frame.userRequestFrame;
import rTour.ontology.Tourism;
import rTour.ontology.Clients;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;

public class ClientAgent extends Agent {
	private UserRequestFrame myGui;
	private Clients userRequest;
	private int minCost;
	private int maxCost;

	boolean status = true;
	// La liste des agents courtage
	private AID[] brokerAgent;

	// Mettez initialisations d'agent
	protected void setup() {
		String arg[] = (String[]) getArguments();

		// Imprimer un message de bienvenue
		System.out.println("Bonjour! Agent - utilisateur " + getAID().getName() + "est prêt.");

		// Ajouter un comportement Ticker qui planifie une demande au vendeur
		// agents chaque minute
		addBehaviour(new TickerBehaviour(this, 5000) {

			protected void onTick() {
				// TODO Auto-generated method stub

				// TODO Auto-generated method stub
				if (userRequest != null) {
					System.out.println(
							"Essayez reservation du tourisme " + userRequest.getTourism().getAddressDestination());
					DFAgentDescription tmp = new DFAgentDescription();
					ServiceDescription sd = new ServiceDescription();
					sd.setType("Reservation tour ");
					tmp.addServices(sd);
					try {
						DFAgentDescription[] result = DFService.search(myAgent, tmp);
						brokerAgent = new AID[result.length];
						for (int i = 0; i < result.length; ++i) {
							brokerAgent[i] = result[i].getName();
						}
					} catch (FIPAException fe) {
						// TODO: handle exception
						fe.printStackTrace();
					}
					myAgent.addBehaviour(new RequestPerformer());
				} else {
					System.out.println("Agent utilisateur: n'a pas la demande");
				}
			}
		});
	}

	public void requestTourism(Clients u) {
		userRequest = u;
		minCost = u.getMinCost();
		maxCost = u.getMaxCost();
	}

	// Mettez les operations de nettoyage agents
	protected void takeDown() {
		// Printout a dismissal message
		System.out.println("Agents utilisateurs " + getAID().getName() + " termine.");
	}

	/**
	 * Inner class RequestPerformer. Ce comportement est utilise par les agents
	 * utilisateurs de demander.
	 */

	private class RequestPerformer extends Behaviour {
		private AID bestBroker; // L'agent qui fournit la meilleure offre
		private int bestPrice=0;  // Le meilleur prix offert
		private int bestQuality;  // La meilleure qualité offrete
		private int countReplies = 0; // Le compteur des réponses des agents du courtage
		private MessageTemplate mt; // Le modèle pour recevoir des réponses
		private int step = 0;
		private Tourism bestTour = new Tourism();
		public void action() {
			switch (step) {
			case 0:
				
				myGui.returnInformTour("User agent: Envoyer le demande de recherche tour aux courtier");
				System.out.println("User agent: Envoyer le demande de recherche tour aux courtier");
				// Envoyez le cfp aux courtier
				Tourism tourRequest = new Tourism();
				tourRequest = userRequest.getTourism();
				ACLMessage cfp = new ACLMessage(ACLMessage.CFP);
				for (int i = 0; i < brokerAgent.length; ++i) {
					cfp.addReceiver(brokerAgent[i]);
				} 
				try {
					cfp.setContentObject(tourRequest);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				cfp.setConversationId("Reserver tour");
				cfp.setReplyWith("cfp"+System.currentTimeMillis()); // Valeur unique
				myAgent.send(cfp);
				
				// Preparer le modele pour obtenir des propositions
				mt = MessageTemplate.MatchConversationId("resever-tour");
				step = 1;
				break;
			case 1:
				myGui.returnInformTour("User agent: recu les reponses des agents de courtage");
				// Recevoir toutes les propositions / refus des agents de courtage
				ACLMessage reply = myAgent.receive(mt);
				if (reply != null) {
					// Reponse reçue
					if (reply.getPerformative() == ACLMessage.PROPOSE) {
						System.out.println("User agent: A recu les reponses des agents de courtage "+reply.getSender().getName());
						// Ceci est une offre 
						Tourism tour = new Tourism();
						try {
							tour = (Tourism) reply.getContentObject();
						} catch (UnreadableException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if (bestBroker == null || (bestPrice==0||tour.getPrice() < bestPrice)
								||(tour.getPrice() == bestPrice && tour.getQualityInt()<bestQuality)) {
							// This is the best offer at present
							bestPrice = tour.getPrice();
							bestQuality = tour.getQualityInt();
							bestBroker = reply.getSender();
							bestTour = tour;
						}
					}
					countReplies++;
					if (countReplies >= brokerAgent.length) {
						step = 2; 
						myGui.returnInformTour("User agent: a choisi un meilleur tour par criteres ");
						myGui.returnTour(bestTour);
						System.out.print("User agent: a choisi un meilleur tour par criteres de la societe:"+bestTour.getBroker().getName());
						System.out.println("==> Tour:"+bestTour.getNameTour());
						System.out.println("==> Gia:"+bestTour.getPrice());
						System.out.println("==> Chat luong: "+bestTour.getQuality()+" \n");
						
					}	
				}
				else block();
				break;
				
			case 2:
				// Envoyer un demande de reduction des couts de tour 
				Tourism tourSale= new Tourism();
				tourSale = bestTour;
				if (bestPrice > minCost) {
					int newPrice = bestPrice - (bestPrice-minCost)/2;
					if (newPrice > maxCost) {
						newPrice = bestPrice - (bestPrice-maxCost)/2;
					}
					if (newPrice>maxCost) {
						newPrice = maxCost;
						minCost = maxCost;
					}
					else {
						minCost = newPrice;	
					}
					tourSale.setPrice(newPrice);
					myGui.returnInformTour("Les deux parties negocient le prix. Prix de demande des utilisateurs: "+newPrice);
					System.out.print("== User agent: le prix de tour actuel: "+bestPrice+" \n");
					System.out.print("== User agent: demander de reduction le prix "+newPrice+" \n");
					// Envoyez le cfp au meilleur courtier
					ACLMessage cfpSale = new ACLMessage(ACLMessage.REQUEST);
					cfpSale.addReceiver(bestBroker);
					try {
						cfpSale.setContentObject(tourSale);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					cfpSale.setConversationId("sale-tour");
					cfpSale.setReplyWith("requestsale"+System.currentTimeMillis()); // Valeur unique
					myAgent.send(cfpSale);
					// Preparer le modele pour obtenir des propositions
					mt = MessageTemplate.MatchConversationId("sale-tour");
					step = 3;
				}
				else step = 4;
				break;
					
			case 3:
				// Recevoir des propositions / refus des agents de courtage
				ACLMessage repSale = myAgent.receive(mt);
				if (repSale != null) {
					// Reponse reçue
					if (repSale.getPerformative() == ACLMessage.PROPOSE) {
						// Ceci est une offre
						Tourism tour = new Tourism();
						try {
							tour = (Tourism) repSale.getContentObject();
						} catch (UnreadableException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						myGui.returnInformTour("Les deux parties negocient le prix. Prix de reponse des courtier:"+tour.getPrice());
						if (bestPrice == tour.getPrice() && bestPrice > maxCost) {
							step = 6;
						}
						else if ((bestPrice == tour.getPrice() && bestPrice <= maxCost)||(maxCost == minCost)) {
							step = 4;
						}
						else {
							// Ceci est la meilleure offre à l'heure actuelle
							bestPrice = tour.getPrice();
							step = 2;
						}
						System.out.print("User agent: Obtenir la retroaction de prix de tour du courtier : "+tour.getPrice()+" \n");	
					}
				}
				else block();
				break;
				
			case 4:
				myGui.returnInformTour("Les deux parties negocient le prix et commence a reserver un tour:");
				System.out.println("User agent: Les deux parties reussi a negocier le prix, et commence à reserver un tour \n");
				// Envoyer l'ordre d'achat au vendeur qui a fourni la meilleure offre
				ACLMessage order = new ACLMessage(ACLMessage.ACCEPT_PROPOSAL);
				order.addReceiver(bestBroker);
				bestTour.setPrice(bestPrice);
				userRequest.setTourism(bestTour);
				try {
					order.setContentObject(userRequest);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				order.setConversationId("order-tour");
				order.setReplyWith("order"+System.currentTimeMillis());
				myAgent.send(order);
				// Préparer le modèle pour obtenir le bon de commande réponse
				mt = MessageTemplate.MatchConversationId("order-tour");
				step = 5;
				break;
			
			case 5:      
				// Recevoir la reponse
				reply = myAgent.receive(mt);
				if (reply != null) {
					if (reply.getPerformative() == ACLMessage.INFORM) {
						System.out.println("User agent: recu l'anonce de reservation du tour de "+userRequest.getTourism().getAddressDestination()+" reussi de "+reply.getSender().getName());
						System.out.println("==> Price = " + bestPrice);
						myGui.returnInformTour("Reussi à reserver un tour. Les information du tour a reserve:");
						myGui.returnTour(bestTour);
						myAgent.doDelete();
					}
					else {
						System.out.println("User agent: Recu l'anonce de l'echec de reservation du tour \n");
					}

					step = 6;
				}
				else block();
				break;     
			case 6:      
				// La reservation du tour est echec
				System.out.println("User agent: recu l'anonce de reservation du tour de "+userRequest.getTourism().getAddressDestination()+" echec de \n");
				myGui.returnInformTour("Les deux parties ont échoué les négociations. Échec de réservation");
					myAgent.doDelete();
					step = 7;
						break;
		}      
		}

		public boolean done() {
			if (step == 2 && bestBroker == null) {
			//	System.out.println("Attempt failed: "+targetBookTitle+" not available for sale");
			}
			return ((step == 2 && bestBroker == null) || step == 6|| step == 7);
		}
	}  // End of inner class RequestPerformer
	

}

		
