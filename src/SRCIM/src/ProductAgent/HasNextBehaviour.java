/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductAgent;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.SequentialBehaviour;

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
       if(!((ProductAgent)myAgent).productionOrder.isEmpty()){
        SequentialBehaviour sb = new SequentialBehaviour();
        sb.addSubBehaviour(new NextSkillBehaviour(myAgent));
        sb.addSubBehaviour(new NegotiationInitiator(myAgent, ((ProductAgent)myAgent).msgCFP));
        sb.addSubBehaviour(new RequestRInitiator(myAgent, ((ProductAgent)myAgent).msgFR));
        sb.addSubBehaviour(new HasNextBehaviour(myAgent));
        myAgent.addBehaviour(sb);
       }else{
           myAgent.doDelete();
       }
    }
    
}