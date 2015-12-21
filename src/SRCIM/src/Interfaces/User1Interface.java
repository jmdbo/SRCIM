/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import UserAgent.UserInterface;
import jade.core.Agent;
import java.util.ArrayList;

/**
 *
 * @author João
 */
public class User1Interface implements UserInterface{

    @Override
    public ArrayList<String> getSkills() {
        ArrayList<String> skillList = new ArrayList();
        skillList.add(Common.Utilities.UserPlaceOnTable);
        return skillList;
    }
    
}
