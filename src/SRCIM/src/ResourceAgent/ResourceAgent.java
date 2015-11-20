/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResourceAgent;

import Common.Constants;
import jade.core.Agent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import jade.lang.acl.MessageTemplate;
import Common.DFInteraction;
import jade.core.AID;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;

/**
 *
 * @author Andre Dionisio Rocha
 */
public class ResourceAgent extends Agent {

    private boolean simulation;
    protected ResourceHardwareInterface hardware;
    protected ArrayList<String> resourceSkills;
    protected ArrayList<AID> negociatedAgents;
    String hardwareLibrary;
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
            hardwareLibrary = this.getLocalName() + "Interface";

            //Load low level lib
            Class cls = Class.forName("Interfaces." + hardwareLibrary);
            Object instance = cls.newInstance();
            hardware = (ResourceHardwareInterface) instance;
            hardware.initHardware(null);
            resourceSkills = hardware.getSkills();
            try {
                DFInteraction.RegisterInDF(this, this.getLocalName(), resourceSkills);
            } catch (FIPAException ex) {
                Logger.getLogger(ResourceAgent.class.getName()).log(Level.SEVERE, null, ex);
            }                            
            this.addBehaviour(new NegotiationResponder(this,MessageTemplate.MatchOntology(Constants.ONTOLOGY_NEGOTIATE_SKILL)));
            this.addBehaviour(new RequestRResponder(this,MessageTemplate.MatchOntology(Constants.ONTOLOGY_REQUEST_SKILL)));
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(ResourceAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected void takeDown(){
        try {
            DFInteraction.DeregisterFromDF(this);
        } catch (Exception e) {
             Logger.getLogger(ResourceAgent.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    /*
     This method is called whenever the resource wants to actuate
     */
    protected boolean executeSkill(String skill, String requester) {
        System.out.println("\n" + this.getLocalName() + " executing: " + skill);
        Simulation.SRCIM.insertExecutionEntrance(skill, this.getLocalName(), requester);
        if (!simulation) {
            return hardware.executeSkill(this, skill, hardware);
        }
        return true;
    }

    /*
     This method is called whenever the resource wants to consult if the execution finished
     */
    protected boolean executionFinished(String skill, String requester) {
        if (!simulation) {
            if (hardware.executionFinished()) {
                System.out.println("\n " + this.getLocalName() + " finished: " + skill);
                Simulation.SRCIM.insertFinishedEntrance(skill, this.getLocalName(), requester);
                return true;
            }else{
                return false;
            }
        } else {
            System.out.println("\nesource: " + this.getLocalName() + " finished: " + skill);
            Simulation.SRCIM.insertFinishedEntrance(skill, this.getLocalName(), requester);
            return true;
        }
    }
}
