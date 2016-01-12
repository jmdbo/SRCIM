/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserAgent;

import jade.core.Agent;
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
    
    public RequestRResponder(Agent a, MessageTemplate mt){
        super(a,mt);
    }
    
    @Override
    protected ACLMessage handleRequest(ACLMessage request) throws NotUnderstoodException, RefuseException{
        ACLMessage msg = request.createReply();
        if(((UserAgent)myAgent).negociatedAgents.contains(request.getSender()) && 
                ((UserAgent)myAgent).resourceSkills.contains(request.getContent())){
            msg.setPerformative(ACLMessage.AGREE);
            msg.setContent(request.getContent());
            registerPrepareResultNotification(new ExecutionFinished(request, msg, this.RESULT_NOTIFICATION_KEY));
        }else{
            msg.setPerformative(ACLMessage.REFUSE);
        }
        return msg;
    }
}