/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import CoalitionLeaderAgent.CLAInterface;
import Common.Utilities;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author João
 */
public class EntryToConveyorCLAInterface implements CLAInterface {
    @Override
    public ArrayList<String> getSkills() {
        ArrayList<String> etcclaSkills = new ArrayList<>();
        Collections.addAll(etcclaSkills,
                Utilities.EntryToConveyor);
        return etcclaSkills;
    }
    
    
    @Override
    public ArrayList<String> getProductionList(){
        ArrayList<String> productionOrder = new ArrayList();
        
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
        
        return productionOrder;
    }   
    
}
