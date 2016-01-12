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
public class ConveyorToPos2CLAInterface implements CLAInterface {
    @Override
    public ArrayList<String> getSkills() {
        ArrayList<String> ctp2claSkills = new ArrayList<>();
        Collections.addAll(ctp2claSkills,Utilities.ConveyorToPos2);
        return ctp2claSkills;
    }
    
    @Override
    public ArrayList<String> getProductionList(){
        ArrayList<String> productionOrder = new ArrayList();
        
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
        
        return productionOrder;
    }   
    
}
