/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package library;

import java.sql.*;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Book extends javax.swing.JFrame {

    
    public Book() {
        initComponents();
        Connect();
        Category();
        Author();
        Publisher();
        Book_Load();
    }
    
    public class CategoryItem {
        int id;
        String name;
        
        public CategoryItem(int id, String name) {
            this.id = id;
            this.name = name;
            
        }
        
        public String toString() {
            return name;
        }
    }
    
    public class AuthorItem {
        int id;
        String name;
        
        public AuthorItem(int id, String name) {
            this.id = id;
            this.name = name;
            
        }
        
        public String toString() {
            return name;
        }
    }
    
    public class PublisherItem {
        int id;
        String name;
        
        public PublisherItem(int id, String name) {
            this.id = id;
            this.name = name;
            
        }
        
        public String toString() {
            return name;
        }
    }
    
    
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public void Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/library","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void Category() {
        try {
            pst = con.prepareStatement("Select * from category");
            rs = pst.executeQuery();
            txtCategory.removeAllItems();
            
            while(rs.next()) {
                txtCategory.addItem(new CategoryItem(rs.getInt(1),rs.getString(2)));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void Author() {
        try {
            pst = con.prepareStatement("Select * from author");
            rs = pst.executeQuery();
            txtAuthor.removeAllItems();
            
            while(rs.next()) {
                txtAuthor.addItem(new AuthorItem(rs.getInt(1),rs.getString(2)));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void Publisher() {
        try {
            pst = con.prepareStatement("Select * from publisher");
            rs = pst.executeQuery();
            txtPublisher.removeAllItems();
            
            while(rs.next()) {
                txtPublisher.addItem(new PublisherItem(rs.getInt(1),rs.getString(2)));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void Book_Load() {
        int c;
        try {
            pst = con.prepareStatement("Select b.ID, b.Bname, c.catname, a.Name, p.Name, b.Contents, b.Pages, b.Edition from book b JOIN Category c On b.Category = c.id JOIN Author a On b.Author = a.id JOIN publisher p On b.publisher = p.ID;");
            rs = pst.executeQuery();
            
            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            
            DefaultTableModel d = (DefaultTableModel)jTable1.getModel();
            d.setRowCount(0);
            
            while(rs.next()) {
                Vector v2 = new Vector();
                
                for(int i=1; i<=c; i++) {
                    v2.add(rs.getString("b.ID"));
                    v2.add(rs.getString("b.Bname"));
                    v2.add(rs.getString("c.catname"));
                    v2.add(rs.getString("a.Name"));
                    v2.add(rs.getString("p.Name"));
                    v2.add(rs.getString("b.Contents"));
                    v2.add(rs.getString("b.Pages"));
                    v2.add(rs.getString("b.Edition"));
                }
                
                d.addRow(v2);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtCategory = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtAuthor = new javax.swing.JComboBox();
        txtPublisher = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtContents = new javax.swing.JTextField();
        txtNo = new javax.swing.JTextField();
        txtEdition = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Book");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Name ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Category");

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
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
                "ID", "Category", "Book Name", "Author", "Publisher", "Contents", "No of Pages", "Edition"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class
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
        jLabel4.setText("Contents");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Publisher");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Author");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("No.of Pages");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Edition");

        txtEdition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEditionActionPerformed(evt);
            }
        });

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
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3)))
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(46, 46, 46)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtEdition, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jButton3)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jButton2)))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jButton1)
                                                .addGap(70, 70, 70)
                                                .addComponent(jButton4))))))
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNo)
                                    .addComponent(txtContents)
                                    .addComponent(txtPublisher, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtName)
                                    .addComponent(txtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(101, 101, 101)))
                .addGap(90, 90, 90)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtContents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEdition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4)
                            .addComponent(jButton1))))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        String bname = txtName.getText();
        CategoryItem citem = (CategoryItem) txtCategory.getSelectedItem();
        AuthorItem aitem = (AuthorItem) txtAuthor.getSelectedItem();
        PublisherItem pitem = (PublisherItem) txtPublisher.getSelectedItem();
        
        String contents = txtContents.getText();
        String pages = txtNo.getText();
        String edition = txtEdition.getText();
        
        try {
            // Prepare a SQL statement for inserting data into the "category" table
            pst = con.prepareStatement("insert into book(Bname, Category, Author, Publisher, Contents, Pages, Edition)values(?,?,?,?,?,?,?)"); 
            
            // Set the values for the placeholders (?) in the SQL statement
            pst.setString(1,bname);
            pst.setInt(2,citem.id);
            pst.setInt(3,aitem.id);
            pst.setInt(4,pitem.id);
            pst.setString(5,contents);
            pst.setString(6,pages);
            pst.setString(7,edition);
            
            
            
            // Execute the SQL statement and get the number of affected rows
            int k = pst.executeUpdate();
            
            if(k==1) {
                // Display a success message in a dialog box
                JOptionPane.showMessageDialog(this,"Book created");
                
                // Clear the text field for category, reset the combo box, and set focus to the category text field
                txtName.setText("");
                txtCategory.setSelectedIndex(-1);
                txtAuthor.setSelectedIndex(-1);
                txtPublisher.setSelectedIndex(-1);
                txtContents.setText("");
                txtNo.setText("");
                txtEdition.setText("");
                
                //Publisher_Load();
                
            }
            else {
                JOptionPane.showMessageDialog(this,"Error");
            }
            
        } catch (SQLException ex) {
            // Log the exception and print the stack trace for better error handling
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace(); // Add this line for better error handling
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    
    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
        int selectIndex  = jTable1.getSelectedRow();
        
        int id = Integer.parseInt(d1.getValueAt(selectIndex,0).toString());
        txtName.setText(d1.getValueAt(selectIndex, 1).toString());
        txtCategory.setSelectedItem(d1.getValueAt(selectIndex, 2).toString());
        txtAuthor.setSelectedItem(d1.getValueAt(selectIndex, 3).toString());
        txtPublisher.setSelectedItem(d1.getValueAt(selectIndex, 4).toString());
        txtContents.setText(d1.getValueAt(selectIndex, 5).toString());
        txtNo.setText(d1.getValueAt(selectIndex, 6).toString());
        txtEdition.setText(d1.getValueAt(selectIndex, 7).toString());
        
        
        jButton1.setEnabled(false);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
        int selectIndex  = jTable1.getSelectedRow();
        
        int id = Integer.parseInt(d1.getValueAt(selectIndex,0).toString());
        
        String name = txtName.getText();
        CategoryItem citem = (CategoryItem) txtCategory.getSelectedItem();
        AuthorItem aitem = (AuthorItem) txtAuthor.getSelectedItem();
        PublisherItem pitem = (PublisherItem) txtPublisher.getSelectedItem();
        String contents = txtContents.getText();
        String nopages = txtNo.getText();
        String edition = txtEdition.getText();
        
        try {
            // Prepare a SQL statement for inserting data into the "category" table
            pst = con.prepareStatement("update book set Bname = ?, Category = ?, Author = ?, Publisher = ?, Contents = ?, Pages = ?, Edition = ? where id = ?"); 
            
            // Set the values for the placeholders (?) in the SQL statement
            pst.setString(1,name);
            pst.setInt(2,citem.id);
            pst.setInt(3,aitem.id);
            pst.setInt(4,pitem.id);
            pst.setString(5,contents);
            pst.setString(6,nopages);
            pst.setString(7,edition);
            pst.setInt(8,id);
            
            
            // Execute the SQL statement and get the number of affected rows
            int k = pst.executeUpdate();
            
            if(k==1) {
                // Display a success message in a dialog box
                JOptionPane.showMessageDialog(this,"Books updated");
                
                // Clear the text field for category, reset the combo box, and set focus to the category text field
                txtName.setText("");
                txtCategory.setSelectedIndex(-1);
                txtAuthor.setSelectedIndex(-1);
                txtPublisher.setSelectedIndex(-1);
                txtContents.setText("");
                txtNo.setText("");
                txtEdition.setText("");
                
                txtName.requestFocus();
                
                jButton1.setEnabled(true);
                
                Book_Load();
                
            }
            else {
                JOptionPane.showMessageDialog(this,"Error");
            }
            
        } catch (SQLException ex) {
            // Log the exception and print the stack trace for better error handling
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
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
            pst = con.prepareStatement("delete from book where id = ?"); 
            
            // Set the values for the placeholders (?) in the SQL statement
            
            pst.setInt(1, id);
            
            // Execute the SQL statement and get the number of affected rows
            int k = pst.executeUpdate();
            
            if(k==1) {
                // Display a success message in a dialog box
                JOptionPane.showMessageDialog(this,"Publisher Deleted");
                
                // Clear the text field for category, reset the combo box, and set focus to the category text field
                
                
                txtName.setText("");
                txtCategory.setSelectedIndex(-1);
                txtAuthor.setSelectedIndex(-1);
                txtPublisher.setSelectedIndex(-1);
                txtContents.setText("");
                txtNo.setText("");
                txtEdition.setText("");
                txtName.requestFocus();
                jButton1.setEnabled(true);
                
                Book_Load();
                
            }
            else {
                JOptionPane.showMessageDialog(this,"Error");
            }
            
        } catch (SQLException ex) {
            // Log the exception and print the stack trace for better error handling
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace(); // Add this line for better error handling
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtEditionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEditionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEditionActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Book().setVisible(true);
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox txtAuthor;
    private javax.swing.JComboBox txtCategory;
    private javax.swing.JTextField txtContents;
    private javax.swing.JTextField txtEdition;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNo;
    private javax.swing.JComboBox txtPublisher;
    // End of variables declaration//GEN-END:variables

    /*private void Connect() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }*/
}
