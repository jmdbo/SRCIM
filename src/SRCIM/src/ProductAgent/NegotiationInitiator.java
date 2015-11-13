/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductAgent;

import jade.core.Agent;
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
    
    @Override
    protected void handleAllResponses(Vector responses, Vector acceptances){
        super.handleAllResponses(responses, acceptances);
        
    }
    
    @Override
    protected void handleAllResultNotifications(Vector resultNotifications){
        super.handleAllResultNotifications(resultNotifications);
    }
    
    @Override
    protected void handleInform(ACLMessage inform){
        super.handleInform(inform);
    }
    
    @Override
    protected void handlePropose(ACLMessage propose, Vector acceptances){
        super.handlePropose(propose, acceptances);
    }
    
    @Override
    protected void handleRefuse(ACLMessage refuse){
        
    }
    
    
}
