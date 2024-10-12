/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.AccountManager;

import java.awt.CardLayout;
import static java.lang.System.in;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import model.Account;
import model.AccountDirectory;

/**
 *
 * @author Aniruddha
 */
public class ManageAccountsJPanel extends javax.swing.JPanel {
    JPanel userProcessContainer;
    AccountDirectory accountDirectory;

    /**
     * Creates new form ManageAccountsJPanel
     */
    public ManageAccountsJPanel(JPanel container, AccountDirectory directoory) {
        initComponents();
        userProcessContainer = container;
        accountDirectory = directoory;
        
        populateTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBack = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAccounts = new javax.swing.JTable();
        btnSearch = new javax.swing.JButton();
        btnViewDetails = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        txtSearchBox = new javax.swing.JTextField();

        btnBack.setText("<<<<Back");

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTitle.setText("Manage Account");

        tblAccounts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Bank Name", "Routing Number", "Account Number", "Balance"
            }
        ));
        jScrollPane1.setViewportView(tblAccounts);

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnViewDetails.setText("View Details");
        btnViewDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewDetailsActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete Account");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btnBack)
                        .addGap(260, 260, 260)
                        .addComponent(lblTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSearch)
                                .addGap(58, 58, 58)
                                .addComponent(txtSearchBox, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnViewDetails)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnDelete, btnSearch, btnViewDetails});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(lblTitle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(txtSearchBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnViewDetails)
                .addGap(18, 18, 18)
                .addComponent(btnDelete)
                .addContainerGap(117, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblAccounts.getSelectedRow();
        
        if (selectedRow>=0){
        
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete the selected account", "Warning", JOptionPane.WARNING_MESSAGE);
            if (dialogResult == JOptionPane.YES_OPTION){
            
                Account selectedAccount = (Account) tblAccounts.getValueAt(selectedRow, 0);
                accountDirectory.deleteAccount(selectedAccount);
                populateTable();
            }
            else{
                JOptionPane.showMessageDialog(null, "Please select an account from the list", "Warning", JOptionPane.WARNING_MESSAGE);
                
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnViewDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewDetailsActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblAccounts.getSelectedRow();
        
        if (selectedRow>=0){
            
            Account selectedAccount = (Account) tblAccounts.getValueAt(selectedRow, 0);
                    
            ViewAccountJPanel panel= new ViewAccountJPanel(userProcessContainer, accountDirectory, selectedAccount);
            userProcessContainer.add("ViewAccountJPanel", panel);
            CardLayout layout=(CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        
            //Beyond this point code will execute after you go back to this panel
        }else{
            JOptionPane.showMessageDialog(null, "Please select an account from the list to view", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_btnViewDetailsActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        if (!txtSearchBox.getText().isBlank()){
            String accountNumber= txtSearchBox.getText();
            Account foundAccount= accountDirectory.searchAccount(accountNumber);
            
            if (foundAccount!=null){
                ViewAccountJPanel panel = new ViewAccountJPanel(userProcessContainer,accountDirectory,foundAccount);
                userProcessContainer.add("ViewAccountJPanel", panel);
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                layout.next(userProcessContainer);
            }else{
                JOptionPane.showMessageDialog(null, "Account not found.", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Please type the account number to view", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnViewDetails;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblAccounts;
    private javax.swing.JTextField txtSearchBox;
    // End of variables declaration//GEN-END:variables

    public void populateTable(){
    
        DefaultTableModel model = (DefaultTableModel) tblAccounts.getModel();
        model.setRowCount(0);
        
        for (Account a: accountDirectory.getAccounts()){
            
            Object[] row = new Object[4];
            row[0] = a;
            row[1] = a.getRoutingNumber();
            row[2] = a.getAccountNumber();
            row[3] = String.valueOf(a.getBalance());
            
            model.addRow(row);
        }
    }

}
