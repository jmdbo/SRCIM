/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CoalitionLeaderAgent;

import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import java.util.ArrayList;

/**
 *
 * @author João
 */
public class CoalitionLeaderAgent extends Agent {
    
    protected ArrayList<String> productionOrder;
    protected ArrayList<AID> negociatedAgents;
    protected ArrayList<AID> negociatedResources;
    
    protected ACLMessage msgCFP;
    protected ACLMessage msgFR;
    
    protected boolean hasFinished = true;    
    
    @Override
    protected void setup() {
        
    }
    
    @Override
    protected void takeDown() {
        
    }
    
    protected boolean executeSkill (String skill, String requester){
        System.out.println("\n" + this.getLocalName() + " executing CLA: " + skill);
        
        
        return true;
    }
    
    protected boolean executionFinished(String skill, String requester){
        
        
        return true;
    }
    
}
