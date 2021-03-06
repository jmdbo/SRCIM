/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simulation;

import Common.Utilities;
import jade.wrapper.StaleProxyException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;

/**
 *
 * @author Andre Dionisio Rocha
 */
public class SRCIM extends javax.swing.JFrame {

    /**
     * Creates new form SRCIM
     *
     * @throws jade.wrapper.StaleProxyException
     */
    String mode;

    public SRCIM() throws StaleProxyException {
        initComponents();
        //start Multiagent Platform
        Runtime rt = Runtime.instance();
        rt.setCloseVM(true);

        // Creation of a new main container
        Profile p = new ProfileImpl();
        p.setParameter(Profile.MAIN_HOST, "localhost");
        p.setParameter(Profile.MAIN_PORT, "1099");
        AgentContainer ac = rt.createMainContainer(p);

        AgentController rma = ac.createNewAgent("rma", "jade.tools.rma.rma", null);
        rma.start();

        launchResources();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaExecution = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaFinished = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SRCIM Simulator");

        jTextAreaExecution.setColumns(20);
        jTextAreaExecution.setRows(5);
        jScrollPane1.setViewportView(jTextAreaExecution);

        jLabel2.setText("Time");

        jLabel3.setText("Skill");

        jLabel4.setText("Executor");

        jLabel5.setText("Requester");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Requests");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Finished");

        jLabel8.setText("Time");

        jLabel9.setText("Skill");

        jLabel10.setText("Executor");

        jLabel11.setText("Requester");

        jTextAreaFinished.setColumns(20);
        jTextAreaFinished.setRows(5);
        jScrollPane2.setViewportView(jTextAreaFinished);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 721, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 716, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 716, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SRCIM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SRCIM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SRCIM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SRCIM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new SRCIM().setVisible(true);
                } catch (StaleProxyException ex) {
                    Logger.getLogger(SRCIM.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    private static String getCurrentTime() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(cal.getTime());
    }

    public static void insertExecutionEntrance(String skill, String executor, String requester) {
        jTextAreaExecution.append(getCurrentTime() + "\t\t" + skill + "\t\t" + executor + "\t\t" + requester + "\n");
    }

    public static void insertFinishedEntrance(String skill, String executor, String requester) {
        jTextAreaFinished.append(getCurrentTime() + "\t\t" + skill + "\t\t" + executor + "\t\t" + requester + "\n");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private static javax.swing.JTextArea jTextAreaExecution;
    private static javax.swing.JTextArea jTextAreaFinished;
    // End of variables declaration//GEN-END:variables

    private void launchResources() throws StaleProxyException {
        if (Utilities.mode) {
            mode = "true";
        } else {
            mode = "false";
        }

        Runtime runtime = jade.core.Runtime.instance();
        AgentContainer container = runtime.createAgentContainer(new ProfileImpl());
        
        
        //LoadingStation
        AgentController ls = container.createNewAgent("LoadingStation", "ResourceAgent.ResourceAgent", new Object[]{mode});
        ls.start();
        //LoadingStation
        AgentController ls2 = container.createNewAgent("LoadingStation1", "ResourceAgent.ResourceAgent", new Object[]{mode});
        //ls2.start();
        //Gripper1
        AgentController g1 = container.createNewAgent("Gripper1", "ResourceAgent.ResourceAgent", new Object[]{mode});
        g1.start();
        //Gripper2
        AgentController g2 = container.createNewAgent("Gripper2", "ResourceAgent.ResourceAgent", new Object[]{mode});
        g2.start();
        //Gripper3
        AgentController g3 = container.createNewAgent("Gripper3", "ResourceAgent.ResourceAgent", new Object[]{mode});
        g3.start();
        //Horizontal2
        AgentController h2 = container.createNewAgent("Horizontal2", "ResourceAgent.ResourceAgent", new Object[]{mode});
        h2.start();
        //Horizontal3
        AgentController h3 = container.createNewAgent("Horizontal3", "ResourceAgent.ResourceAgent", new Object[]{mode});
        h3.start();
        //Vertical1
        AgentController v1 = container.createNewAgent("Vertical1", "ResourceAgent.ResourceAgent", new Object[]{mode});
        v1.start();
        //Vertical2
        AgentController v2 = container.createNewAgent("Vertical2", "ResourceAgent.ResourceAgent", new Object[]{mode});
        v2.start();
        //Vertical3
        AgentController v3 = container.createNewAgent("Vertical3", "ResourceAgent.ResourceAgent", new Object[]{mode});
        v3.start();
        //Rotate3
        AgentController r3 = container.createNewAgent("Rotate3", "ResourceAgent.ResourceAgent", new Object[]{mode});
        r3.start();
        //UserAgent
        AgentController ua1 = container.createNewAgent("User1", "UserAgent.UserAgent", new Object[]{mode, this});
        ua1.start();
        //ConveyorToPos2CLA
        AgentController cla1 = container.createNewAgent("ConveyorToPos2CLA", "CoalitionLeaderAgent.CoalitionLeaderAgent", new Object[]{mode});
        cla1.start();
        //EntryToConveyorCLA
        AgentController cla2 = container.createNewAgent("EntryToConveyorCLA", "CoalitionLeaderAgent.CoalitionLeaderAgent", new Object[]{mode});
        cla2.start();
        //Pos2ToDepositCLA
        AgentController cla3 = container.createNewAgent("Pos2ToDepositCLA", "CoalitionLeaderAgent.CoalitionLeaderAgent", new Object[]{mode});
        cla3.start();
        //Product 1
        AgentController p1 = container.createNewAgent("Product1", "ProductAgent.ProductAgent", new Object[]{mode});
        p1.start();
    }
}
