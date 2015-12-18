/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CoalitionLeaderAgent;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.SequentialBehaviour;
import jade.lang.acl.ACLMessage;


/**
 *
 * @author João
 */
public class HasNextBehaviour extends OneShotBehaviour {
    
    public HasNextBehaviour(Agent a){
        super(a);
    }

    @Override
    public void action() {
       if(!((CoalitionLeaderAgent)myAgent).productionOrder.isEmpty()){
           ((CoalitionLeaderAgent)myAgent).msgCFP = new ACLMessage(ACLMessage.CFP);
           ((CoalitionLeaderAgent)myAgent).msgFR = new ACLMessage(ACLMessage.REQUEST);
           SequentialBehaviour sb = new SequentialBehaviour();
           sb.addSubBehaviour(new NextSkillBehaviour(myAgent));
           sb.addSubBehaviour(new NegotiationInitiator(myAgent, ((CoalitionLeaderAgent)myAgent).msgCFP));
           sb.addSubBehaviour(new RequestRInitiator(myAgent, ((CoalitionLeaderAgent)myAgent).msgFR));
           sb.addSubBehaviour(new HasNextBehaviour(myAgent));
           myAgent.addBehaviour(sb);
       }else{
           ((CoalitionLeaderAgent)myAgent).setExecutionFinished(true);
           System.out.println("CLA skill Finished!");
       }
    }
    
}
