/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CoalitionLeaderAgent;

import jade.core.AID;
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
    
    private CoalitionLeaderAgent CLA;
    
    public NegotiationResponder(Agent a, MessageTemplate mt) {
        super(a, mt);
        this.CLA = (CoalitionLeaderAgent)a;
    }
    
    @Override
    protected ACLMessage handleCfp(ACLMessage cfp) throws RefuseException, FailureException, NotUnderstoodException{
        ACLMessage msg = cfp.createReply();
        if(CLA.resourceSkills.contains(cfp.getContent())){
            msg.setPerformative(ACLMessage.PROPOSE);
        }else{
            msg.setPerformative(ACLMessage.REFUSE);
        }
        msg.setContent(String.valueOf(((CoalitionLeaderAgent)myAgent).negociatedAgents.size()));//Perguntado ao Rocha 17/12/2015 às 15h37
        return msg;
    }
    
    @Override
    protected ACLMessage handleAcceptProposal(ACLMessage cfp, ACLMessage propose, ACLMessage accept) throws FailureException{
        AID sender = cfp.getSender();
        CLA.negociatedAgents.add(sender);
        ACLMessage msg = cfp.createReply();
        msg.setPerformative(ACLMessage.INFORM);
        msg.setContent(cfp.getContent());
        return msg;
    }
}
