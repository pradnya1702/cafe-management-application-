/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafe_management_system;

import Common.OpenPdf;
import cafe_management_system.dao.CategoryDao;
import cafe_management_system.dao.ProductDao;
import cafe_management_system.dao.billDao;
import cafe_management_system.model.Category;
import cafe_management_system.model.Product;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Pradnya Jadhav
 */
public class placeOrder extends javax.swing.JFrame
{

    public String userEmail;
    public int billId = 1;
    public int grandTotal =0;
    public int productPrice=0;
    public int productTotal = 0;
    public String mobileNumberPattern = "^[0-9]*$";
    public String emailPattern = "^[a-zA-Z0-9]+[@]+[a-zA-Z0-9]+[.]+[a-zA-Z0-9]+$";
    public placeOrder()
    {
        initComponents();
        setLocationRelativeTo(this);
        jLabel10.setIcon(new ImageIcon("C:\\Users\\Pradnya Jadhav\\Documents\\NetBeansProjects\\src\\main\\mavenproject1\\src\\main\\java\\cafe_management_system\\image\\brownbackground.jpg"));
        btnExit.setIcon(new ImageIcon("C:\\Users\\Pradnya Jadhav\\Documents\\NetBeansProjects\\src\\main\\mavenproject1\\src\\main\\java\\cafe_management_system\\image\\close.png"));
        lblPlaceOrder.setIcon(new ImageIcon("C:\\Users\\Pradnya Jadhav\\Documents\\NetBeansProjects\\src\\main\\mavenproject1\\src\\main\\java\\cafe_management_system\\image\\place order.png"));
        btnClear.setIcon(new ImageIcon("C:\\Users\\Pradnya Jadhav\\Documents\\NetBeansProjects\\src\\main\\mavenproject1\\src\\main\\java\\cafe_management_system\\image\\clear.png"));
        btnAddToCart.setIcon(new ImageIcon("C:\\Users\\Pradnya Jadhav\\Documents\\NetBeansProjects\\src\\main\\mavenproject1\\src\\main\\java\\cafe_management_system\\image\\add to cart.png"));
        btnGenerateBill.setIcon(new ImageIcon("C:\\Users\\Pradnya Jadhav\\Documents\\NetBeansProjects\\src\\main\\mavenproject1\\src\\main\\java\\cafe_management_system\\image\\generate bill & print.png"));
    }
    public placeOrder(String Email )
    {
        initComponents();
        setLocationRelativeTo(this);
        jLabel10.setIcon(new ImageIcon("C:\\Users\\Pradnya Jadhav\\Documents\\NetBeansProjects\\src\\main\\mavenproject1\\src\\main\\java\\cafe_management_system\\image\\brownbackground.jpg"));
        btnExit.setIcon(new ImageIcon("C:\\Users\\Pradnya Jadhav\\Documents\\NetBeansProjects\\src\\main\\mavenproject1\\src\\main\\java\\cafe_management_system\\image\\close.png"));
        lblPlaceOrder.setIcon(new ImageIcon("C:\\Users\\Pradnya Jadhav\\Documents\\NetBeansProjects\\src\\main\\mavenproject1\\src\\main\\java\\cafe_management_system\\image\\place order.png"));
        btnClear.setIcon(new ImageIcon("C:\\Users\\Pradnya Jadhav\\Documents\\NetBeansProjects\\src\\main\\mavenproject1\\src\\main\\java\\cafe_management_system\\image\\clear.png"));
        btnAddToCart.setIcon(new ImageIcon("C:\\Users\\Pradnya Jadhav\\Documents\\NetBeansProjects\\src\\main\\mavenproject1\\src\\main\\java\\cafe_management_system\\image\\add to cart.png"));
        btnGenerateBill.setIcon(new ImageIcon("C:\\Users\\Pradnya Jadhav\\Documents\\NetBeansProjects\\src\\main\\mavenproject1\\src\\main\\java\\cafe_management_system\\image\\generate bill & print.png"));
        txtProductName.setEnabled(false);
        txtProductPrice.setEnabled(false);
        txtTotal.setEnabled(false);
        btnAddToCart.setEnabled(false);
        btnGenerateBill.setEnabled(false);
        JFormattedTextField tf = ((JSpinner.DefaultEditor) jSpinner1.getEditor()).getTextField();
        tf.setEnabled(false);
        userEmail = Email;
              
    }

    public void productNameByCategory(String category)
    {
        DefaultTableModel dtm = (DefaultTableModel)jTable1.getModel();
        dtm.setRowCount(0);
        ArrayList<Product> list = ProductDao.getAllRecords();
        Iterator<Product>itr = list.iterator();
        while(itr.hasNext())
        {
            Product productObj = itr.next();
            dtm.addRow(new Object[]{productObj.getName()});
        }
    }
    
    public void filterProductByName(String name ,String category)
    {
        DefaultTableModel dtm = (DefaultTableModel)jTable1.getModel();
        dtm.setRowCount(0);
        ArrayList<Product> list = ProductDao.filterProductByName(name, category);
        Iterator<Product>itr = list.iterator();
        while(itr.hasNext())
        {
            Product productObj = itr.next();
            dtm.addRow(new Object[]{productObj.getName()});
        }
    }
    
    public void clearProductFields()
    {
        txtProductName.setText("");
        txtProductPrice.setText("");
        jSpinner1.setValue(1);
        txtTotal.setText("");
        btnAddToCart.setEnabled(false);
    }
    
    public void validateField()
    {
        String customerName = txtCustomerName.getText();
        String customerMobileNumber = txtMobileNumber.getText();
        String customerEmail = txtEmail.getText();
        if(!customerEmail.equals("") && customerMobileNumber.matches(mobileNumberPattern) && customerMobileNumber.length() ==10 && customerEmail.matches(emailPattern) && grandTotal>0)
        {
            btnGenerateBill.setEnabled(true);
        }
        else
        {
            btnGenerateBill.setEnabled(false);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        lblPlaceOrder = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCustomerName = new javax.swing.JTextField();
        txtMobileNumber = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtProductName = new javax.swing.JTextField();
        txtProductPrice = new javax.swing.JTextField();
        jSpinner1 = new javax.swing.JSpinner();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnClear = new javax.swing.JButton();
        btnAddToCart = new javax.swing.JButton();
        lblGrandTotal = new javax.swing.JLabel();
        lblAmmount = new javax.swing.JLabel();
        btnGenerateBill = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1360, 720));
        setPreferredSize(new java.awt.Dimension(1360, 720));
        addComponentListener(new java.awt.event.ComponentAdapter()
        {
            public void componentShown(java.awt.event.ComponentEvent evt)
            {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(null);

        lblPlaceOrder.setFont(new java.awt.Font("Aparajita", 1, 24)); // NOI18N
        lblPlaceOrder.setForeground(new java.awt.Color(0, 0, 0));
        lblPlaceOrder.setText("Place Order");
        getContentPane().add(lblPlaceOrder);
        lblPlaceOrder.setBounds(50, 10, 170, 40);

        jLabel1.setFont(new java.awt.Font("Aparajita", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Bill ID : ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(50, 70, 100, 40);

        jLabel2.setFont(new java.awt.Font("Aparajita", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Customer Details :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 120, 130, 22);

        jLabel3.setFont(new java.awt.Font("Aparajita", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Name");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(50, 154, 90, 22);

        jLabel4.setFont(new java.awt.Font("Aparajita", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Mobile Number");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(50, 260, 120, 22);

        jLabel5.setFont(new java.awt.Font("Aparajita", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Email");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(50, 370, 37, 22);

        txtCustomerName.setFont(new java.awt.Font("Aparajita", 1, 18)); // NOI18N
        txtCustomerName.setForeground(new java.awt.Color(0, 0, 0));
        txtCustomerName.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txtCustomerNameActionPerformed(evt);
            }
        });
        txtCustomerName.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                txtCustomerNameKeyReleased(evt);
            }
        });
        getContentPane().add(txtCustomerName);
        txtCustomerName.setBounds(50, 200, 290, 30);

        txtMobileNumber.setFont(new java.awt.Font("Aparajita", 1, 18)); // NOI18N
        txtMobileNumber.setForeground(new java.awt.Color(0, 0, 0));
        txtMobileNumber.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                txtMobileNumberKeyReleased(evt);
            }
        });
        getContentPane().add(txtMobileNumber);
        txtMobileNumber.setBounds(50, 300, 290, 30);

        txtEmail.setFont(new java.awt.Font("Aparajita", 1, 18)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(0, 0, 0));
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                txtEmailKeyReleased(evt);
            }
        });
        getContentPane().add(txtEmail);
        txtEmail.setBounds(50, 420, 290, 30);

        jLabel6.setFont(new java.awt.Font("Aparajita", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Category");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(440, 40, 160, 30);

        jComboBox1.setFont(new java.awt.Font("Aparajita", 1, 18)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(440, 70, 330, 30);

        jLabel7.setFont(new java.awt.Font("Aparajita", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Search");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(440, 140, 100, 30);

        txtSearch.setFont(new java.awt.Font("Aparajita", 1, 18)); // NOI18N
        txtSearch.setForeground(new java.awt.Color(0, 0, 0));
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                txtSearchKeyReleased(evt);
            }
        });
        getContentPane().add(txtSearch);
        txtSearch.setBounds(440, 170, 330, 30);

        jTable1.setFont(new java.awt.Font("Aparajita", 1, 18)); // NOI18N
        jTable1.setForeground(new java.awt.Color(0, 0, 0));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null},
                {null},
                {null},
                {null}
            },
            new String []
            {
                "Products"
            }
        ));
        jTable1.setRowHeight(30);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(440, 220, 330, 430);

        jLabel8.setFont(new java.awt.Font("Aparajita", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Name");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(900, 40, 37, 22);

        jLabel9.setFont(new java.awt.Font("Aparajita", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Price");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(1130, 40, 120, 22);

        txtProductName.setFont(new java.awt.Font("Aparajita", 1, 18)); // NOI18N
        txtProductName.setForeground(new java.awt.Color(0, 0, 0));
        txtProductName.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                txtProductNameKeyReleased(evt);
            }
        });
        getContentPane().add(txtProductName);
        txtProductName.setBounds(890, 60, 170, 30);

        txtProductPrice.setFont(new java.awt.Font("Aparajita", 1, 18)); // NOI18N
        txtProductPrice.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txtProductPrice);
        txtProductPrice.setBounds(1130, 60, 180, 30);

        jSpinner1.setFont(new java.awt.Font("Aparajita", 1, 18)); // NOI18N
        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                jSpinner1StateChanged(evt);
            }
        });
        getContentPane().add(jSpinner1);
        jSpinner1.setBounds(890, 180, 160, 30);

        jTable2.setFont(new java.awt.Font("Aparajita", 1, 18)); // NOI18N
        jTable2.setForeground(new java.awt.Color(0, 0, 0));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Name", "Price", "Quantity", "Total"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(892, 320, 430, 290);

        jLabel12.setFont(new java.awt.Font("Aparajita", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Quantity");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(900, 140, 100, 30);

        jLabel13.setFont(new java.awt.Font("Aparajita", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Total");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(1150, 140, 60, 30);

        txtTotal.setFont(new java.awt.Font("Aparajita", 1, 18)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txtTotal);
        txtTotal.setBounds(1140, 180, 180, 30);

        btnClear.setBackground(new java.awt.Color(0, 0, 0));
        btnClear.setFont(new java.awt.Font("Aparajita", 1, 18)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnClearActionPerformed(evt);
            }
        });
        getContentPane().add(btnClear);
        btnClear.setBounds(940, 240, 140, 40);

        btnAddToCart.setBackground(new java.awt.Color(0, 0, 0));
        btnAddToCart.setFont(new java.awt.Font("Aparajita", 1, 18)); // NOI18N
        btnAddToCart.setForeground(new java.awt.Color(255, 255, 255));
        btnAddToCart.setText("Add to cart");
        btnAddToCart.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAddToCartActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddToCart);
        btnAddToCart.setBounds(1120, 240, 140, 40);

        lblGrandTotal.setFont(new java.awt.Font("Aparajita", 1, 18)); // NOI18N
        lblGrandTotal.setForeground(new java.awt.Color(0, 0, 0));
        lblGrandTotal.setText("Grand Total : ");
        getContentPane().add(lblGrandTotal);
        lblGrandTotal.setBounds(890, 630, 100, 40);

        lblAmmount.setFont(new java.awt.Font("Aparajita", 1, 18)); // NOI18N
        lblAmmount.setForeground(new java.awt.Color(0, 0, 0));
        lblAmmount.setText("Rs. 00");
        getContentPane().add(lblAmmount);
        lblAmmount.setBounds(1010, 630, 70, 40);

        btnGenerateBill.setBackground(new java.awt.Color(0, 0, 0));
        btnGenerateBill.setFont(new java.awt.Font("Aparajita", 1, 18)); // NOI18N
        btnGenerateBill.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerateBill.setText("Generate Bill & Print");
        btnGenerateBill.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnGenerateBillActionPerformed(evt);
            }
        });
        getContentPane().add(btnGenerateBill);
        btnGenerateBill.setBounds(1110, 630, 210, 40);
        getContentPane().add(jLabel11);
        jLabel11.setBounds(100, 70, 110, 40);

        btnExit.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit);
        btnExit.setBounds(1290, 10, 38, 39);
        getContentPane().add(jLabel10);
        jLabel10.setBounds(0, 0, 1360, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtProductNameKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_txtProductNameKeyReleased
    {//GEN-HEADEREND:event_txtProductNameKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductNameKeyReleased

    private void txtCustomerNameActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txtCustomerNameActionPerformed
    {//GEN-HEADEREND:event_txtCustomerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustomerNameActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt)//GEN-FIRST:event_formComponentShown
    {//GEN-HEADEREND:event_formComponentShown
       billId = Integer.parseInt(billDao.getId());
       jLabel11.setText(billDao.getId());
       ArrayList<Category>list = CategoryDao.getAllRecords();
       Iterator<Category>itr = list.iterator();
       while(itr.hasNext())
       {
           Category categoryObj = itr.next();
           jComboBox1.addItem(categoryObj.getName());
       }
       String category =(String) jComboBox1.getSelectedItem();
        productNameByCategory(category);
    }//GEN-LAST:event_formComponentShown

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_txtSearchKeyReleased
    {//GEN-HEADEREND:event_txtSearchKeyReleased
       
        String name = txtSearch.getText();
        if(name.equals(""))
        {
            DefaultTableModel dtm = (DefaultTableModel)jTable1.getModel();
            dtm.setRowCount(0);
            ArrayList<Product> list = ProductDao.getAllRecords();
            Iterator<Product>itr = list.iterator();
            while(itr.hasNext())
            {
               Product productObj = itr.next();
               dtm.addRow(new Object[]{productObj.getName()});
            }            
        }
        String category = (String)jComboBox1.getSelectedItem();
        filterProductByName(name, category);
    }//GEN-LAST:event_txtSearchKeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTable1MouseClicked
    {//GEN-HEADEREND:event_jTable1MouseClicked
       int index = jTable1.getSelectedRow();
       TableModel model = jTable1.getModel();
       String productName = model.getValueAt(index, 0).toString();
       Product product = ProductDao.getProductByname(productName);
       txtProductName.setText(product.getName());
       txtProductPrice.setText(product.getPrice());
       jSpinner1.setValue(1);
       txtTotal.setText(product.getPrice());
       productPrice = Integer.parseInt(product.getPrice());
       productTotal = Integer.parseInt(product.getPrice());
       btnAddToCart.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_jSpinner1StateChanged
    {//GEN-HEADEREND:event_jSpinner1StateChanged
        // TODO add your handling code here:
        int quantity = (Integer)jSpinner1.getValue();
        if(quantity<=1)
        {
            jSpinner1.setValue(1);
            quantity=1;
        }
        productTotal = productPrice * quantity;
        txtTotal.setText(String.valueOf(productTotal));
    }//GEN-LAST:event_jSpinner1StateChanged

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jComboBox1ActionPerformed
    {//GEN-HEADEREND:event_jComboBox1ActionPerformed
       String category = (String)jComboBox1.getSelectedItem();
       productNameByCategory(category);
       
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void btnAddToCartActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAddToCartActionPerformed
    {//GEN-HEADEREND:event_btnAddToCartActionPerformed
        String name = txtProductName.getText();
        String price = txtProductPrice.getText();
        String quantity = String.valueOf(jSpinner1.getValue());
        DefaultTableModel dtm = (DefaultTableModel)jTable2.getModel();
        dtm.addRow(new Object[]{name,price,quantity,productTotal});
        grandTotal = grandTotal + productTotal;
        lblAmmount.setText(String.valueOf("Rs."+grandTotal));
        clearProductFields();
        validateField();
    }//GEN-LAST:event_btnAddToCartActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnClearActionPerformed
    {//GEN-HEADEREND:event_btnClearActionPerformed
        clearProductFields();
    }//GEN-LAST:event_btnClearActionPerformed

    private void txtCustomerNameKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_txtCustomerNameKeyReleased
    {//GEN-HEADEREND:event_txtCustomerNameKeyReleased
       validateField(); // TODO add your handling code here:
    }//GEN-LAST:event_txtCustomerNameKeyReleased

    private void txtMobileNumberKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_txtMobileNumberKeyReleased
    {//GEN-HEADEREND:event_txtMobileNumberKeyReleased
        validateField();// TODO add your handling code here:
    }//GEN-LAST:event_txtMobileNumberKeyReleased

    private void txtEmailKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_txtEmailKeyReleased
    {//GEN-HEADEREND:event_txtEmailKeyReleased
        validateField();// TODO add your handling code here:
    }//GEN-LAST:event_txtEmailKeyReleased

    private void btnGenerateBillActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnGenerateBillActionPerformed
    {//GEN-HEADEREND:event_btnGenerateBillActionPerformed
        String customerName = txtCustomerName.getText();
        String customerMobileNumber = txtMobileNumber.getText();
        String customerEmail = txtEmail.getText();
        SimpleDateFormat dformate = new SimpleDateFormat("dd-mm-yyyy");
        Date date = new Date();
        String todayDate = dformate.format(date);
        String total = String.valueOf( grandTotal);
        String createBy = userEmail;
        Bill bill = new Bill();
        bill.setId(billId);
        bill.setName(customerName);
        bill.setMobileNumber(customerMobileNumber);
        bill.setEmail(customerEmail);
        bill.setDate(todayDate);
        bill.setTotal(total);
        bill.setCreateBy(createBy);
        billDao.save(bill);
        
        String path ="D:\\";
        com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
        try
        {
            PdfWriter.getInstance(doc, new FileOutputStream(path + ""+billId+".pdf"));
            doc.open();
            Paragraph cafeName = new Paragraph("                                             BORCELLE CAFE                    ");
            doc.add(cafeName);
            Paragraph starLine = new Paragraph("______________________________________________________________________________\n");
            doc.add(starLine);
            Paragraph paragraph3  = new Paragraph("\tBill ID :"+billId+"\nCustomer Name:  "+customerName+"\nTotal Paid :"+grandTotal);
            doc.add(paragraph3);
            doc.add(starLine);
            PdfPTable tbl = new PdfPTable(4);
            tbl.addCell("Name");
            tbl.addCell("Price");
            tbl.addCell("Quantity");
            tbl.addCell("Total");
            for(int i = 0 ; i < jTable2.getRowCount() ; i++)
            {
                String n = jTable2.getValueAt(i,0).toString();
                String d = jTable2.getValueAt(i,0).toString();
                String r = jTable2.getValueAt(i,0).toString();
                String q = jTable2.getValueAt(i,0).toString();
                tbl.addCell(n);
                tbl.addCell(d);
                tbl.addCell(r);
                tbl.addCell(q);
                               
             }
            doc.add(new Paragraph("\n"));
            doc.add(tbl);
            doc.add(starLine);
            Paragraph thanksMsg = new Paragraph("Thank You, Please visit Again.");
            doc.add(thanksMsg);
            OpenPdf.openById(String.valueOf(billId));
            
            
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "generate bill exception");
        }
        doc.close();
        setVisible(false);
        new placeOrder(createBy).setVisible(true);
    }//GEN-LAST:event_btnGenerateBillActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTable2MouseClicked
    {//GEN-HEADEREND:event_jTable2MouseClicked
        int index = jTable2.getSelectedRow();
        int a = JOptionPane.showConfirmDialog(null, "Do you want to remove this product","Select",JOptionPane.YES_NO_OPTION);
        if(a == 0)
        {
            TableModel model = jTable2.getModel();
            String total = model.getValueAt(index, 3).toString();
            grandTotal = grandTotal- Integer.parseInt(total);
            lblAmmount.setText(String.valueOf(grandTotal));
            lblGrandTotal.setText(String.valueOf(grandTotal));
            ((DefaultTableModel)jTable2.getModel()).removeRow(index);
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnExitActionPerformed
    {//GEN-HEADEREND:event_btnExitActionPerformed

        setVisible(false);// TODO add your handling code here:
        new home().setVisible(true);
    }//GEN-LAST:event_btnExitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(placeOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(placeOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(placeOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(placeOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new placeOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToCart;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnGenerateBill;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblAmmount;
    private javax.swing.JLabel lblGrandTotal;
    private javax.swing.JLabel lblPlaceOrder;
    private javax.swing.JTextField txtCustomerName;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMobileNumber;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtProductPrice;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
