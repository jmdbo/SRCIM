/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductAgent;

import Common.DFInteraction;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.SimpleBehaviour;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAException;
import java.util.ArrayList;
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
            skill=((ProductAgent)myAgent).productionOrder.get(0);
            ((ProductAgent)myAgent).productionOrder.remove(0);
            skillAgents = DFInteraction.SearchInDFbySkill(skill, myAgent);
            ((ProductAgent)myAgent).msgCFP = NegotiationInitiator.BuildMessage(skillAgents);
            ((ProductAgent)myAgent).msgCFP.setContent(skill);
        } catch (FIPAException ex) {
            Logger.getLogger(NextSkillBehaviour.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
