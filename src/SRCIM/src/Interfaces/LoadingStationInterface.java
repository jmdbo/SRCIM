package Interfaces;

import Common.Utilities;
import ResourceAgent.ResourceHardwareInterface;
import ResourceAgent.SendCommand;
import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Andre Dionisio Rocha
 */
public class LoadingStationInterface implements ResourceHardwareInterface {

    public boolean sensorState = false;

    private ACLMessage createHWMessage(AID receiver, String skill) {
        ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
        msg.setOntology("HW");
        msg.setContent(skill);
        msg.addReceiver(receiver);
        return msg;
    }

    @Override
    public boolean updateHW(Object[] parameters) {
        sensorState = (boolean) parameters[0];
        return sensorState;
    }

    @Override
    public ArrayList<String> getSkills() {
        ArrayList<String> lStationSkills = new ArrayList<>();
        Collections.addAll(lStationSkills,
                Utilities.TableToPickPosition, Utilities.TableToPlacePosition,
                Utilities.UnlockTableToPickPosition, Utilities.UnlockTableToPlacePosition);
        return lStationSkills;
    }

    @Override
    public void initHardware(Object[] parameters) {
        return;
    }

    @Override
    public boolean executeSkill(Agent agent, String skill, ResourceHardwareInterface hardware) {
        agent.addBehaviour(new SendCommand(agent, createHWMessage(Utilities.festo_cell, skill), skill, hardware));
        return true;
    }

    @Override
    public boolean executionFinished() {
        if (sensorState) {
            sensorState = false;
            return true;
        } else {
            return false;
        }
    }

}
