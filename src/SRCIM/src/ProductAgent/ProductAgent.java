/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductAgent;

import Common.Constants;
import Common.DFInteraction;
import Common.Utilities;
import ResourceAgent.ResourceAgent;
import jade.core.Agent;
import jade.core.behaviours.SequentialBehaviour;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author João
 */
public class ProductAgent extends Agent {
    
    protected ArrayList<String> productionOrder;
    
    protected ACLMessage msgCFP = new ACLMessage(ACLMessage.CFP);
    protected ACLMessage msgFR = new ACLMessage(ACLMessage.REQUEST);
    
    @Override
    protected void setup(){
        productionOrder = new ArrayList<>();
        try {
            DFInteraction.RegisterInDF(this, this.getLocalName(), Constants.DF_SERVICE_PRODUCT);
            productionOrder = Utilities.createProductionList(this.getClass().toString(), this.getLocalName());            
            if(!productionOrder.isEmpty()){
                this.addBehaviour(new HasNextBehaviour(this));
            }else
            {
                this.doDelete();
            }
        } catch (FIPAException ex) {
            Logger.getLogger(ResourceAgent.class.getName()).log(Level.SEVERE, null, ex);
            this.doDelete();
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
}
