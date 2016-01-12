/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CoalitionLeaderAgent;

import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import jade.proto.AchieveREInitiator;

/**
 *
 * @author João
 */
public class RequestRInitiator extends AchieveREInitiator {

    public RequestRInitiator(Agent a, ACLMessage msg) {
        super(a, msg);
    }
        
    @Override
    protected void handleAgree(ACLMessage agree){
        System.out.println(myAgent.getLocalName() + " : AGREE message received");
    }
    
    @Override
    protected void handleFailure(ACLMessage failure){
        System.out.println(myAgent.getLocalName() + " : FAIL message received");
        ((CoalitionLeaderAgent)myAgent).hasFailed = true;
        ((CoalitionLeaderAgent)myAgent).productionOrder.clear();
    }
    
    @Override
    protected void handleRefuse(ACLMessage refuse){
        System.out.println(myAgent.getLocalName() + " : REFUSE message received");
        ((CoalitionLeaderAgent)myAgent).hasFailed = true;
        ((CoalitionLeaderAgent)myAgent).productionOrder.clear();
    }
    
    @Override
    protected void handleInform(ACLMessage inform){
        System.out.println(myAgent.getLocalName() + " : INFORM message received");
    }
    
}
