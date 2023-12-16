/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package library;

import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ReturnBook extends javax.swing.JFrame {

    
    public ReturnBook() {
        initComponents();
        Connect();
        ReturnBook_Load();
        
    }
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public void Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/library","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReturnBook.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ReturnBook.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
 
    public void ReturnBook_Load() {
        int c;
        try {
            pst = con.prepareStatement("select * from returnbook");
            rs = pst.executeQuery();
            
            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            
            DefaultTableModel d = (DefaultTableModel)jTable1.getModel();
            d.setRowCount(0);
            
            while(rs.next()) {
                Vector v2 = new Vector();
                
                for(int i=1; i<=c; i++) {
                    v2.add(rs.getString("ID"));
                    v2.add(rs.getString("MemID"));
                    v2.add(rs.getString("MemName"));
                    v2.add(rs.getString("Bname"));
                    v2.add(rs.getString("Rdate"));
                    v2.add(rs.getString("Elp"));
                    v2.add(rs.getString("Fine"));
                    
                }
                
                d.addRow(v2);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ReturnBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMID = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMname = new javax.swing.JLabel();
        txtBook = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtElp = new javax.swing.JTextField();
        txtFine = new javax.swing.JTextField();
        txtRdate = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Return Book");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Member ID");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Member Name");

        txtMID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMIDActionPerformed(evt);
            }
        });
        txtMID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMIDKeyPressed(evt);
            }
        });

        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("UPDATE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("DELETE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("CANCEL");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Member ID", "Member Name", "Book", "Return Date", "Elapsed Days", "Fine"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Return Date");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Book");

        txtMname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtMname.setForeground(new java.awt.Color(255, 255, 255));

        txtBook.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtBook.setForeground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Days Elap");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Fine");

        txtRdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtRdate.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6)))
                            .addComponent(jLabel4)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(70, 70, 70)
                                .addComponent(jButton2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addGap(70, 70, 70)
                                .addComponent(jButton4))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtRdate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtFine, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtElp, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtBook, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtMname, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtMID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(jLabel1)))
                .addGap(54, 54, 54)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtMID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtMname))
                                .addGap(49, 49, 49))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtBook)
                                .addComponent(jLabel6)))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRdate)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtElp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtFine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        String mid = txtMID.getText();
        String memname = txtMname.getText();
        String bookname = txtBook.getText();
        String returndate = txtRdate.getText();
        String elpdays = txtElp.getText();
        String fine = txtFine.getText();
        
        try {
            // Prepare a SQL statement for inserting data into the "category" table
            pst = con.prepareStatement("insert into returnbook(MemID, MemName, Bname, Rdate, Elp, Fine)values(?,?,?,?,?,?)"); 
            
            // Set the values for the placeholders (?) in the SQL statement
            pst.setString(1,mid);
            pst.setString(2,memname);
            pst.setString(3,bookname);
            pst.setString(4,returndate);
            pst.setString(5,elpdays);
            pst.setString(6,fine);
            
            
            // Execute the SQL statement and get the number of affected rows
            int k = pst.executeUpdate();
            
            pst = con.prepareStatement("delete from lendbook where MemberID = ?");
            pst.setString(1,mid);
            pst.executeUpdate();
            
            if(k==1) {
                // Display a success message in a dialog box
                JOptionPane.showMessageDialog(this,"Book returned!");
                
                // Clear the text field for category, reset the combo box, and set focus to the category text field
                txtMID.setText("");
                txtMname.setText("");
                txtBook.setText("");
                txtRdate.setText("");
                txtElp.setText("");
                txtFine.setText("");
                txtMID.requestFocus();
               
                ReturnBook_Load();
                
            }
            else {
                JOptionPane.showMessageDialog(this,"Error");
            }
            
        } catch (SQLException ex) {
            // Log the exception and print the stack trace for better error handling
            Logger.getLogger(ReturnBook.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace(); // Add this line for better error handling
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    
    private void txtMIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMIDActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
        int selectIndex  = jTable1.getSelectedRow();
        
        int id = Integer.parseInt(d1.getValueAt(selectIndex,0).toString());
        txtMID.setText(d1.getValueAt(selectIndex, 1).toString());
        txtMname.setText(d1.getValueAt(selectIndex, 2).toString());
        txtBook.setText(d1.getValueAt(selectIndex, 3).toString());
        txtRdate.setText(d1.getValueAt(selectIndex, 4).toString());
        txtElp.setText(d1.getValueAt(selectIndex, 5).toString());
        txtFine.setText(d1.getValueAt(selectIndex, 6).toString());
               
        jButton1.setEnabled(false);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
        int selectIndex  = jTable1.getSelectedRow();
        
        int id = Integer.parseInt(d1.getValueAt(selectIndex,0).toString());
        
        String mid = txtMID.getText();
        String memname = txtMname.getText();
        String bookname = txtBook.getText();
        String returndate = txtRdate.getText();
        String elpdays = txtElp.getText();
        String fine = txtFine.getText();
        
        try {
            // Prepare a SQL statement for inserting data into the "category" table
            pst = con.prepareStatement("update publisher set MemID = ?, MemName = ?, Bname = ?, Rdate = ?, Elp = ?, Fine = ? where id = ?"); 
            
            // Set the values for the placeholders (?) in the SQL statement
            pst.setString(1,mid);
            pst.setString(2,memname);
            pst.setString(3,bookname);
            pst.setString(4,returndate);
            pst.setString(5,elpdays);
            pst.setString(6,fine);
            
            // Execute the SQL statement and get the number of affected rows
            int k = pst.executeUpdate();
            
            if(k==1) {
                // Display a success message in a dialog box
                JOptionPane.showMessageDialog(this,"Return book updated");
                
                // Clear the text field for category, reset the combo box, and set focus to the category text field
                txtMID.setText("");
                txtMname.setText("");
                txtBook.setText("");
                txtRdate.setText("");
                txtElp.setText("");
                txtFine.setText("");
                txtMID.requestFocus();
                
                jButton1.setEnabled(true);
                
                ReturnBook_Load();
                
            }
            else {
                JOptionPane.showMessageDialog(this,"Error");
            }
            
        } catch (SQLException ex) {
            // Log the exception and print the stack trace for better error handling
            Logger.getLogger(ReturnBook.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace(); // Add this line for better error handling
        }

        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
        int selectIndex  = jTable1.getSelectedRow();
        
        int id = Integer.parseInt(d1.getValueAt(selectIndex,0).toString());
        
        try {
            // Prepare a SQL statement for inserting data into the "category" table
            pst = con.prepareStatement("delete from returnbook where id = ?"); 
            
            // Set the values for the placeholders (?) in the SQL statement
            
            pst.setInt(1, id);
            
            // Execute the SQL statement and get the number of affected rows
            int k = pst.executeUpdate();
            
            if(k==1) {
                // Display a success message in a dialog box
                JOptionPane.showMessageDialog(this,"Record Deleted");
                
                // Clear the text field for category, reset the combo box, and set focus to the category text field
                txtMID.setText("");
                txtMname.setText("");
                txtBook.setText("");
                txtRdate.setText("");
                txtElp.setText("");
                txtFine.setText("");
                txtMID.requestFocus();
                
                jButton1.setEnabled(true);
                
                ReturnBook_Load();
                
            }
            else {
                JOptionPane.showMessageDialog(this,"Error");
            }
            
        } catch (SQLException ex) {
            // Log the exception and print the stack trace for better error handling
            Logger.getLogger(ReturnBook.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace(); // Add this line for better error handling
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtMIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMIDKeyPressed
        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String id = txtMID.getText();
        
        try {
            pst = con.prepareStatement("select m.Name, b.Bname, I.ReturnDate, DATEDIFF(now(),I.ReturnDate) as elap from lendbook I JOIN member m ON I.MemberID = m.ID JOIN book b ON I.BookID = b.ID and I.MemberID = ?");
            pst.setString(1, id);
            rs = pst.executeQuery();
            
            if(rs.next() == false) {
                JOptionPane.showMessageDialog(this, "Member ID not found");
            }
            else {
                String mname = rs.getString("m.Name");
                String bname = rs.getString("b.Bname");
                
                txtMname.setText(mname.trim());
                txtBook.setText(bname.trim());
                
                String date = rs.getString("I.ReturnDate");
                
                txtRdate.setText(date);
                
                String elp = rs.getString("elap");
                
                int elaped = Integer.parseInt(elp);
                
                if(elaped > 0) {
                    txtElp.setText(elp);
                    int fine = elaped * 100;
                    txtFine.setText(String.valueOf(fine));
                }
                else {
                    txtElp.setText("0");
                    txtFine.setText("0");
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ReturnBook.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        
    }//GEN-LAST:event_txtMIDKeyPressed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReturnBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel txtBook;
    private javax.swing.JTextField txtElp;
    private javax.swing.JTextField txtFine;
    private javax.swing.JTextField txtMID;
    private javax.swing.JLabel txtMname;
    private javax.swing.JLabel txtRdate;
    // End of variables declaration//GEN-END:variables

    /*private void Connect() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }*/
}
