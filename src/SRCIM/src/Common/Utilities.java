/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import jade.core.AID;
import java.util.ArrayList;

/**
 *
 * @author Andre Dionisio Rocha
 */
public class Utilities {
    
    //MODE
    public static final boolean mode = true;

    //Atomic Skills
    //Elrest controller
    public static final String TableToPlacePosition = "TTPP";
    public static final String UnlockTableToPlacePosition = "UTTPP";
    public static final String TableToPickPosition = "TTPiP";
    public static final String UnlockTableToPickPosition = "UTTPiP";
    public static final String OpenGripper1 = "OG1";
    public static final String CloseGripper1 = "CG1";
    public static final String VaccuumGripperOn = "VGO";
    public static final String VaccuumGripperOff = "VGOFF";
    public static final String HorizontalCylinderFront = "HCF";
    public static final String UnlockHorizontalCylinderFront = "UHCF";
    public static final String HorizontalCylinderBack = "HCB";
    public static final String UnlockHorizontalCylinderBack = "UHCB";
    public static final String VacuumGripperDown = "VGD";
    public static final String VacuumGripperUp = "VGU";
    public static final String VacuumGripperToRoom = "VGTW";
    public static final String VacuumGripperToWall = "VGTR";
    public static final String VacuumGripperMiddleBreakOn = "VGBO";
    public static final String VacuumGripperMiddleBreakOff = "VGMBOFF";
    public static final String CylinderG2Down = "CG2D";
    public static final String CylinderG2DUp = "CG2U";
    public static final String UserPlaceOnTable = "UPOT";
    //DPWS PLC
    public static final String Cylinder3Up = "C3U";
    public static final String Cylinder3Down = "C3D";
    public static final String Rotate3Left = "RL";
    public static final String Rotate3Right = "RR";
    public static final String Gripper3Close = "GP";
    public static final String Gripper3Open = "GO";

    //AID
    public static AID festo_cell = new AID("FESTO_UNINOVA", false);
    
    /**
     *
     * @param agentType
     * @return
     */
    public static ArrayList<String> createProductionList(String agentType){
        ArrayList<String> productionOrder = new ArrayList();
        
        if(agentType.equals(ProductAgent.ProductAgent.class.toString())){
            productionOrder.add(Common.Utilities.UnlockTableToPlacePosition);
//            productionOrder.add(Common.Utilities.UnlockTableToPickPosition);
//            productionOrder.add(Common.Utilities.TableToPlacePosition);
//            productionOrder.add(Common.Utilities.UserPlaceOnTable);
//            productionOrder.add(Common.Utilities.UnlockTableToPlacePosition);
//            productionOrder.add(Common.Utilities.TableToPickPosition);
//            productionOrder.add(Common.Utilities.OpenGripper1);
//            productionOrder.add(Common.Utilities.CylinderG2Down);
            productionOrder.add(Common.Utilities.CloseGripper1);
//            productionOrder.add(Common.Utilities.CylinderG2DUp);
//            productionOrder.add(Common.Utilities.UnlockTableToPickPosition);
//            productionOrder.add(Common.Utilities.TableToPlacePosition);
//            productionOrder.add(Common.Utilities.CylinderG2Down);
//            productionOrder.add(Common.Utilities.OpenGripper1);
//            productionOrder.add(Common.Utilities.CylinderG2DUp);
//            productionOrder.add(Common.Utilities.CloseGripper1);
//            productionOrder.add(Common.Utilities.UnlockTableToPlacePosition);
//            productionOrder.add(Common.Utilities.VacuumGripperDown);
//            productionOrder.add(Common.Utilities.VaccuumGripperOn);
//            productionOrder.add(Common.Utilities.VacuumGripperUp);
//            productionOrder.add(Common.Utilities.VacuumGripperToWall);
//            productionOrder.add(Common.Utilities.UnlockHorizontalCylinderFront);
//            productionOrder.add(Common.Utilities.UnlockHorizontalCylinderBack);
//            productionOrder.add(Common.Utilities.HorizontalCylinderFront);
//            productionOrder.add(Common.Utilities.VacuumGripperDown);
//            productionOrder.add(Common.Utilities.VaccuumGripperOff);
//            productionOrder.add(Common.Utilities.VacuumGripperUp);
//            productionOrder.add(Common.Utilities.VacuumGripperToRoom);
//            productionOrder.add(Common.Utilities.UnlockHorizontalCylinderFront);
//            productionOrder.add(Common.Utilities.HorizontalCylinderBack);
//            productionOrder.add(Common.Utilities.Rotate3Left);
//            productionOrder.add(Common.Utilities.Gripper3Open);
//            productionOrder.add(Common.Utilities.Cylinder3Down);
//            productionOrder.add(Common.Utilities.Gripper3Close);
//            productionOrder.add(Common.Utilities.Cylinder3Up);
//            productionOrder.add(Common.Utilities.UnlockHorizontalCylinderBack);
//            productionOrder.add(Common.Utilities.HorizontalCylinderFront);
//            productionOrder.add(Common.Utilities.Rotate3Right);
//            productionOrder.add(Common.Utilities.Gripper3Open);
//            productionOrder.add(Common.Utilities.UnlockHorizontalCylinderFront);
        }
        
        return productionOrder;
    }

}
