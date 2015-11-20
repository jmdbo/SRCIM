/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductAgent;

import Common.Constants;
import Common.DFInteraction;
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
    
    protected ACLMessage msgCFP;
    protected ACLMessage msgFR;
    
    @Override
    protected void setup(){
        productionOrder = new ArrayList<>();
        msgCFP = new ACLMessage(ACLMessage.CFP);
        try {
            DFInteraction.RegisterInDF(this, this.getLocalName(), Constants.DF_SERVICE_PRODUCT);
            createProductionOrder();            
            if(!productionOrder.isEmpty()){
                SequentialBehaviour sb = new SequentialBehaviour();
                sb.addSubBehaviour(new HasNextBehaviour(this));
                this.addBehaviour(sb);
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
    
    
    private void createProductionOrder(){
        productionOrder.add(Common.Utilities.UnlockTableToPlacePosition);
        productionOrder.add(Common.Utilities.UnlockTableToPickPosition);
        productionOrder.add(Common.Utilities.TableToPlacePosition);
        productionOrder.add(Common.Utilities.UserPlaceOnTable);
        productionOrder.add(Common.Utilities.UnlockTableToPlacePosition);
        productionOrder.add(Common.Utilities.TableToPickPosition);
        productionOrder.add(Common.Utilities.OpenGripper1);
        productionOrder.add(Common.Utilities.CylinderG2Down);
        productionOrder.add(Common.Utilities.CloseGripper1);
        productionOrder.add(Common.Utilities.CylinderG2DUp);
        productionOrder.add(Common.Utilities.UnlockTableToPickPosition);
        productionOrder.add(Common.Utilities.TableToPlacePosition);
        productionOrder.add(Common.Utilities.CylinderG2Down);
        productionOrder.add(Common.Utilities.OpenGripper1);
        productionOrder.add(Common.Utilities.CylinderG2DUp);
        productionOrder.add(Common.Utilities.CloseGripper1);
        productionOrder.add(Common.Utilities.UnlockTableToPlacePosition);
        productionOrder.add(Common.Utilities.VacuumGripperDown);
        productionOrder.add(Common.Utilities.VaccuumGripperOn);
        productionOrder.add(Common.Utilities.VacuumGripperUp);
        productionOrder.add(Common.Utilities.VacuumGripperToWall);
        productionOrder.add(Common.Utilities.UnlockHorizontalCylinderFront);
        productionOrder.add(Common.Utilities.UnlockHorizontalCylinderBack);
        productionOrder.add(Common.Utilities.HorizontalCylinderFront);
        productionOrder.add(Common.Utilities.VacuumGripperDown);
        productionOrder.add(Common.Utilities.VaccuumGripperOff);
        productionOrder.add(Common.Utilities.VacuumGripperUp);
        productionOrder.add(Common.Utilities.VacuumGripperToRoom);
        productionOrder.add(Common.Utilities.UnlockHorizontalCylinderFront);
        productionOrder.add(Common.Utilities.HorizontalCylinderBack);
        productionOrder.add(Common.Utilities.Rotate3Left);
        productionOrder.add(Common.Utilities.Gripper3Open);
        productionOrder.add(Common.Utilities.Cylinder3Down);
        productionOrder.add(Common.Utilities.Gripper3Close);
        productionOrder.add(Common.Utilities.Cylinder3Up);
        productionOrder.add(Common.Utilities.UnlockHorizontalCylinderBack);
        productionOrder.add(Common.Utilities.HorizontalCylinderFront);
        productionOrder.add(Common.Utilities.Rotate3Right);
        productionOrder.add(Common.Utilities.Gripper3Open);
        productionOrder.add(Common.Utilities.UnlockHorizontalCylinderFront);
    }
}
