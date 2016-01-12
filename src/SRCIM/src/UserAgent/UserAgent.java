/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserAgent;

import Common.Constants;
import Common.DFInteraction;
import SkillAgent.SkillAgent;
import jade.domain.FIPAException;
import jade.lang.acl.MessageTemplate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author João
 */
public class UserAgent extends SkillAgent {
    protected java.awt.Frame mainFrame; 
    private boolean simulation;
    protected UserInterface user;
    String userLibrary;
    protected boolean executionDone;
    protected boolean executionResult;
    //Falta lançar os 2 behaviours das comunicações + behaviour para verificar fim + inscrever no DF
    
    @Override
    protected void setup() {
        
        try {
            /*
             Arguments
             [0]->Simulation or not (boolean)
             */
            negociatedAgents = new ArrayList();
            simulation = Boolean.valueOf((String) this.getArguments()[0]);
            mainFrame = (java.awt.Frame) this.getArguments()[1];
            userLibrary = this.getLocalName() + "Interface";

            //Load low level lib
            Class cls = Class.forName("Interfaces." + userLibrary);
            Object instance = cls.newInstance();
            user = (UserInterface) instance;
            resourceSkills = user.getSkills();
            try {
                DFInteraction.RegisterInDF(this, this.getLocalName(), resourceSkills);
            } catch (FIPAException ex) {
                Logger.getLogger(UserAgent.class.getName()).log(Level.SEVERE, null, ex);
            }                            
            this.addBehaviour(new NegotiationResponder(this,MessageTemplate.MatchOntology(Constants.ONTOLOGY_NEGOTIATE_SKILL)));
            this.addBehaviour(new RequestRResponder(this,MessageTemplate.MatchOntology(Constants.ONTOLOGY_REQUEST_SKILL)));
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(UserAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected void takeDown(){
        try {
            DFInteraction.DeregisterFromDF(this);
        } catch (Exception e) {
             Logger.getLogger(UserAgent.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    /*
     This method is called whenever the resource wants to actuate
     */
    protected boolean executeSkill(String skill, String requester) {
        System.out.println("\n" + this.getLocalName() + " executing: " + skill);
        this.executionDone = false;
        this.executionResult = false;
        UserInput dialog = new UserInput(mainFrame, true, this);
        dialog.setVisible(true);
        return true;
    }

    /*
     This method is called whenever the resource wants to consult if the execution finished
     */
    protected boolean executionFinished(String skill, String requester) {
        if (this.executionDone) {
            System.out.println("\n " + this.getLocalName() + " finished: " + skill);
            if(simulation)
                Simulation.SRCIM.insertFinishedEntrance(skill, this.getLocalName(), requester);
            return true;
        }else{
            return false;
        }
   
    }
    
}
