/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;

/**
 *
 * @author
 * André
 */
public class DFInteraction {

    public static void RegisterInDF(Agent myAgent, String name, String type) throws FIPAException {
        //Aula 1
        DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(myAgent.getAID());
        ServiceDescription sd = new ServiceDescription();
        sd.setType(type);
        sd.setName(name);
        dfd.addServices(sd);
        DFService.register(myAgent, dfd);
    }

    public static DFAgentDescription[] SearchInDFbyType(String type, Agent myAgent) throws FIPAException {
        //Aula 1
        DFAgentDescription dfd = new DFAgentDescription();
        ServiceDescription sd = new ServiceDescription();
        sd.setType(type);
        dfd.addServices(sd);
        return DFService.search(myAgent, dfd);
    }
    
    public static DFAgentDescription[] SearchInDFbyName(String name, Agent myAgent) throws FIPAException{
        //Aula 1
        DFAgentDescription dfd = new DFAgentDescription();
        ServiceDescription sd = new ServiceDescription();
        sd.setName(name);
        dfd.addServices(sd);
        return DFService.search(myAgent, dfd);
    }

    public static boolean DeregisterFromDF(Agent myAgent) throws FIPAException {
        //Aula 1
        DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(myAgent.getAID());
        DFService.deregister(myAgent, dfd);
        ServiceDescription sd = new ServiceDescription();
        sd.setName(myAgent.getName());
        dfd.addServices(sd);
        if(DFService.search(myAgent, dfd) == null){
            return true;
        }else return false;
        
    }
}
