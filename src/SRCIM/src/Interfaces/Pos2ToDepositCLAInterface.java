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
public class Pos2ToDepositCLAInterface implements CLAInterface {
    @Override
    public ArrayList<String> getSkills() {
        ArrayList<String> p2tdclaSkills = new ArrayList<>();
        Collections.addAll(p2tdclaSkills,
                Utilities.Pos2ToDeposit);
        return p2tdclaSkills;
    }
    
    
    @Override
    public ArrayList<String> getProductionList(){
        ArrayList<String> productionOrder = new ArrayList();     
        
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
        
        return productionOrder;
    }   
    
}
