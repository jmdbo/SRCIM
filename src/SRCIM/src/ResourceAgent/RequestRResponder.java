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
import jade.proto.AchieveREResponder;

/**
 *
 * @author André
 */
public class RequestRResponder extends AchieveREResponder {
    
    ResourceAgent RA;
    
    public RequestRResponder(Agent a, MessageTemplate mt){
        super(a,mt);
        this.RA = (ResourceAgent)a;
    }
    @Override
    protected ACLMessage handleRequest(ACLMessage request) throws NotUnderstoodException, RefuseException{
        
        ACLMessage msg = request.createReply();
        if(RA.negociatedAgents.contains(request.getSender())){
            msg.setPerformative(ACLMessage.AGREE);
        }else{
            msg.setPerformative(ACLMessage.REFUSE);
        }
        return msg;
    }
    
    @Override
    protected ACLMessage prepareResultNotification(ACLMessage request, ACLMessage response) throws FailureException{
        String query, requester;
        query = request.getContent();
        requester = request.getSender().getLocalName();
        boolean result = RA.executeSkill(query, requester);
        RA.executionFinished(query, requester);
        ACLMessage msg = request.createReply();
        if(result){
            msg.setPerformative(ACLMessage.INFORM);
        }else{
            msg.setPerformative(ACLMessage.FAILURE);
        }
        return msg;
    }
}