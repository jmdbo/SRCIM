/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResourceAgent;

import jade.core.Agent;
import jade.domain.FIPAAgentManagement.FailureException;
import jade.domain.FIPAAgentManagement.NotUnderstoodException;
import jade.domain.FIPAAgentManagement.RefuseException;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.proto.ContractNetResponder;

/**
 *
 * @author André
 */
public class NegotiationResponder extends ContractNetResponder {
    

    
    public NegotiationResponder(Agent a, MessageTemplate mt) {
        super(a, mt);
        
    }
    
    @Override
    protected ACLMessage handleCfp(ACLMessage cfp) throws RefuseException, FailureException, NotUnderstoodException{
        ACLMessage msg = cfp.createReply();
        msg.setPerformative(ACLMessage.PROPOSE);
        msg.setContent("ResourceSkillProposal");//definir skills
        return msg;
    }
    
    @Override
    protected ACLMessage handleAcceptProposal(ACLMessage cfp, ACLMessage propose, ACLMessage accept) throws FailureException{
        
        ACLMessage msg = cfp.createReply();
        msg.setPerformative(ACLMessage.INFORM);
        return msg;
    }
}
