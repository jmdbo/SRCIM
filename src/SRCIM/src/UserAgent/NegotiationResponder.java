/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserAgent;

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
    
    public NegotiationResponder(Agent a, MessageTemplate mt) {
        super(a, mt);
    }
    
    @Override
    protected ACLMessage handleCfp(ACLMessage cfp) throws RefuseException, FailureException, NotUnderstoodException{
        ACLMessage msg = cfp.createReply();
        if(((UserAgent)myAgent).resourceSkills.contains(cfp.getContent())){
            msg.setPerformative(ACLMessage.PROPOSE);
        }else{
            msg.setPerformative(ACLMessage.REFUSE);
        }
        msg.setContent("1");//Perguntar ao ROCHA!!!
        return msg;
    }
    
    @Override
    protected ACLMessage handleAcceptProposal(ACLMessage cfp, ACLMessage propose, ACLMessage accept) throws FailureException{
        AID sender = cfp.getSender();
        if(!((UserAgent)myAgent).negociatedAgents.contains(sender)){
            ((UserAgent)myAgent).negociatedAgents.add(sender);
        }
        ACLMessage msg = cfp.createReply();
        msg.setPerformative(ACLMessage.INFORM);
        msg.setContent(cfp.getContent());
        return msg;
    }
}
