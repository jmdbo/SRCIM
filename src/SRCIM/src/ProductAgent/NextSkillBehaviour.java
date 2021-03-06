/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductAgent;

import Common.DFInteraction;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author João
 */
public class NextSkillBehaviour extends OneShotBehaviour {
    
    private String skill;
    private DFAgentDescription[] skillAgents;
    
    public NextSkillBehaviour(Agent a){
        super(a);
    }

    @Override
    public void action() {
        try {
            System.out.println("NextSkillBehaviour executed by:" + myAgent.getLocalName());
            skill=((ProductAgent)myAgent).productionOrder.get(0);
            ((ProductAgent)myAgent).productionOrder.remove(0);
            skillAgents = DFInteraction.SearchInDFbySkill(skill, myAgent);
            for(DFAgentDescription receiver: skillAgents){
                ((ProductAgent)myAgent).msgCFP.addReceiver(receiver.getName());
            }        
            ((ProductAgent)myAgent).msgCFP.setOntology(Common.Constants.ONTOLOGY_NEGOTIATE_SKILL);            
            ((ProductAgent)myAgent).msgCFP.setContent(skill);
            System.out.println("CFP content:" + ((ProductAgent)myAgent).msgCFP.getContent());
        } catch (FIPAException ex) {
            Logger.getLogger(NextSkillBehaviour.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Override
    public int onEnd(){
        return 3;
    }
}
