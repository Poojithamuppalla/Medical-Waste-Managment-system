/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.SalesPerson;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.ManufacturingCompanyOrganization;
import Business.Organization.NGOOrganization;
import Business.Organization.SalesOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.DonatingWaste;
import Business.WorkQueue.ManufacturerTestRequest;
import Business.WorkQueue.NGOWorkRequest;
import Business.WorkQueue.RecyclableWaste;
import Business.WorkQueue.SalesWorkRequest;
import Business.WorkQueue.SegregationTestWorkResult;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rishvita
 */
public class SalesPersonWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SalesPersonWorkAreaJPanel
     */
    JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount userAccount;
    private SalesOrganization salesOrganization;
    private SalesWorkRequest request; 
    ArrayList<WorkRequest> result = new ArrayList<>();

    public SalesPersonWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, EcoSystem business,SalesWorkRequest request) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.business = business;
        this.request = request;
        this.salesOrganization = (SalesOrganization)organization;
        result = business.getWorkQueue().getWorkRequestList();
        populateTable();
    }
    
    public void populateTable(){
        
         String wasteType = request.getWasteType();
         jLabel2.setText(wasteType);
         for (int i=0; i<result.size();i++) {
              SegregationTestWorkResult segregationResult = (SegregationTestWorkResult) result.get(i);
           if("Donating Waste".equalsIgnoreCase(wasteType)){ 
              
              DefaultTableModel donatingWasteModel = (DefaultTableModel) wasteJTable.getModel();
              donatingWasteModel.setRowCount(0);
              DonatingWaste donatingWaste = segregationResult.getDonatingWaste();
            if(donatingWaste!=null){
              for(int j=0; j<5; j++){
              Object row[] = new Object[2];
              if(j==0){
              row[0] = "Number Of Beds";
              row[1] = String.valueOf(donatingWaste.getNumberOfBeds())==null?0:donatingWaste.getNumberOfBeds();
              }
              else if(j==1){
              row[0] = "Number Of Wheel chairs";
              row[1] =String.valueOf(donatingWaste.getNumberOfWheelChairs())==null?0:donatingWaste.getNumberOfWheelChairs(); 
              }
              else if(j==2){
              row[0] = "Number Of Bandages";
              row[1] = String.valueOf(donatingWaste.getNumberOfBandages())==null?0:donatingWaste.getNumberOfBandages(); 
              }
              else if(j==3){
              row[0] = "Number Of Thermometers";
              row[1] = String.valueOf(donatingWaste.getNumberOThermometers())==null?0:donatingWaste.getNumberOThermometers(); ;
              }
              else if(j==4){
              row[0] = "Number Of crutches";
              row[1] = String.valueOf(donatingWaste.getNumberOfCrutches())==null?0:donatingWaste.getNumberOfCrutches(); ;
              }
              donatingWasteModel.addRow(row);
              }
            }
           }
           else if("Recyclable Waste".equalsIgnoreCase(wasteType)){ 
              DefaultTableModel model = (DefaultTableModel) wasteJTable.getModel();
              model.setRowCount(0);
              RecyclableWaste recyclableWaste = segregationResult.getRecyclableWaste();
            if(recyclableWaste!=null){
             for(int j=0; j<5; j++){
              Object row[] = new Object[2];
              if(j==0){
              row[0] = "Number Of Syringes";
              row[1] = (String.valueOf(recyclableWaste.getNumberOfSyringes()))==null?0:recyclableWaste.getNumberOfSyringes();
              }
              else if(j==1){
              row[0] = "Number Of Plastic Disposables";
              row[1] = (String.valueOf(recyclableWaste.getNumberOfPlasticDisposables()))==null?0:recyclableWaste.getNumberOfPlasticDisposables();
              }
              else if(j==2){
              row[0] = "Number Of X-Ray Films";
              row[1] = (String.valueOf(recyclableWaste.getNumberOfXRayFilms()))==null?0:recyclableWaste.getNumberOfXRayFilms();
              }
              else if(j==3){
              row[0] = "Number Of Blood Pressure Cuff and Flouroscent Bulb";
              row[1] = (String.valueOf(recyclableWaste.getNumberOfBPCuffAndBulbs()))==null?0:recyclableWaste.getNumberOfBPCuffAndBulbs();
              }
              model.addRow(row);
             }
            }
           }
         }
         if("Recyclable Waste".equals(wasteType)){
             jLabel7.setText("Number Of Syringes");
             jLabel8.setText("Number Of Plastic Disposables");
             jLabel6.setText("Number Of X-Ray Films");
             jLabel5.setText("Number Of BP Cuffs and Bulbs");
             jLabel9.setVisible(false);
             JText5.setVisible(false);
             
            JText1.setText(String.valueOf(request.getRecyclabeWate().getNumberOfSyringes()));
            JText2.setText(String.valueOf(request.getRecyclabeWate().getNumberOfPlasticDisposables()));
            JText3.setText(String.valueOf(request.getRecyclabeWate().getNumberOfXRayFilms()));
            JText4.setText(String.valueOf(request.getRecyclabeWate().getNumberOfBPCuffAndBulbs()));
         }
         else if("Donating Waste".equals(wasteType)){
             jLabel7.setText("Number Of Beds");
             jLabel8.setText("Number Of Wheel chairs");
             jLabel6.setText("Number Of Bandages");
             jLabel5.setText("Number Of Thermometers");
             jLabel9.setVisible(true);
             jLabel9.setText("Number Of Crutches");
             
             
            JText1.setText(String.valueOf(request.getDonatingWaste().getNumberOThermometers()));
            JText2.setText(String.valueOf(request.getDonatingWaste().getNumberOfBandages()));
            JText3.setText(String.valueOf(request.getDonatingWaste().getNumberOfBeds()));
            JText4.setText(String.valueOf(request.getDonatingWaste().getNumberOfWheelChairs()));
            JText5.setVisible(true);
            JText5.setText(String.valueOf(request.getDonatingWaste().getNumberOfCrutches()));
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

        jScrollPane2 = new javax.swing.JScrollPane();
        wasteJTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        JText1 = new javax.swing.JTextField();
        JText2 = new javax.swing.JTextField();
        JText3 = new javax.swing.JTextField();
        JText4 = new javax.swing.JTextField();
        processJButton = new javax.swing.JButton();
        JText5 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 204));

        wasteJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Waste Type", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(wasteJTable);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel2.setText("jLabel2");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel4.setText("Requested Quantity : ");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel5.setText("jLabel1");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel6.setText("jLabel2");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel7.setText("jLabel3");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel8.setText("jLabel4");

        JText1.setEnabled(false);

        JText2.setEnabled(false);

        JText3.setEnabled(false);

        JText4.setEnabled(false);
        JText4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JText4ActionPerformed(evt);
            }
        });

        processJButton.setBackground(new java.awt.Color(0, 153, 153));
        processJButton.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        processJButton.setForeground(new java.awt.Color(255, 255, 255));
        processJButton.setText("Process Request");
        processJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processJButtonActionPerformed(evt);
            }
        });

        JText5.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel9.setText("jLabel5");

        backJButton.setBackground(new java.awt.Color(0, 153, 153));
        backJButton.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        backJButton.setForeground(new java.awt.Color(255, 255, 255));
        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backJButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(700, 700, 700)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(processJButton)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(JText1, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                                        .addComponent(JText2)
                                        .addComponent(JText3)
                                        .addComponent(JText4)
                                        .addComponent(JText5))))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(316, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(backJButton)
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(JText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(JText2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(JText3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(JText4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(JText5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(processJButton)
                .addContainerGap(117, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void processJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processJButtonActionPerformed
          int count = wasteJTable.getRowCount();
          if(count==0){
            if(jLabel2.getText().equals("Recyclable Waste")){
                 Organization org = null;
                for(Network network:business.getNetworkList()){
                 for(Enterprise enterprise:network.getEnterpriseDirectory().getEnterpriseList()){
                  for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
                   if (organization instanceof ManufacturingCompanyOrganization){
                     org = organization;
                     break;
                   }
                  }
                 }
                }
              ManufacturerTestRequest manurequest = new ManufacturerTestRequest();
              manurequest.setSender(userAccount);
              manurequest.setStatus("Sent");
              manurequest.setTestResult("Request cannot be processed as there are no items.");
              manurequest.setAmount(0.0);
              manurequest.setMessage("Request cannot be processed as there are no items.");
              if (org!=null){
                 org.getWorkQueue().getWorkRequestList().add(manurequest);
                 userAccount.getWorkQueue().getWorkRequestList().add(manurequest);
                }
            }
            else if(jLabel2.getText().equals("Donating Waste")){
                 Organization org = null;
                for(Network network:business.getNetworkList()){
                 for(Enterprise enterprise:network.getEnterpriseDirectory().getEnterpriseList()){
                  for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
                   if (organization instanceof NGOOrganization){
                     org = organization;
                     break;
                   }
                  }
                 }
                }
                NGOWorkRequest ngorequest = new NGOWorkRequest();
                  ngorequest.setSender(userAccount);
                  ngorequest.setStatus("Sent");
                  ngorequest.setTestResult("Request cannot be processed as there are no items.");
                  ngorequest.setAmount(0.0);
                  ngorequest.setMessage("Request cannot be processed as there are no items.");
                if (org!=null){
                 org.getWorkQueue().getWorkRequestList().add(ngorequest);
                 userAccount.getWorkQueue().getWorkRequestList().add(ngorequest);
                }
            }
            request.setStatus("completed");
              JOptionPane.showMessageDialog(null, "Request cannot be processed as there are no items");
              return;
          }
        if(jLabel2.getText().equals("Recyclable Waste")){
              int syringes = (int) wasteJTable.getValueAt(0, 1);
              int plasticDisposables = (int) wasteJTable.getValueAt(1, 1);
              int xRayFilms = (int) wasteJTable.getValueAt(2, 1);
              int bpCuffs = (int) wasteJTable.getValueAt(3, 1);
              
              int recycledSyringes = Integer.parseInt(JText1.getText());
              int recycledPlasticDisposables = Integer.parseInt(JText2.getText());
              int recycledXRayFilms = Integer.parseInt(JText3.getText());
              int recycledBpCuffs = Integer.parseInt(JText4.getText());
              
              ManufacturerTestRequest manurequest = new ManufacturerTestRequest();
                  manurequest.setSender(userAccount);
                  manurequest.setStatus("Sent");
                  String testResult = "";
                   int lesserSyringes = 0;
                   int lesserPlasticDisposables = 0;
                   int lesserXRayFilms  = 0;
                   int lesserBPCuffs = 0;
                   
                   Organization org = null;
                for(Network network:business.getNetworkList()){
                 for(Enterprise enterprise:network.getEnterpriseDirectory().getEnterpriseList()){
                  for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
                   if (organization instanceof ManufacturingCompanyOrganization){
                     org = organization;
                     break;
                   }
                  }
                 }
                }
                double amount = 0.0;   
              if(recycledSyringes<=syringes&&recycledPlasticDisposables<=plasticDisposables&&recycledXRayFilms<=xRayFilms&&recycledBpCuffs<=bpCuffs){
                  JOptionPane.showMessageDialog(null, "Request Processed and New Request raised to Manufacturing Company for Payment Details");
                  manurequest.setTestResult("Completed");
                  
                  amount = (recycledSyringes*0.75)+(recycledPlasticDisposables*1)+(recycledXRayFilms*30)+(recycledBpCuffs*10);
                  manurequest.setAmount(amount);
                  if (org!=null){
                   org.getWorkQueue().getWorkRequestList().add(manurequest);
                   userAccount.getWorkQueue().getWorkRequestList().add(manurequest);
                  }
                  manurequest.setMessage("Request Processed.Please complete the payment");
              }
              else if(recycledSyringes>syringes||recycledPlasticDisposables>plasticDisposables||recycledXRayFilms>xRayFilms||recycledBpCuffs>bpCuffs){
                if(recycledSyringes>syringes){
                    amount = amount+(syringes*0.75);
                   lesserSyringes = recycledSyringes-syringes;
                   testResult = lesserSyringes+" "+"Syringes are lesser in quantity. ";
                }
                else{
                    amount = amount+(recycledSyringes*0.75);
                }
                if(recycledPlasticDisposables>plasticDisposables){
                    amount = amount+(plasticDisposables*1);
                   lesserPlasticDisposables =  recycledPlasticDisposables-plasticDisposables;
                   testResult = testResult+lesserPlasticDisposables+" "+"Plastic Disposables are lesser in quantity. ";
                }
                else{
                   amount = amount+(recycledPlasticDisposables*1); 
                }
                if(recycledXRayFilms>xRayFilms){
                    amount = amount+(xRayFilms*30);
                     lesserXRayFilms = recycledXRayFilms-xRayFilms;
                     testResult = testResult+lesserXRayFilms+" "+"X-Ray Films are lesser in quantity. ";
                }
                else{
                    amount = amount+(recycledXRayFilms*30);
                }
                if(recycledBpCuffs>bpCuffs){
                    amount = amount+(bpCuffs*10);
                    lesserBPCuffs = recycledBpCuffs-bpCuffs;
                    testResult = testResult+lesserBPCuffs+" "+"BP Cuffs are lesser in quantity. ";
                }
                else{
                   amount = amount+(recycledBpCuffs*10); 
                }
                manurequest.setAmount(amount);
                manurequest.setTestResult(testResult);
                
                if (org!=null){
                 org.getWorkQueue().getWorkRequestList().add(manurequest);
                 userAccount.getWorkQueue().getWorkRequestList().add(manurequest);
                 JOptionPane.showMessageDialog(null, "Request Processed and New Request raised to Manufacturing Company as requested quantity is not available. ");
                }
                manurequest.setMessage("Request Processed.Please complete the payment");
              }
              else if(recycledSyringes>syringes&&recycledPlasticDisposables>plasticDisposables&&recycledXRayFilms>xRayFilms&&recycledBpCuffs>bpCuffs){
                  manurequest.setMessage("Request Cannot be Processed.");
                  manurequest.setAmount(0.0);
                  manurequest.setTestResult("All the requested quantities are not available.");
              }
              
              for (int i=0; i<result.size();i++) {
              SegregationTestWorkResult segregationResult = (SegregationTestWorkResult) result.get(i); 
              RecyclableWaste recyclableWaste = segregationResult.getRecyclableWaste();
              if(lesserSyringes==0)
               recyclableWaste.setNumberOfSyringes(syringes-recycledSyringes);
              if(lesserPlasticDisposables==0)
               recyclableWaste.setNumberOfPlasticDisposables(plasticDisposables-recycledPlasticDisposables);
              if(lesserXRayFilms==0)
               recyclableWaste.setNumberOfXRayFilms(xRayFilms-recycledXRayFilms);
              if(lesserBPCuffs==0)
               recyclableWaste.setNumberOfBPCuffAndBulbs(bpCuffs-recycledBpCuffs);
              }
              populateTable();
              request.setStatus("completed");
           }
           else if(jLabel2.getText().equals("Donating Waste")){
              int beds = (int) wasteJTable.getValueAt(0, 1);
              int wheelChairs = (int) wasteJTable.getValueAt(1, 1);
              int bandages = (int) wasteJTable.getValueAt(2, 1);
              int thermometers = (int) wasteJTable.getValueAt(3, 1);
              int crutches = (int) wasteJTable.getValueAt(4, 1);
              
              int recycledBeds = Integer.parseInt(JText3.getText());
              int recycledWheelChairs = Integer.parseInt(JText4.getText());
              int recycledBandages = Integer.parseInt(JText2.getText());
              int recycledThermometers = Integer.parseInt(JText1.getText());
              int recycledCrutches = Integer.parseInt(JText5.getText());
              
             
               NGOWorkRequest ngorequest = new NGOWorkRequest();
                  ngorequest.setSender(userAccount);
                  ngorequest.setStatus("Sent");
                  String testResult = "";
                   int lesserBeds = 0;
                   int lesserWheelChairs = 0;
                   int lesserBandages  = 0;
                   int lesserCrutches = 0;
                   int lesserThermometers = 0;
                   
                    Organization org = null;
                for(Network network:business.getNetworkList()){
                 for(Enterprise enterprise:network.getEnterpriseDirectory().getEnterpriseList()){
                  for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
                   if (organization instanceof NGOOrganization){
                     org = organization;
                     break;
                   }
                  }
                 }
                }
                   double amount = 0.0;
              if(recycledBeds<=beds&&recycledWheelChairs<=wheelChairs&&recycledBandages<=bandages&&recycledThermometers<=thermometers&&recycledCrutches<=crutches){
                 JOptionPane.showMessageDialog(null, "Request Processed and New Request raised to NGO for payment details. ");
                 ngorequest.setTestResult("Completed");
                 
                 amount = (recycledBeds*30)+(recycledWheelChairs*25)+(recycledBandages*1)+(recycledThermometers*10)+(recycledCrutches*25);
                 ngorequest.setAmount(amount); 
                   if (org!=null){
                    org.getWorkQueue().getWorkRequestList().add(ngorequest);
                    userAccount.getWorkQueue().getWorkRequestList().add(ngorequest);
                   }
                   ngorequest.setMessage("Request Processed.Please complete the payment");
              }
              else if(recycledBeds>beds||recycledWheelChairs>wheelChairs||recycledBandages>bandages||recycledThermometers>thermometers||recycledCrutches>crutches){
                if(recycledBeds>beds){
                    amount = amount+(beds*30);
                  lesserBeds = recycledBeds-beds;
                  testResult = lesserBeds+" "+"Beds are lesser in quantity. ";
                }
                else{
                     amount = amount+(recycledBeds*30);
                }
                if(recycledWheelChairs>wheelChairs){
                   amount = amount+(wheelChairs*25);
                   lesserWheelChairs = recycledWheelChairs-wheelChairs;
                   testResult = testResult+lesserWheelChairs+" "+"Wheel Chairs are lesser in quantity. ";
                }
                else{
                    amount = amount+(wheelChairs*20);
                }
                if(recycledBandages>bandages){
                    amount = amount+(bandages*1);
                     lesserBandages = recycledBandages-bandages;
                    testResult = testResult+lesserBandages+" "+"Bandages are lesser in quantity. ";
                }
                else{
                    amount = amount+(bandages*1);
                }
                if(recycledCrutches>crutches){
                    amount = amount+(crutches*25);
                    lesserCrutches = recycledCrutches-crutches;
                    testResult = testResult+lesserCrutches+" "+"Crutches are lesser in quantity. ";
                }
                else{
                    amount = amount+(crutches*25);
                }
                if(recycledThermometers>thermometers){
                    amount = amount+(thermometers*10);
                    lesserThermometers = recycledThermometers-thermometers;
                    testResult = testResult+lesserThermometers+" "+"Thermometers are lesser in quantity. ";
                }
                else{
                    amount = amount+(thermometers*10);
                }
                ngorequest.setAmount(amount);
                ngorequest.setTestResult(testResult);
                ngorequest.setMessage("Request Processed.Please complete the payment");
                if (org!=null){
                 org.getWorkQueue().getWorkRequestList().add(ngorequest);
                 userAccount.getWorkQueue().getWorkRequestList().add(ngorequest);
                 JOptionPane.showMessageDialog(null, "Request Processed and New Request raised to NGO as requested quantity is not available.");
                }
              }
             else if(recycledBeds>beds||recycledWheelChairs>wheelChairs||recycledBandages>bandages||recycledThermometers>thermometers||recycledCrutches>crutches){
                  ngorequest.setMessage("Request Cannot be Processed.");
                  ngorequest.setAmount(0.0);
                  ngorequest.setTestResult("All the requested quantities are not available.");
           
             }
              for (int i=0; i<result.size();i++) {
              SegregationTestWorkResult segregationResult = (SegregationTestWorkResult) result.get(i); 
              DonatingWaste donatingWaste = segregationResult.getDonatingWaste();
              if(lesserBandages==0)
               donatingWaste.setNumberOfBandages(bandages-recycledBandages);
              if(lesserBeds==0)
               donatingWaste.setNumberOfBeds(beds-recycledBeds);
              if(lesserWheelChairs==0)
               donatingWaste.setNumberOfWheelChairs(wheelChairs-recycledWheelChairs);
              if(lesserThermometers==0)
               donatingWaste.setNumberOThermometers(thermometers-recycledThermometers);
              if(lesserCrutches==0)
               donatingWaste.setNumberOfCrutches(crutches-recycledCrutches);
              }
              populateTable();
              request.setStatus("completed");
           }
           JText1.setText("");
           JText2.setText("");
           JText3.setText("");
           JText4.setText("");
           JText5.setText("");
    }//GEN-LAST:event_processJButtonActionPerformed

    private void JText4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JText4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JText4ActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JText1;
    private javax.swing.JTextField JText2;
    private javax.swing.JTextField JText3;
    private javax.swing.JTextField JText4;
    private javax.swing.JTextField JText5;
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton processJButton;
    private javax.swing.JTable wasteJTable;
    // End of variables declaration//GEN-END:variables
}
