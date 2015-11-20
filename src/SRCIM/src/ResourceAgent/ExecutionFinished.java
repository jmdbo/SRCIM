/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResourceAgent;

import jade.core.behaviours.DataStore;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;

/**
 *
 * @author João
 */
public class ExecutionFinished extends SimpleBehaviour{
    
    protected ACLMessage request;
    protected ACLMessage response;
    private boolean done, skillExecuted, executionResult;
    private DataStore ds;
    private String RESULT_NOTIFICATION_KEY;
    

    public ExecutionFinished(ACLMessage request, ACLMessage response, String RESULT_NOTIFICATION_KEY){
        this.request = request;
        this.response = response;
        this.ds = getDataStore();
        this.RESULT_NOTIFICATION_KEY = RESULT_NOTIFICATION_KEY;
        done = false;
        skillExecuted = false;
        
        
    }
    
    @Override
    public void action() {
        String query, requester;
        ACLMessage msg;
        query = request.getContent();
        requester = request.getSender().getLocalName();
        if(!skillExecuted){
            executionResult = ((ResourceAgent)myAgent).executeSkill(request.getContent(), request.getSender().getLocalName());
            skillExecuted = true;
        }
        if(!executionResult){
           done = true;
           msg = request.createReply();
           msg.setPerformative(ACLMessage.FAILURE);
           ds.put(RESULT_NOTIFICATION_KEY, msg);
        }
        
        if(executionResult && ((ResourceAgent)myAgent).executionFinished(query, requester)){
            msg = request.createReply();
            msg.setPerformative(ACLMessage.INFORM);
            System.out.println("End of Execution Detected");
            ds.put(RESULT_NOTIFICATION_KEY, msg);
            myAgent.send(msg);
            done = true;
        }
    }

    @Override
    public boolean done() {
        return done;
    }
    
}
