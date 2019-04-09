/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.*;
import javax.swing.*;

public class Person extends javax.swing.JFrame {

    /**
     * Creates new form person
     */
    public Person() {
        initComponents();
        Show_Users_In_JTable();
    }
public Connection getConnection( ){
    
    Connection con = null;
    try {
    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/person" , "root" , "");
    return con;
    }catch ( Exception e ){
        e.printStackTrace();
        return null;
    }
    
}
public ArrayList<User> getUserList (){
    
    ArrayList<User> userList = new ArrayList<User>();
    Connection connection = getConnection();
    String query = "SELECT * FROM `person` ";
    
    Statement st;
    ResultSet rs;
    
    try{
        st = connection.createStatement();
        rs = st.executeQuery(query);
        User user;
        while (rs.next()){
            user = new User (rs.getInt("id"),rs.getString("firstname"),rs.getString("lastname"), rs.getInt("age"));
            userList.add(user);
        }
    
    }catch (Exception e ){
        e.printStackTrace();
        
        
    }
    
    return userList;
}


// Display Data in Jtable

public void Show_Users_In_JTable()
   {
       ArrayList<User> list = getUserList();
       DefaultTableModel model = (DefaultTableModel)jTable_Display_Users.getModel();
       Object[] row = new Object[4];
       for(int i = 0; i < list.size(); i++)
       {
           row[0] = list.get(i).getId();
           row[1] = list.get(i).getFirstName();
           row[2] = list.get(i).getLastName();
           row[3] = list.get(i).getAge();
           
           model.addRow(row);
       }
    }

// Execute The Insert Update And Delete Querys
   public void executeSQlQuery(String query, String message)
   {
   Connection con = getConnection();
       Statement st;
       try{
           st = con.createStatement();
           if((st.executeUpdate(query)) == 1)
           {
               // refresh jtable data
               DefaultTableModel model = (DefaultTableModel)jTable_Display_Users.getModel();
               model.setRowCount(0);
               Show_Users_In_JTable();
               
               JOptionPane.showMessageDialog(null, "Data "+message+" Succefully");
           }else{
               JOptionPane.showMessageDialog(null, "Data Not "+message);
           }
       }catch(Exception ex){
           ex.printStackTrace();
       } 
   
   }
   
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Display_Users = new javax.swing.JTable();
        jButton_Insert = new javax.swing.JButton();
        jButton_Update = new javax.swing.JButton();
        jButton_Delete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField_Id = new javax.swing.JTextField();
        jTextField_FirstName = new javax.swing.JTextField();
        jTextField_LastName = new javax.swing.JTextField();
        jTextField_Age = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 255, 102));

        jTable_Display_Users.setAutoCreateRowSorter(true);
        jTable_Display_Users.setBackground(new java.awt.Color(102, 255, 102));
        jTable_Display_Users.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "First Name", "Last Name", "Age"
            }
        ));
        jTable_Display_Users.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_Display_UsersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Display_Users);

        jButton_Insert.setText("Insert");
        jButton_Insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_InsertActionPerformed(evt);
            }
        });

        jButton_Update.setText("Udate");
        jButton_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_UpdateActionPerformed(evt);
            }
        });

        jButton_Delete.setText("Delete");
        jButton_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DeleteActionPerformed(evt);
            }
        });

        jLabel1.setText("ID:");

        jLabel2.setText("First Name:");

        jLabel3.setText("Last Name:");

        jLabel4.setText("Age:");

        jTextField_Id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_IdActionPerformed(evt);
            }
        });

        jTextField_FirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_FirstNameActionPerformed(evt);
            }
        });

        jTextField_LastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_LastNameActionPerformed(evt);
            }
        });

        jTextField_Age.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_AgeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField_Age, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField_LastName))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField_FirstName))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField_Id, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton_Insert, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_Update, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton_Delete, jButton_Insert, jButton_Update});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTextField_Age, jTextField_FirstName, jTextField_Id, jTextField_LastName});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField_Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jTextField_FirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField_LastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField_Age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Insert, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Update, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton_Delete, jButton_Insert, jButton_Update});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jTextField_Age, jTextField_FirstName, jTextField_Id, jTextField_LastName});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DeleteActionPerformed
         /*
        
        */
       int replay = JOptionPane.showConfirmDialog(null, "You are going to delete Person Of ID: -- " +jTextField_Id.getText() + " -- Are U sure?", "close?", JOptionPane.YES_NO_CANCEL_OPTION );
         if (replay == JOptionPane.YES_OPTION) {
             
        String query = "DELETE FROM `person` WHERE id = "+jTextField_Id.getText();
         executeSQlQuery(query, "Person Of ID : -- " + jTextField_Id.getText() + " -- Deleted");
         }
         
    }//GEN-LAST:event_jButton_DeleteActionPerformed

    private void jTextField_LastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_LastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_LastNameActionPerformed

    private void jButton_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_UpdateActionPerformed
      String query = "UPDATE `person` SET `firstname`='"+jTextField_FirstName.getText()+"',`lastname`='"+jTextField_LastName.getText()+"',`age`="+jTextField_Age.getText()+" WHERE `id` = "+jTextField_Id.getText();
       executeSQlQuery(query, "Updated");
    }//GEN-LAST:event_jButton_UpdateActionPerformed

    private void jButton_InsertActionPerformed(java.awt.event.ActionEvent evt) {
	
	      if (jTextField_FirstName.getText().equals("") || jTextField_LastName.getText().equals("") || jTextField_Age.getText().equals("") ){
             JOptionPane.showMessageDialog(null, "Data , "+" Please insert data requires"); 
		  }
		 else {
			 
        String query = "INSERT INTO `person`(`firstname`, `lastname`, `age`) VALUES ('"+jTextField_FirstName.getText()+"','"+jTextField_LastName.getText()+"',"+jTextField_Age.getText()+")";
        
        executeSQlQuery(query, "Inserted");
		 }
    }

    private void jTextField_IdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_IdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_IdActionPerformed

    private void jTextField_FirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_FirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_FirstNameActionPerformed

    private void jTextField_AgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_AgeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_AgeActionPerformed

    private void jTable_Display_UsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_Display_UsersMouseClicked
       // Get The Index Of The Slected Row 
        int i = jTable_Display_Users.getSelectedRow();

        TableModel model = jTable_Display_Users.getModel();
        
         // Display Slected Row In JTexteFields
        jTextField_Id.setText(model.getValueAt(i,0).toString());

        jTextField_FirstName.setText(model.getValueAt(i,1).toString());

        jTextField_LastName.setText(model.getValueAt(i,2).toString());

        jTextField_Age.setText(model.getValueAt(i,3).toString());
    }//GEN-LAST:event_jTable_Display_UsersMouseClicked

    
   
    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Delete;
    private javax.swing.JButton jButton_Insert;
    private javax.swing.JButton jButton_Update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Display_Users;
    private javax.swing.JTextField jTextField_Age;
    private javax.swing.JTextField jTextField_FirstName;
    private javax.swing.JTextField jTextField_Id;
    private javax.swing.JTextField jTextField_LastName;
    // End of variables declaration//GEN-END:variables
}
