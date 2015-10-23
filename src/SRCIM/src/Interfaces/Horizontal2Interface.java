/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class Horizontal2Interface implements ResourceHardwareInterface {

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
        ArrayList<String> vHAxisSkills = new ArrayList<>();
        Collections.addAll(vHAxisSkills,
                Utilities.VacuumGripperToWall, Utilities.VacuumGripperToRoom);
        return vHAxisSkills;
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
