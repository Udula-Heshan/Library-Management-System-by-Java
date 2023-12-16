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

public class IssueBook extends javax.swing.JFrame {

    
    public IssueBook() {
        initComponents();
        Connect();
        book();
        IssueBook_Load();
    }
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public void Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/library","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IssueBook.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(IssueBook.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public class BookItem {
        int id;
        String name;
        
        public BookItem(int id, String name) {
            this.id = id;
            this.name = name;
        }
        
        public String toString() {
            return name;
        }
    }
    
    public void book() {
        try {
            pst = con.prepareStatement("Select * from book");
            rs = pst.executeQuery();
            txtBook.removeAllItems();
            
            while(rs.next()) {
                txtBook.addItem(new BookItem(rs.getInt(1),rs.getString(2)));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void IssueBook_Load() {
        int c;
        try {
            pst = con.prepareStatement("select I.ID, m.Name, b.Bname, I.IssueDate, I.ReturnDate from lendbook I JOIN member m ON I.MemberID = m.id JOIN book b ON I.BookID = b.ID");
            rs = pst.executeQuery();
            
            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            
            DefaultTableModel d = (DefaultTableModel)jTable1.getModel();
            d.setRowCount(0);
            
            while(rs.next()) {
                Vector v2 = new Vector();
                
                for(int i=1; i<=c; i++) {
                    v2.add(rs.getString("I.ID"));
                    v2.add(rs.getString("m.Name"));
                    v2.add(rs.getString("b.Bname"));
                    v2.add(rs.getString("I.IssueDate"));
                    v2.add(rs.getString("I.ReturnDate"));
                    
                }
                
                d.addRow(v2);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(IssueBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtBook = new javax.swing.JComboBox();
        txtMember = new javax.swing.JTextField();
        txtIssueDate = new com.toedter.calendar.JDateChooser();
        txtRdate = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Book");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Member ID");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Member Name");

        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });
        txtID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIDKeyPressed(evt);
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
                "ID", "Member Name", "Book", "Date", "Return Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Date");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Book");

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
                                    .addComponent(jLabel3)))
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(70, 70, 70)
                                .addComponent(jButton2))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtBook, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtMember, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtIssueDate, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtRdate, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addGap(70, 70, 70)
                                .addComponent(jButton4))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(jLabel1)))
                .addGap(54, 54, 54)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtMember, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addGap(3, 3, 3))
                            .addComponent(txtIssueDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtRdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
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
                .addGap(0, 10, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        String mid = txtID.getText();
        BookItem bitem = (BookItem) txtBook.getSelectedItem();
        
        SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");
        String issuedate = date_format.format(txtIssueDate.getDate());
        
        String returndate = date_format.format(txtRdate.getDate());
        
        try {
            // Prepare a SQL statement for inserting data into the "category" table
            pst = con.prepareStatement("insert into lendbook(MemberID, BookID, IssueDate, ReturnDate)values(?,?,?,?)"); 
            
            // Set the values for the placeholders (?) in the SQL statement
            pst.setString(1,mid);
            pst.setInt(2,bitem.id);
            pst.setString(3,issuedate);
            pst.setString(4,returndate);
            
            // Execute the SQL statement and get the number of affected rows
            int k = pst.executeUpdate();
            
            if(k==1) {
                // Display a success message in a dialog box
                JOptionPane.showMessageDialog(this,"Book issued");
                
                // Clear the text field for category, reset the combo box, and set focus to the category text field
                txtID.setText("");
                txtBook.setSelectedIndex(-1);
                txtMember.setText("");
                IssueBook_Load();
                
                //Publisher_Load();
                
            }
            else {
                JOptionPane.showMessageDialog(this,"Error");
            }
            
        } catch (SQLException ex) {
            // Log the exception and print the stack trace for better error handling
            Logger.getLogger(IssueBook.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace(); // Add this line for better error handling
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    
    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
        int selectIndex  = jTable1.getSelectedRow();
        
        int id = Integer.parseInt(d1.getValueAt(selectIndex,0).toString());
        
        //txtID.setInt(d1.getValueAt(selectIndex, 0).toString());
        txtMember.setText(d1.getValueAt(selectIndex, 1).toString());
        txtBook.setSelectedItem(d1.getValueAt(selectIndex, 2).toString());
        
        // Assuming column indices for date fields are 4 and 5
        // Assuming column indices for date fields are 3 and 4
    // Check if the values in columns 3 and 4 are of type java.util.Date
        if (d1.getValueAt(selectIndex, 3) instanceof java.util.Date &&
            d1.getValueAt(selectIndex, 4) instanceof java.util.Date) {

            java.util.Date issueDate = (java.util.Date) d1.getValueAt(selectIndex, 3);
            java.util.Date returnDate = (java.util.Date) d1.getValueAt(selectIndex, 4);

        // Assuming txtIssueDate and txtRdate are instances of JDateChooser
            txtIssueDate.setDate(issueDate);
            txtRdate.setDate(returnDate);
        } else {
        // Handle the case where the data in columns 3 and 4 are not java.util.Date
        // You may want to display an error message or handle it according to your application logic.
            System.err.println("Invalid date format in the table.");
    }


        
        jButton1.setEnabled(false);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
        int selectIndex  = jTable1.getSelectedRow();
        
        int id = Integer.parseInt(d1.getValueAt(selectIndex,0).toString());
        
        String mid = txtID.getText();
        BookItem bitem = (BookItem) txtBook.getSelectedItem();
        
        SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");
        String issuedate = date_format.format(txtIssueDate.getDate());
        
        String returndate = date_format.format(txtRdate.getDate());
        try {
            // Prepare a SQL statement for inserting data into the "category" table
            pst = con.prepareStatement("update lendbook set MemberID = ?, BookID = ?, IssueDate = ?, ReturnDate = ? where id = ?"); 
            
            // Set the values for the placeholders (?) in the SQL statement
            pst.setString(1,mid);
            pst.setInt(2,bitem.id);
            pst.setString(3,issuedate);
            pst.setString(4,returndate);
            
            // Execute the SQL statement and get the number of affected rows
            int k = pst.executeUpdate();
            
            if(k==1) {
                // Display a success message in a dialog box
                JOptionPane.showMessageDialog(this,"Issued book updated");
                
                // Clear the text field for category, reset the combo box, and set focus to the category text field
                txtID.setText("");
                txtBook.setSelectedIndex(-1);
                txtMember.setText("");
                txtID.requestFocus();
                
                jButton1.setEnabled(true);
                
                IssueBook_Load();
                
            }
            else {
                JOptionPane.showMessageDialog(this,"Error");
            }
            
        } catch (SQLException ex) {
            // Log the exception and print the stack trace for better error handling
            Logger.getLogger(IssueBook.class.getName()).log(Level.SEVERE, null, ex);
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
            pst = con.prepareStatement("delete from publisher where id = ?"); 
            
            // Set the values for the placeholders (?) in the SQL statement
            
            pst.setInt(1, id);
            
            // Execute the SQL statement and get the number of affected rows
            int k = pst.executeUpdate();
            
            if(k==1) {
                // Display a success message in a dialog box
                JOptionPane.showMessageDialog(this,"Publisher Deleted");
                
                // Clear the text field for category, reset the combo box, and set focus to the category text field
                txtID.setText("");
                txtAddress.setText("");
                txtPhone.setText("");
                txtID.requestFocus();
                jButton1.setEnabled(true);
                
                Publisher_Load();
                
            }
            else {
                JOptionPane.showMessageDialog(this,"Error");
            }
            
        } catch (SQLException ex) {
            // Log the exception and print the stack trace for better error handling
            Logger.getLogger(IssueBook.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace(); // Add this line for better error handling
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String mid = txtID.getText();
            try {
                pst = con.prepareStatement("select * from member where id = ?");
                pst.setString(1, mid);
                
                rs = pst.executeQuery();
                
                if(rs.next() == false) {
                    JOptionPane.showMessageDialog(this,"Member ID not found");
                }
                else {
                    String membername = rs.getString("Name");
                    txtMember.setText(membername.trim());
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(IssueBook.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_txtIDKeyPressed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox txtBook;
    private javax.swing.JTextField txtID;
    private com.toedter.calendar.JDateChooser txtIssueDate;
    private javax.swing.JTextField txtMember;
    private com.toedter.calendar.JDateChooser txtRdate;
    // End of variables declaration//GEN-END:variables

    /*private void Connect() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }*/
}
