/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.NGO;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.NGOOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.NGOWorkRequest;
import Business.WorkQueue.SalesWorkRequest;
import Business.WorkQueue.WorkRequest;
import UserInterface.SalesPerson.SalesPersonWorkAreaJPanel;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tejas
 */
public class RequestToNGOJPanel extends javax.swing.JPanel {

    /**
     * Creates new form RequestToNGOJPanel
     */
    private JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount userAccount;
    private NGOOrganization ngoOrganization;
    private Enterprise enterprise;
    public RequestToNGOJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, EcoSystem business,Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.business = business;
        this.ngoOrganization = (NGOOrganization)organization;
        this.enterprise  = enterprise;
        populateTable();
    }
    

    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel)workRequestJTable.getModel();
        workRequestJTable.getColumnModel().getColumn(4).setPreferredWidth(270);
        model.setRowCount(0);
         ArrayList<WorkRequest> list = ngoOrganization.getWorkQueue().getWorkRequestList();
        for(int i=0; i<list.size();i++ ){
            NGOWorkRequest request =(NGOWorkRequest) list.get(i);
            Object[] row = new Object[6];
            row[0] = request.getRequestDate();
            row[1] = request.getSender().getEmployee().getName();
            row[2] = request.getTestResult();
            row[3] = request;
            row[4] = request.getAmount();
            row[5] = request.getMessage();
            model.addRow(row);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        refreshJButton = new javax.swing.JButton();
        raiseRequestJButton1 = new javax.swing.JButton();
        processJButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 204));

        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Request Date", "Sender", "Test Result", "Status", "Amount", "Message"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(workRequestJTable);
        if (workRequestJTable.getColumnModel().getColumnCount() > 0) {
            workRequestJTable.getColumnModel().getColumn(3).setResizable(false);
        }

        refreshJButton.setBackground(new java.awt.Color(0, 153, 153));
        refreshJButton.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        refreshJButton.setForeground(new java.awt.Color(255, 255, 255));
        refreshJButton.setText("Refresh");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });

        raiseRequestJButton1.setBackground(new java.awt.Color(0, 153, 153));
        raiseRequestJButton1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        raiseRequestJButton1.setForeground(new java.awt.Color(255, 255, 255));
        raiseRequestJButton1.setText("Raise New Request");
        raiseRequestJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                raiseRequestJButton1ActionPerformed(evt);
            }
        });

        processJButton.setBackground(new java.awt.Color(0, 153, 153));
        processJButton.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        processJButton.setForeground(new java.awt.Color(255, 255, 255));
        processJButton.setText("Process");
        processJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(raiseRequestJButton1)
                        .addGap(18, 18, 18)
                        .addComponent(refreshJButton)
                        .addGap(18, 18, 18)
                        .addComponent(processJButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(processJButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(raiseRequestJButton1)
                        .addComponent(refreshJButton)))
                .addGap(540, 540, 540))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed

        populateTable();
    }//GEN-LAST:event_refreshJButtonActionPerformed

    private void raiseRequestJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_raiseRequestJButton1ActionPerformed
        NGOWorkAreaJPanel ngoJPanel = new NGOWorkAreaJPanel(userProcessContainer,userAccount,ngoOrganization,business);
        userProcessContainer.add("NGOWorkAreaJPanel", ngoJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_raiseRequestJButton1ActionPerformed

    private void processJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processJButtonActionPerformed
        int selectedRow = workRequestJTable.getSelectedRow();
        if (selectedRow < 0){
            return;
        }
        NGOWorkRequest request = (NGOWorkRequest)workRequestJTable.getValueAt(selectedRow, 3);
        if("Completed".equalsIgnoreCase(request.getStatus())){
            JOptionPane.showMessageDialog(null, "Request is already completed");
            return;
        }
        request.setStatus("Completed");
        populateTable();
       
    }//GEN-LAST:event_processJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton processJButton;
    private javax.swing.JButton raiseRequestJButton1;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
