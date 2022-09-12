package mainPackage;
import java.awt.Color;
import java.awt.Font;
import coronaStatsPackage.retrieveStatistics;
import usrAccountPackage.UserHome;

import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import javax.swing.JLabel;
import javax.swing.JTextArea;


public class JFrameMain extends javax.swing.JFrame {
    retrieveStatistics newData = new retrieveStatistics();
    String usr;
    String state;
    String district;

    public JFrameMain() {
        initComponents();
//                                                                              Text file for saving Diagnosis result
        CreateFile.newFile();
        try (FileWriter fileWriter = new FileWriter("filename.txt"))
        {
            String filecontent = "0";
            fileWriter.write(filecontent);
            fileWriter.close();
        }    
        catch (IOException e){}
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JFrameSelfDiag = new javax.swing.JFrame();
        cbSevere = new javax.swing.JComboBox<>();
        jLabelSelfDiag1 = new javax.swing.JLabel();
        JLabelSelfDiag2 = new javax.swing.JLabel();
        btnSelfDiagResult = new javax.swing.JButton();
        cbFeverChills = new javax.swing.JCheckBox();
        cbDryCough = new javax.swing.JCheckBox();
        cbTiredness = new javax.swing.JCheckBox();
        cbSoreThroat = new javax.swing.JCheckBox();
        cbAchesPains = new javax.swing.JCheckBox();
        cbVomittingDiarrhoea = new javax.swing.JCheckBox();
        cbConjunctivitis = new javax.swing.JCheckBox();
        cbNoSymp = new javax.swing.JCheckBox();
        cbHeadache = new javax.swing.JCheckBox();
        cbLossTasteSmell = new javax.swing.JCheckBox();
        cbRashDiscolour = new javax.swing.JCheckBox();
        jFrameAreaStatistic = new javax.swing.JFrame();
        jLabelStats1 = new javax.swing.JLabel();
        jLabelStats2 = new javax.swing.JLabel();
        btnStatsResult = new javax.swing.JButton();
        cbbStatsName = new javax.swing.JComboBox<>();
        cbbWorldStateDist = new javax.swing.JComboBox<>();
        jButtonStatsState = new javax.swing.JButton();
        jButtonStatsDistrict = new javax.swing.JButton();
        jButtonSelfDiag = new javax.swing.JButton();
        jButtonStats = new javax.swing.JButton();
        jButtonRegulations = new javax.swing.JButton();
        jButtonAccount = new javax.swing.JButton();
        jButtonHealth = new javax.swing.JButton();
        cbbCities = new javax.swing.JComboBox<>();

        JFrameSelfDiag.setTitle("Covid-19 Self-Diagnosis");
        JFrameSelfDiag.setResizable(false);
        JFrameSelfDiag.setSize(new java.awt.Dimension(750, 600));
        JFrameSelfDiag.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                JFrameSelfDiagWindowClosed(evt);
            }
        });

        cbSevere.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Your answer.", "I am able to do normal activities like exercising.", "I can only do some daily activities like cleaning and making food.", "I can only do what's necessary such as using the bathroom or eating.", " " }));
        cbSevere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSevereActionPerformed(evt);
            }
        });

        jLabelSelfDiag1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelSelfDiag1.setText("Have you recently started experiencing any of these symptoms ?");

        JLabelSelfDiag2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JLabelSelfDiag2.setText("How severe are your symptomps?");

        btnSelfDiagResult.setText("See result");
        btnSelfDiagResult.setMaximumSize(new java.awt.Dimension(91, 23));
        btnSelfDiagResult.setMinimumSize(new java.awt.Dimension(91, 23));
        btnSelfDiagResult.setPreferredSize(new java.awt.Dimension(91, 23));
        btnSelfDiagResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelfDiagResultActionPerformed(evt);
            }
        });

        cbFeverChills.setText("Fever or Chills");
        cbFeverChills.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFeverChillsActionPerformed(evt);
            }
        });

        cbDryCough.setText("Dry cough");

        cbTiredness.setText("Tiredness");

        cbSoreThroat.setText("Sore throat");
        cbSoreThroat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSoreThroatActionPerformed(evt);
            }
        });

        cbAchesPains.setText("Aches and Pains");
        cbAchesPains.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAchesPainsActionPerformed(evt);
            }
        });

        cbVomittingDiarrhoea.setText("Vomiting or diarrhea");
        cbVomittingDiarrhoea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbVomittingDiarrhoeaActionPerformed(evt);
            }
        });

        cbConjunctivitis.setText("Conjunctivitis");
        cbConjunctivitis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbConjunctivitisActionPerformed(evt);
            }
        });

        cbNoSymp.setText("None of the above");

        cbHeadache.setText("Headache");
        cbHeadache.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHeadacheActionPerformed(evt);
            }
        });

        cbLossTasteSmell.setText("Loss of taste or smell");

        cbRashDiscolour.setText("Rash on skin, or Discolouration of fingers or toes");

        javax.swing.GroupLayout JFrameSelfDiagLayout = new javax.swing.GroupLayout(JFrameSelfDiag.getContentPane());
        JFrameSelfDiag.getContentPane().setLayout(JFrameSelfDiagLayout);
        JFrameSelfDiagLayout.setHorizontalGroup(
            JFrameSelfDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JFrameSelfDiagLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(JFrameSelfDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JFrameSelfDiagLayout.createSequentialGroup()
                        .addComponent(jLabelSelfDiag1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(JFrameSelfDiagLayout.createSequentialGroup()
                        .addGroup(JFrameSelfDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JFrameSelfDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(JLabelSelfDiag2)
                                .addComponent(cbRashDiscolour))
                            .addGroup(JFrameSelfDiagLayout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addComponent(cbSevere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(JFrameSelfDiagLayout.createSequentialGroup()
                                .addGroup(JFrameSelfDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbFeverChills)
                                    .addComponent(cbConjunctivitis)
                                    .addComponent(cbAchesPains))
                                .addGap(104, 104, 104)
                                .addGroup(JFrameSelfDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbSoreThroat)
                                    .addComponent(cbHeadache)
                                    .addComponent(cbDryCough))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(JFrameSelfDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbVomittingDiarrhoea)
                            .addComponent(cbTiredness)
                            .addComponent(cbLossTasteSmell)
                            .addComponent(cbNoSymp)
                            .addComponent(btnSelfDiagResult, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40))))
        );
        JFrameSelfDiagLayout.setVerticalGroup(
            JFrameSelfDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JFrameSelfDiagLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jLabelSelfDiag1)
                .addGap(48, 48, 48)
                .addGroup(JFrameSelfDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JFrameSelfDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbFeverChills)
                        .addComponent(cbDryCough))
                    .addComponent(cbTiredness))
                .addGap(62, 62, 62)
                .addGroup(JFrameSelfDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbVomittingDiarrhoea)
                    .addComponent(cbSoreThroat)
                    .addComponent(cbAchesPains))
                .addGap(51, 51, 51)
                .addGroup(JFrameSelfDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbHeadache)
                    .addComponent(cbConjunctivitis)
                    .addComponent(cbLossTasteSmell))
                .addGap(56, 56, 56)
                .addGroup(JFrameSelfDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbRashDiscolour)
                    .addComponent(cbNoSymp))
                .addGap(39, 39, 39)
                .addComponent(JLabelSelfDiag2)
                .addGap(18, 18, 18)
                .addComponent(cbSevere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(btnSelfDiagResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );

        jFrameAreaStatistic.setTitle("Covid-19 Statistics in Germany");
        jFrameAreaStatistic.setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        jFrameAreaStatistic.setSize(new java.awt.Dimension(400, 400));
        jFrameAreaStatistic.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelStats1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelStats1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelStats1.setText("World, German state or German district?");
        jLabelStats1.setMaximumSize(new java.awt.Dimension(112, 14));
        jLabelStats1.setMinimumSize(new java.awt.Dimension(112, 14));
        jLabelStats1.setPreferredSize(new java.awt.Dimension(112, 14));
        jFrameAreaStatistic.getContentPane().add(jLabelStats1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 270, 20));

        jLabelStats2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelStats2.setText("Name of location:");
        jLabelStats2.setMaximumSize(new java.awt.Dimension(112, 14));
        jFrameAreaStatistic.getContentPane().add(jLabelStats2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 100, -1));

        btnStatsResult.setText("Check Result");
        btnStatsResult.setMaximumSize(new java.awt.Dimension(92, 23));
        btnStatsResult.setMinimumSize(new java.awt.Dimension(92, 23));
        btnStatsResult.setPreferredSize(new java.awt.Dimension(92, 23));
        btnStatsResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStatsResultActionPerformed(evt);
            }
        });
        jFrameAreaStatistic.getContentPane().add(btnStatsResult, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 150, 40));

        cbbStatsName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbStatsNameActionPerformed(evt);
            }
        });
        jFrameAreaStatistic.getContentPane().add(cbbStatsName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, -1, -1));

        cbbWorldStateDist.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "World", "States", "Districts" }));
        cbbWorldStateDist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbWorldStateDistActionPerformed(evt);
            }
        });
        jFrameAreaStatistic.getContentPane().add(cbbWorldStateDist, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, -1, -1));

        jButtonStatsState.setText("Your state");
        jButtonStatsState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStatsStateActionPerformed(evt);
            }
        });
        jFrameAreaStatistic.getContentPane().add(jButtonStatsState, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 150, 40));

        jButtonStatsDistrict.setText("Your district");
        jButtonStatsDistrict.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStatsDistrictActionPerformed(evt);
            }
        });
        jFrameAreaStatistic.getContentPane().add(jButtonStatsDistrict, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 150, 40));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main Menu");
        setSize(new java.awt.Dimension(300, 300));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jButtonSelfDiag.setText("Self Diagnosis");
        jButtonSelfDiag.setMaximumSize(new java.awt.Dimension(230, 23));
        jButtonSelfDiag.setMinimumSize(new java.awt.Dimension(230, 23));
        jButtonSelfDiag.setPreferredSize(new java.awt.Dimension(230, 23));
        jButtonSelfDiag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelfDiagActionPerformed(evt);
            }
        });

        jButtonStats.setText("Area Statistics");
        jButtonStats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStatsActionPerformed(evt);
            }
        });

        jButtonRegulations.setText("Area Regulations");
        jButtonRegulations.setMaximumSize(new java.awt.Dimension(230, 23));
        jButtonRegulations.setMinimumSize(new java.awt.Dimension(230, 23));
        jButtonRegulations.setPreferredSize(new java.awt.Dimension(230, 23));
        jButtonRegulations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegulationsActionPerformed(evt);
            }
        });

        jButtonAccount.setText("Your account info");
        jButtonAccount.setMaximumSize(new java.awt.Dimension(230, 23));
        jButtonAccount.setMinimumSize(new java.awt.Dimension(230, 23));
        jButtonAccount.setPreferredSize(new java.awt.Dimension(230, 23));
        jButtonAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAccountActionPerformed(evt);
            }
        });

        jButtonHealth.setText("Healthcare advice");
        jButtonHealth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHealthActionPerformed(evt);
            }
        });

        cbbCities.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Berlin", "Frankfurt am Main", "Hamburg", "Cologne","Munich","Stuttgart" }));
        cbbCities.setSelectedItem("Berlin");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButtonSelfDiag, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonStats, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonRegulations, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonHealth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(cbbCities, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jButtonSelfDiag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jButtonStats)
                .addGap(40, 40, 40)
                .addComponent(jButtonRegulations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(cbbCities, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButtonHealth)
                .addGap(29, 29, 29)
                .addComponent(jButtonAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//                                                                              Diagnosis based on symptoms
    private void btnSelfDiagResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelfDiagResultActionPerformed

        if (cbNoSymp.isSelected())
            System.out.println("nothin");
        else
        {
            if (cbFeverChills.isSelected())
                AddPoint.addPoint(2);
            if (cbDryCough.isSelected())
                AddPoint.addPoint(2);
            if (cbTiredness.isSelected())
                AddPoint.addPoint(2);
            if (cbAchesPains.isSelected())
                AddPoint.addPoint(1);
            if (cbSoreThroat.isSelected())
                AddPoint.addPoint(1);  
            if (cbVomittingDiarrhoea.isSelected())
                AddPoint.addPoint(1);           
            if (cbConjunctivitis.isSelected())
                AddPoint.addPoint(1);
            if (cbHeadache.isSelected())
                AddPoint.addPoint(1);  
            if (cbLossTasteSmell.isSelected())
                AddPoint.addPoint(1);  
            if (cbRashDiscolour.isSelected())
                AddPoint.addPoint(1);  
        }
        String msg = (String)cbSevere.getSelectedItem();
        switch (msg)
        {
            case "I can only do some daily activities like cleaning and making food.":
                AddPoint.addPoint(2);
                break;
            case "I can only do what's necessary such as using the bathroom or eating.":
                AddPoint.addPoint(3);
                break;
        }
        try(FileReader fileReader = new FileReader("filename.txt")) 
        {
            int ch = fileReader.read();
            String chString = "";
            while (ch!=-1)
            {
                chString = chString + (char)ch;
                ch = fileReader.read();
            }
            ch = Integer.parseInt(chString);
            if ((ch <=4) & (ch>0))
            {
                JOptionPane.showMessageDialog(null,"Your result is : " + chString + " point(s)\n "
                        + "You have mild symptoms that may be caused by Covid-19.\n"
                        + "Take care of your health and remember to use self diagnosis again in case of getting new symptoms! ");
            }
            if (ch ==0)
            {
                JOptionPane.showMessageDialog(null,"Your result is : " + chString + " point(s)\n "
                        + "You have no covid-19 related symptoms!");
            }
            if (ch >4)
            {
                JOptionPane.showMessageDialog(null,"Your result is : " + chString + " point(s)\n "
                        + "Your symptoms are likely caused by Covid-19.\n"
                        + "You should avoid contact with others and try to get a covid-19 test as soon as possible!");
            }
            AddPoint.addPoint(Integer.parseInt(chString) * -1);
            fileReader.close();
        }
        catch (FileNotFoundException e) 
        {
            
        }
        catch (IOException e)
        {
            
        }
            
    }//GEN-LAST:event_btnSelfDiagResultActionPerformed

    private void cbSevereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSevereActionPerformed

    }//GEN-LAST:event_cbSevereActionPerformed

    private void cbAchesPainsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAchesPainsActionPerformed

    }//GEN-LAST:event_cbAchesPainsActionPerformed

    private void cbFeverChillsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFeverChillsActionPerformed

    }//GEN-LAST:event_cbFeverChillsActionPerformed

    private void cbSoreThroatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSoreThroatActionPerformed

    }//GEN-LAST:event_cbSoreThroatActionPerformed

    private void JFrameSelfDiagWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_JFrameSelfDiagWindowClosed

    }//GEN-LAST:event_JFrameSelfDiagWindowClosed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void btnStatsResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatsResultActionPerformed
//                                                                              Choose Area from combobox to view Covid-19 statistics
        String msg = (String)cbbWorldStateDist.getSelectedItem();
        switch (msg)
        {
            case "World":
                JOptionPane.showMessageDialog(null, newData.displayGeneralStats());
                break;
            case "States":
                String msg2 = (String)cbbStatsName.getSelectedItem();
                JOptionPane.showMessageDialog(null, newData.displayStatesStats(msg2));
                break;
            case "Districts":
                String msg3 = (String)cbbStatsName.getSelectedItem();
                JOptionPane.showMessageDialog(null, newData.displayDistrictsStats(msg3));
                break;
        }
                
    }//GEN-LAST:event_btnStatsResultActionPerformed
//                                                                              Put States or District names into combobox
    private void cbbWorldStateDistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbWorldStateDistActionPerformed

        String msg = (String)cbbWorldStateDist.getSelectedItem();
        switch (msg)
        {
            case "States":
                Object[] a = newData.getNames("states");
                Arrays.sort(a);
                cbbStatsName.setModel(new javax.swing.DefaultComboBoxModel(a));
                break;
            case "Districts":
                Object[] b = newData.getNames("districts");
                Arrays.sort(b);
                cbbStatsName.setModel(new javax.swing.DefaultComboBoxModel(b));
                break;
            default: cbbStatsName.removeAllItems();
                
        }
    }//GEN-LAST:event_cbbWorldStateDistActionPerformed

    private void cbbStatsNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbStatsNameActionPerformed

    }//GEN-LAST:event_cbbStatsNameActionPerformed
//                                                                              Open statistics window
    private void jButtonStatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStatsActionPerformed
        this.jFrameAreaStatistic.setVisible(true);        
    }//GEN-LAST:event_jButtonStatsActionPerformed
//                                                                              Choose one city from combobox to see Covid-19 related regulations
    private void jButtonRegulationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegulationsActionPerformed
        String city = (String)cbbCities.getSelectedItem();
        JTextArea ta = new JTextArea(20, 100);
        switch (city)
        {
            case "Berlin":
                ta.setText(
                "Last updated: March 4th 2021.\n\n"
                        + "Strict contact restrictions apply in public and private spaces until the end of March 7, 2021.\n\n"
                        + "Contact limit: \nYou can only be alone in public, with members of your own household and at most one person"
                        + "from one other household. For single parents children up to 12 years are not included.\n\n"
                        + "Mask duty: \nYou are required to wear a medical face mask (surgical mask, FFP2 or KN95 mask without ventilation valve) in the following places: \n"
                        + "     When shopping: For example in supermarkets, pharmacies or drugstores\n"
                        + "     On local public transport\n"
                        + "     At railway stations\n"
                        + "     In commercial enterprises\n"
                        + "     In medical practices\n"
                        + "     In hospitals and nursing homes\n"
                        + "     cannot be safely maintained. This obligation does not apply to employees when they are in their normal place of work.\n"
                        + "     In taxis and on private journeys for persons from another household. (Car drivers do not have to wear a mask.)\n"
                        + "     At religious services and events\n"
                        + "You are required to wear a mask (medical face mask or everyday mask) in the following places:\n"
                        + "     At markets (weekly markets, etc.) in parking lots, in queues and on sidewalks in front of buildings with retail stores or service providers or small businesses\n"
                        + "     In busy streets – such as Bergmannstrasse, and Kurfürstendamm – as well as in certain busy public squares – such as Alexanderplatz. To the overview of all areas where masks are mandatory (link to the attachment). This obligation to wear masks does not apply to cyclists.\n"
                        + "     In all vocational and secondary schools in the whole of the school campus\n"
                        + "     Where food is served\n"
                        + "     In all other schools except during lessons and extracurricular activities, mentoring support and supervision. From grade 5 onwards students also have to wear a mask during lessons.\n"
                        + "     At demonstrations\n"
                        + "The mask must be worn in such a way that the mouth and nose are completely covered preventing the emission of aerosols and droplets. "
                        + "In addition, in the case of normal masks the type of material used must be able to prevent the spread of droplets and aerosols. "
                        + "Anyone who does not comply with the obligation to cover their mouth and nose risks a fine.\n\n"
                        + "For more information, visit:     https://www.berlin.de/corona/en/measures/");
                
                break;
            case "Frankfurt am Main":
                ta.setText(
                "Last updated: March 4th 2021.\n\n"
                        + "Contact restrictions currently in place until 7 March.\n\n"
                        + "Contact limit: \nStays in public are limited to one household and one additional person, children are being counted as well.\n\n"
                        + "Mask duty: \nFrom 8 am until 10 pm, you must wear a mask in central Frankfurt and on all shopping streets. \n"
                        + "You must wear medical masks, i.e. surgical masks or FFP2 or KN95/N95 masks, among others here:\n"
                        + "     In local and long-distance public transport, e.g. when using trams, metros, urban trains, taxis and bus services,\n"
                        + "     In shops (wholesale and retail), petrol stations, laundries, bank and post office branches, and indeed everywhere where customers have access,\n"
                        + "     in the public areas of all publicly accessible buildings (especially public authorities and office buildings)\n\n"
                        + "Prohibition of alcohol consumption: \n"
                        + "No alcohol may be consumed in parks, on busy streets or public squares.\n\n"
                        + "Leisure events and activities: \nInstitutions and facilities that are part of recreational activities will be closed.\n\n"
                        + "For more information, visit: https://frankfurt.de/english/corona-information#:~:text=Most%20important%20measures%3A%20Keep%20distance,to%20an%20absolutely%20necessary%20minimum ");
                break;
            case "Hamburg":
            ta.setText( 
                "Last updated: March 4th 2021.\n\n"
                        + "Until 7 March 2021, It is mandatory to wear a medical mask covering your nose and mouth in the following situations: \n" +
                        "   In public transport, \n" +
                        "   When shopping (in retail shops) or at farmers‘ markets,\n" +
                        "   Gastronomic facilities and in retail shops; this includes the staff members. \n" +
                        "   It is only allowed to take off the mask while remaining at your seat,\n" +
                        "   During health treatments,\n" +
                        "   During religious services, during body care services, in hotels or educational and training facilities, at work, service or operational premises\n" +
                        "   and other locations serving the purpose of professional practice.\n"+
                        "   It is only allowed to take off the mask while remaining at your seat or when this is necessary\n" +
                        "   During the service or treatment. \n" +
                        "   Buildings in Hamburg that are open to the public (offices, other institutions). It is only allowed to take off the mask while remaining at your seat or workplace\n" +
                        "   Cultural facilities such as libraries and memorials.\n\n"+
                        "Rules applying for children: Children under the age of 7 years are exempt from the obligation to wear a mask. At places where it is mandatory to wear a medical mask,\n" +
                        "children over the age of 14 years must wear a medical mask instead of a simple face covering. This means that children under under and\n" +
                        "including the age of 14 years are allowed to wear simple everyday face coverings.\n\n"+
                        "For more information, visit: https://www.hamburg.com/residents/settle/health/14111762/corona-whats-new/ ");
                break;
            case "Cologne":
            ta.setText(
                "Last updated: March 4th 2021.\n\n"+
                        "Overnight stays for touristic purposes are prohibited.\n" +
                "In public spaces, a minimum distance of 1.5 metres must be kept from all persons.\n" +
                "Meetings in public space are permitted only between members of a household and one other person. This person may be accompanied by children in need of care from their household.\n" +
                "The obligation to wear a medical mask applies at certain locations. If children under the age of 14 cannot wear a medical mask due to the fit, an everyday mask must be worn as a replacement. \n\n"
                        + "The obligation to wear a medical mask exists regardless of compliance with a minimum distance\n" +
                "   in retail stores, pharmacies, gas stations, banks, etc., as well as in doctors’ offices and comparable medical facilities,\n" +
                "   in public transport – also at stations and stops\n" +
                "   during religious services and other gatherings for the practice of religion also at the seat.\n\n" +
                "The mask obligation continues to apply in particular in the following areas, whereby the wearing of an everyday mask continues to be sufficient here:\n" +
                "   in enclosed premises in public areas, insofar as these are also accessible – with or without entrance control – to customers or visitors,\n" +
                "   at markets and similar outdoor sales points\n\n" +
                "The retail trade is closed. Exceptions include: Grocery stores, pick-up and delivery services, beverage markets, weekly food markets, pharmacies, health food stores, \n"+
                "medical supply stores, drugstores, gas stations, banks, savings banks, post offices, kiosks, wholesale (for wholesale customers), the distribution of food by social institutions (food banks).\n" +
                "Leisure and entertainment facilities are closed. These include, for example, zoological gardens, boat trips, zoos, clubs, discos, amusement parks, indoor playgrounds, swimming and fun pools and amusement arcades.\n" +
                "Concerts and performances in theaters, opera houses, concert halls, cinemas and other institutions as well as the operation of museums, art exhibitions, galleries, castles, palaces, "
                        + "\nmemorials and similar institutions are not permitted.\n" +
                "The operation of drive-in cinemas, drive-in theaters and similar facilities is permitted under certain conditions.\n" +
                "Restaurants, pubs, snack bars, cafés and other catering facilities are closed. Only the drop-off or pick-up service is allowed.\n" +
                "Recreational and amateur sports are not permitted. Individual sport is excluded (under certain conditions).\n" +
                "Competitions in professional leagues are permitted. Spectators are not permitted.\n\n"
                        + "For more information, visit: https://www.cologne-tourism.com/plan-inform/newsroom/news/corona-in-cologne/");
                break;
            case "Munich":
            ta.setText( 
                "Last updated: March 4th 2021.\n\n"+
                        "Corona: Lockdown extended until March 28 at the latest:\n"+
                        "Leaving your apartment is only allowed for valid reasons, including:\n" +
                        "   The exercise of professional or official activities\n" +
                        "   The use of medical and veterinary services\n" +
                        "   Running errands, shopping in open stores and visiting open service providers\n" +
                        "   Visiting another household - as long as the contact restrictions are observed\n" +
                        "   Visiting partners, the elderly, the sick or people with disabilities\n" +
                        "   Sports and exercise in open air\n" +
                        "   Going to the office\n" +
                        "   Participation in church services and in permitted assemblies, according to the Bavarian law\n\n"+
                        "The curfew between 10 pm and 5 am is only enforced if the 7-day incidence value is over 100. In this case you are only permitted to leave your home for the following reasons:\n" +
                        "   the practice of professional or official activities\n" +
                        "   medical and veterinary emergencies\n" +
                        "   exercising rights to custody and access\n" +
                        "   Accompanying those in need of support and minors\n" +
                        "   in company of the sick\n" +
                        "   carrying out animal care\n" +
                        "   similarly weighty and irrefutable reasons\n\n"
                        +"For more information, visit: https://www.muenchen.de/int/en/events/bavaria-declares-state-of-emergency.html ");
                break;
            case "Stuttgart":
            ta.setText( 
                "Last updated: March 4th 2021.\n\n"+
                        "Regulations for the lockdown in Baden-Wurttemberg, extended until March 7,2021:\n"+
                        "Contact restrictions:\n" +
                        "   Private meetings in public or private areas only within your own houseyhold plus no more than one other individual who is not part of your household.\n" +
                        "   Children in both households up to and including the age of 14 are not counted.\n" +
                        "   The purpose of this regulation is to cover special hardship cases.\n\n" +
                        "Regulation for child care:\n" +
                        "   Children from a maximum of two households may be cared for together in a permanent, family-related or neighborhood-based support community\n\n" +
                        "Obligation to wear masks: Medical mask must be worn in the following areas:\n" +
                        "   On public transport\n" +
                        "   During hopping\n" +
                        "   In workpl,aces and businesses as well as job sites\n" +
                        "   In doctors' offices, hospitals and nursing facilities\n" +
                        "   During religious services /events\n\n" +
                        "Permitted are:\n" +
                        "   Medical face mask (surgical mask)\n"+
                        "   Respirator (FFP2 or KN95/N95)\n\n"
                        +"For more information, visit: https://coronavirus.stuttgart.de/img/mdb/item/692066/158597.pdf ");
                break;
        }
        ta.setWrapStyleWord(true);
        ta.setLineWrap(true);
        ta.setCaretPosition(0);
        ta.setEditable(false);
        JOptionPane.showMessageDialog(null, new JScrollPane(ta), "RESULT", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButtonRegulationsActionPerformed
//                                                                              Open userhome window
    private void jButtonAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAccountActionPerformed
        dispose();
        UserHome ah = new UserHome(getUserName());
        ah.setTitle("User Account Info");
        ah.setVisible(true);       
    }//GEN-LAST:event_jButtonAccountActionPerformed
//                                                                              Open self-diagnosis window
    private void jButtonSelfDiagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelfDiagActionPerformed
        this.JFrameSelfDiag.setVisible(true);        
    }//GEN-LAST:event_jButtonSelfDiagActionPerformed
//                                                                              View healthcare advice
    private void jButtonHealthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHealthActionPerformed
        JOptionPane.showMessageDialog(null, "When you are well\n1. Wash your hands often with soap and water. This includes before and after eating and after going to the toilet\n2. Use alcohol-based hand sanitisers when you can’t use soap and water\n3. Avoid touching your eyes, nose and mouth clean and disinfect surfaces and objects you use often\n4. Increase the amount of fresh air by opening windows or changing air conditioning\n5. There is no evidence that alcohol-free hand rubs are effective against viruses like COVID-19.\n\nWhen you are sick\n1. As we move towards living COVIDSafe, it is important that you stay at home if you feel unwell. You should also continue to practise good hygiene.\n2. If you have cold or flu like symptoms you should seek medical advice and get tested for COVID-19. You should get tested even if your symptoms are mild.\n3. If you have COVID-19 you must isolate and follow the directions of your local Public Health Unit.");        
    }//GEN-LAST:event_jButtonHealthActionPerformed
//                                                                              View statistics of user's state
    private void jButtonStatsStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStatsStateActionPerformed
        String USER = "admin";
        String PASS = "administrator";
        String JDBC_DRIVER = "org.h2.Driver";
        String DB_URL = "jdbc:h2:~/test1;IFEXISTS=TRUE";
        try 
        {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement st = conn.prepareStatement("SELECT * FROM registration WHERE username=?;");
            st.setString(1, usr);
            ResultSet rs = st.executeQuery();
            while (rs.next())
            {
                state = rs.getString("state");
            }
            
        }
        catch (SQLException|ClassNotFoundException sqlException) 
        {
            sqlException.printStackTrace();
        } 
        JOptionPane.showMessageDialog(null, newData.displayStatesStats(state));       
    }//GEN-LAST:event_jButtonStatsStateActionPerformed
//                                                                              View statistics of user's district
    private void jButtonStatsDistrictActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStatsDistrictActionPerformed
        String USER = "admin";
        String PASS = "administrator";
        String JDBC_DRIVER = "org.h2.Driver";
        String DB_URL = "jdbc:h2:~/test1;IFEXISTS=TRUE";
        try 
        {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement st = conn.prepareStatement("SELECT * FROM registration WHERE username=?;");
            st.setString(1, usr);
            ResultSet rs = st.executeQuery();
            while (rs.next())
            {
                district = rs.getString("district");
            }
            
        }
        catch (SQLException|ClassNotFoundException sqlException) 
        {
            sqlException.printStackTrace();
        } 
        JOptionPane.showMessageDialog(null, newData.displayDistrictsStats(district));
    }//GEN-LAST:event_jButtonStatsDistrictActionPerformed

    private void cbHeadacheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHeadacheActionPerformed

    }//GEN-LAST:event_cbHeadacheActionPerformed

    private void cbConjunctivitisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbConjunctivitisActionPerformed
 
    }//GEN-LAST:event_cbConjunctivitisActionPerformed

    private void cbVomittingDiarrhoeaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbVomittingDiarrhoeaActionPerformed

    }//GEN-LAST:event_cbVomittingDiarrhoeaActionPerformed

    /**
     * @param args the command line arguments
     */
    public void setUserName(String id) 
    {                                         
        usr = id;
    } 
    public String getUserName()
    {
        return (usr);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame JFrameSelfDiag;
    private javax.swing.JLabel JLabelSelfDiag2;
    private javax.swing.JButton btnSelfDiagResult;
    private javax.swing.JButton btnStatsResult;
    private javax.swing.JCheckBox cbAchesPains;
    private javax.swing.JCheckBox cbConjunctivitis;
    private javax.swing.JCheckBox cbDryCough;
    private javax.swing.JCheckBox cbFeverChills;
    private javax.swing.JCheckBox cbHeadache;
    private javax.swing.JCheckBox cbLossTasteSmell;
    private javax.swing.JCheckBox cbNoSymp;
    private javax.swing.JCheckBox cbRashDiscolour;
    private javax.swing.JComboBox<String> cbSevere;
    private javax.swing.JCheckBox cbSoreThroat;
    private javax.swing.JCheckBox cbTiredness;
    private javax.swing.JCheckBox cbVomittingDiarrhoea;
    private javax.swing.JComboBox<String> cbbCities;
    private javax.swing.JComboBox<String> cbbStatsName;
    private javax.swing.JComboBox<String> cbbWorldStateDist;
    private javax.swing.JButton jButtonAccount;
    private javax.swing.JButton jButtonHealth;
    private javax.swing.JButton jButtonRegulations;
    private javax.swing.JButton jButtonSelfDiag;
    private javax.swing.JButton jButtonStats;
    private javax.swing.JButton jButtonStatsDistrict;
    private javax.swing.JButton jButtonStatsState;
    private javax.swing.JFrame jFrameAreaStatistic;
    private javax.swing.JLabel jLabelSelfDiag1;
    private javax.swing.JLabel jLabelStats1;
    private javax.swing.JLabel jLabelStats2;
    // End of variables declaration//GEN-END:variables
int limit1=0;


}
