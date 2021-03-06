/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CoalitionLeaderAgent;

import jade.core.AID;
import jade.core.Agent;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.lang.acl.ACLMessage;
import jade.proto.ContractNetInitiator;
import java.util.Vector;

/**
 *
 * @author João
 */
public class NegotiationInitiator extends ContractNetInitiator {
    
    

    public NegotiationInitiator(Agent a, ACLMessage cfp) {
        super(a, cfp);        
    }
    /*
    public static ACLMessage BuildMessage(DFAgentDescription[] receivers){
        ACLMessage msg = new ACLMessage(ACLMessage.CFP);
        for(DFAgentDescription receiver: receivers){
            msg.addReceiver(receiver.getName());
        }        
        msg.setOntology(Common.Constants.ONTOLOGY_NEGOTIATE_SKILL);
        return msg;
    }
    */
    @Override
    protected void handleAllResponses(Vector responses, Vector acceptances){
        int minCost = Integer.MAX_VALUE;
        int acceptCount = 0;
        AID bestSender = new AID();
        int msgCost;
        for(Object obj : responses){
            ACLMessage msg = (ACLMessage) obj;
            msgCost = Integer.parseInt(msg.getContent());
            if(msg.getPerformative() == ACLMessage.PROPOSE){ 
                acceptCount++;
                if(msgCost < minCost){
                    minCost = msgCost;
                    bestSender = msg.getSender();
                }
            }
        }
        for(Object obj : responses){
            ACLMessage msg = (ACLMessage) obj;
            if(msg.getSender() == bestSender){
                ACLMessage reply = msg.createReply();
                reply.setPerformative(ACLMessage.ACCEPT_PROPOSAL);
                acceptances.add(reply);
                ((CoalitionLeaderAgent)myAgent).msgFR.addReceiver(msg.getSender());
                ((CoalitionLeaderAgent)myAgent).msgFR.setOntology(Common.Constants.ONTOLOGY_REQUEST_SKILL);
                ((CoalitionLeaderAgent)myAgent).msgFR.setContent(((CoalitionLeaderAgent)myAgent).msgCFP.getContent());
                System.out.println("FR content:" + ((CoalitionLeaderAgent)myAgent).msgFR.getContent());
            }else{
                ACLMessage reply = msg.createReply();
                reply.setPerformative(ACLMessage.REJECT_PROPOSAL);
                acceptances.add(reply);
            }
            
        }
        if(acceptCount==0){
            ((CoalitionLeaderAgent)myAgent).productionOrder.clear();
            
        }
        
    }
    //Result notifications
    @Override
    protected void handleAllResultNotifications(Vector resultNotifications){
        super.handleAllResultNotifications(resultNotifications);
        System.out.println(myAgent.getLocalName() + " : All Notifications Received");
    }
    
    @Override
    protected void handleInform(ACLMessage inform){
        System.out.println(myAgent.getLocalName() + " : INFORM message Received content: " + inform.getContent());
    }
    
    @Override
    protected void handlePropose(ACLMessage propose, Vector acceptances){
        System.out.println(myAgent.getLocalName() + " : PROPOSAL message Received from: " + propose.getSender().getName());
    }
    
    @Override
    protected void handleRefuse(ACLMessage refuse){        
        System.out.println(myAgent.getLocalName() + " : REFUSE message Received");
    }
    
    
}
