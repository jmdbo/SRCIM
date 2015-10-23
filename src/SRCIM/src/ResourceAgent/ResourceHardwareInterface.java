package ResourceAgent;

import jade.core.Agent;
import java.util.ArrayList;


/**
 *
 * @author Andre Dionisio Rocha
 */
public interface ResourceHardwareInterface {
     
    public boolean executeSkill(Agent agent, String skill, ResourceHardwareInterface hardware);    
    public boolean executionFinished();
    public boolean updateHW(Object[] parameters);
    public ArrayList<String> getSkills();
    public void initHardware(Object[] parameters);
}
