/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductAgent;

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
       if(!((ProductAgent)myAgent).productionOrder.isEmpty()){
//           FSMBehaviour fsmb = new FSMBehaviour();
//           fsmb.registerFirstState(new NextSkillBehaviour(myAgent), "NextSkill");
//           fsmb.registerState(new NegotiationInitiator(myAgent), "Neg");
//           fsmb.registerState(new RequestRInitiator(myAgent), "Req");
//           fsmb.registerLastState(new HasNextBehaviour(myAgent), "HasNext");
//           
//           fsmb.registerTransition("NextSkill", "Neg", 3);
//           fsmb.registerTransition("Neg", "Req", 1);
//           fsmb.registerTransition("Req", "HasNext", 2);
           ((ProductAgent)myAgent).msgCFP = new ACLMessage(ACLMessage.CFP);
           ((ProductAgent)myAgent).msgFR = new ACLMessage(ACLMessage.REQUEST);
           SequentialBehaviour sb = new SequentialBehaviour();
           sb.addSubBehaviour(new NextSkillBehaviour(myAgent));
           sb.addSubBehaviour(new NegotiationInitiator(myAgent, ((ProductAgent)myAgent).msgCFP));
           sb.addSubBehaviour(new RequestRInitiator(myAgent, ((ProductAgent)myAgent).msgFR));
           sb.addSubBehaviour(new HasNextBehaviour(myAgent));
           myAgent.addBehaviour(sb);
       }else{
           myAgent.doDelete();
           System.out.println("Product Finished!");
       }
    }
    
}
