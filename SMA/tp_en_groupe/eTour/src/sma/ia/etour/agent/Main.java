package sma.ia.etour.agent;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.util.ExtendedProperties;
import jade.util.leap.Properties;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;

public class Main {
	public static void main(String[] args) {
		try {
			Runtime rt = Runtime.instance();   
			ProfileImpl profil= new ProfileImpl(false) ;
			AgentContainer container = rt.createAgentContainer(profil);
			AgentController Agent=null ; 
			Agent = container.createNewAgent("Client1", "sma.ia.etour.agent.ClientAgent", null);
			Agent.start();
			
		} catch (ControllerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
