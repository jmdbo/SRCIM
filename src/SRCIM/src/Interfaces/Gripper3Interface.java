/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Common.Utilities;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import ResourceAgent.ResourceHardwareInterface;
import jade.core.Agent;

/**
 *
 * @author Andre Dionisio Rocha
 */
public class Gripper3Interface implements ResourceHardwareInterface {

    //Local Variables
    private boolean achieved = false;

    @Override
    public boolean updateHW(Object[] parameters) {
        return true;
    }

    @Override
    public ArrayList<String> getSkills() {
        ArrayList<String> listOfSkills = new ArrayList<>();
        listOfSkills.add(Utilities.Gripper3Close);
        listOfSkills.add(Utilities.Gripper3Open);
        return listOfSkills;
    }

    @Override
    public void initHardware(Object[] parameters) {
        return;
    }

    @Override
    public boolean executeSkill(Agent agent, String skill, ResourceHardwareInterface hardware) {
        achieved = false;
        try {
            //First Parameter -> Skill to execute
            System.out.println("Connecting to Server: localhost on Port: 4444");
            Socket client = new Socket("127.0.0.1", 4444);
            System.out.println("Just connected to " + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);
            out.writeUTF(skill);
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            System.out.println("Server says " + in.readUTF());
            client.close();
        } catch (IOException ex) {
            Logger.getLogger(Gripper3Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
        achieved = true;
        return true;
    }

    @Override
    public boolean executionFinished() {
        boolean toReturn = false;
        if (achieved) {
            achieved = false;
            toReturn = true;
        }
        return toReturn;
    }
}
