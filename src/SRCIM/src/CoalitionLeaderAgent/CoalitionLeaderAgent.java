/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CoalitionLeaderAgent;

import Common.Constants;
import Common.DFInteraction;
import Common.Utilities;
import ResourceAgent.ResourceAgent;
import SkillAgent.SkillAgent;
import jade.core.AID;
import jade.core.Agent;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author João
 */
public class CoalitionLeaderAgent extends SkillAgent {
    
    protected ArrayList<String> productionOrder;
    protected ArrayList<AID> negociatedResources;
    
    protected ACLMessage msgCFP;
    protected ACLMessage msgFR;
    
    private boolean hasFinished = true;    
    protected CLAInterface claIF;
    
    protected boolean hasFailed = false;
    
    String claLibrary;
    
    @Override
    protected void setup() {
        try{
            negociatedAgents = new ArrayList();            
            claLibrary = this.getLocalName() + "Interface";

            //Load low level lib
            Class cls = Class.forName("Interfaces." + claLibrary);
            Object instance = cls.newInstance();
            claIF = (CLAInterface) instance;
            resourceSkills = claIF.getSkills();

            try {
                DFInteraction.RegisterInDF(this, this.getLocalName(), resourceSkills);
            } catch (FIPAException ex) {
                Logger.getLogger(ResourceAgent.class.getName()).log(Level.SEVERE, null, ex);
                this.doDelete();
            }
            this.addBehaviour(new NegotiationResponder(this,MessageTemplate.and(MessageTemplate.MatchOntology(Constants.ONTOLOGY_NEGOTIATE_SKILL), MessageTemplate.MatchPerformative(ACLMessage.CFP))));
            this.addBehaviour(new RequestRResponder(this,MessageTemplate.MatchOntology(Constants.ONTOLOGY_REQUEST_SKILL)));
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(ResourceAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected void takeDown() {
        try {
            DFInteraction.DeregisterFromDF(this);
        } catch (Exception e) {
             Logger.getLogger(ResourceAgent.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    /**
     *
     * @param skill
     * @param requester
     * @return boolean
     */
    protected boolean executeSkill (String skill, String requester){
        System.out.println("\n" + this.getLocalName() + " executing CLA: " + skill+ " on request of "+ requester);
        this.hasFinished = false;
        productionOrder = claIF.getProductionList();
        this.addBehaviour(new HasNextBehaviour(this));
        return true;
    }
    
    protected void setExecutionFinished(boolean status){
        this.hasFinished = status;
    }
    
    protected boolean executionFinished(String skill){
        if(hasFinished){
            System.out.println("\n" + this.getLocalName() + " Finished executing CLA: " + skill);
        }                
        return hasFinished;
    }
    
}
