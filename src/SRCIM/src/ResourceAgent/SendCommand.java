/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ResourceAgent;

import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import jade.proto.AchieveREInitiator;

/**
 *
 * @author Andre Dionisio Rocha
 */
public class SendCommand extends AchieveREInitiator{
    private String command;
    private ResourceHardwareInterface hardware;
    
    public SendCommand(Agent a, ACLMessage msg, String command, ResourceHardwareInterface hardware) {
        super(a, msg);
        this.command = command;
        this.hardware = hardware;
    }
    
    @Override
    protected void handleAgree(ACLMessage agree) {
        System.out.println("Got Agree in reply to " + command);
    }

    @Override
    protected void handleInform(ACLMessage inform) {
        Object[] parameters = new Object[1];
        parameters[0]=true;
        hardware.updateHW(parameters);
        System.out.println("Got Inform in reply to the command: " + command);
    }
}
