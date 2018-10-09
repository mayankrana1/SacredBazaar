
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ProductDetail extends javax.swing.JFrame {

    private int index;
    private ArrayList <productModel> productList;
    public ProductDetail(int index) throws IOException {
        initComponents();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setVisible(true);
        setSize(screenSize);
        setResizable(false);
        this.index=index;
        initialise(index);
    }

    private void initialise(int index){

        productList=AdminMainPage.getProductList();
        brandLabel.setText(productList.get(index).getBrand());
        modelLabel.setText(productList.get(index).getName());
        productIdLabel.setText(Integer.toString(productList.get(index).getProductId()));
        priceTextField.setText(Integer.toString(productList.get(index).getPrice()));
        quantityTextField.setText(Integer.toString(productList.get(index).getQuantity()));
        dateOfManufacture.setText(productList.get(index).getDateOfManufacture());
        offersTextField.setText(Double.toString(productList.get(index).getOffers()));
        
    } 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Back = new javax.swing.JButton();
        base = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jlabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        brandLabel = new javax.swing.JLabel();
        modelLabel = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        priceTextField = new javax.swing.JTextField();
        quantityTextField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        dateOfManufacture = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        offersTextField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        productIdLabel = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        header.setBackground(new java.awt.Color(0, 102, 153));
        header.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setBackground(new java.awt.Color(255, 204, 204));
        jLabel7.setFont(new java.awt.Font("Arial", 1, 28)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Product Information");
        jLabel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jLabel7.setOpaque(true);

        jLabel8.setToolTipText("");

        Back.setBackground(new java.awt.Color(0, 204, 204));
        Back.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Back.setText("Back");
        Back.setToolTipText("");
        Back.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, headerLayout.createSequentialGroup()
                        .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        base.setBackground(new java.awt.Color(153, 153, 255));
        base.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel1.setBackground(new java.awt.Color(204, 255, 204));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Brand");
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jLabel1.setOpaque(true);

        jlabel4.setBackground(new java.awt.Color(204, 255, 204));
        jlabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jlabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlabel4.setText("Name");
        jlabel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jlabel4.setOpaque(true);

        jLabel3.setBackground(new java.awt.Color(204, 255, 204));
        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Price");
        jLabel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jLabel3.setOpaque(true);

        jLabel4.setBackground(new java.awt.Color(204, 255, 204));
        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Quantity");
        jLabel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jLabel4.setOpaque(true);

        jLabel5.setBackground(new java.awt.Color(204, 255, 204));
        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Description");
        jLabel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jLabel5.setOpaque(true);

        jLabel6.setBackground(new java.awt.Color(255, 153, 153));
        jLabel6.setText("Image Lable");
        jLabel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel6.setOpaque(true);

        brandLabel.setBackground(new java.awt.Color(204, 255, 204));
        brandLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        brandLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        brandLabel.setOpaque(true);

        modelLabel.setBackground(new java.awt.Color(204, 255, 204));
        modelLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        modelLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        modelLabel.setOpaque(true);

        jLabel10.setBackground(new java.awt.Color(204, 255, 204));
        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jLabel10.setOpaque(true);

        priceTextField.setBackground(new java.awt.Color(204, 255, 204));
        priceTextField.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        priceTextField.setText("jTextField1");
        priceTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        priceTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceTextFieldActionPerformed(evt);
            }
        });

        quantityTextField.setBackground(new java.awt.Color(204, 255, 204));
        quantityTextField.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        quantityTextField.setText("jTextField2");
        quantityTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel11.setBackground(new java.awt.Color(204, 255, 204));
        jLabel11.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Date of Man.");
        jLabel11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jLabel11.setOpaque(true);

        dateOfManufacture.setBackground(new java.awt.Color(204, 255, 204));
        dateOfManufacture.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        dateOfManufacture.setForeground(new java.awt.Color(51, 51, 51));
        dateOfManufacture.setText("jLabel12");
        dateOfManufacture.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        dateOfManufacture.setOpaque(true);

        jLabel2.setBackground(new java.awt.Color(204, 255, 204));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("% Discount");
        jLabel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jLabel2.setOpaque(true);

        offersTextField.setBackground(new java.awt.Color(204, 255, 204));
        offersTextField.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        offersTextField.setText("jTextField1");
        offersTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel12.setBackground(new java.awt.Color(204, 255, 204));
        jLabel12.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Product Id");
        jLabel12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jLabel12.setOpaque(true);

        productIdLabel.setBackground(new java.awt.Color(204, 255, 204));
        productIdLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        productIdLabel.setText("jLabel13");
        productIdLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        productIdLabel.setOpaque(true);

        submitButton.setBackground(new java.awt.Color(0, 204, 204));
        submitButton.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        submitButton.setText("Submit");
        submitButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout baseLayout = new javax.swing.GroupLayout(base);
        base.setLayout(baseLayout);
        baseLayout.setHorizontalGroup(
            baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(baseLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(modelLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(priceTextField)
                    .addComponent(quantityTextField)
                    .addComponent(dateOfManufacture, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(brandLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(offersTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(productIdLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(73, 73, 73)
                .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(baseLayout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(baseLayout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        baseLayout.setVerticalGroup(
            baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(baseLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(productIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(baseLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(baseLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(baseLayout.createSequentialGroup()
                        .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(brandLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                        .addGap(20, 20, 20)
                        .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                            .addComponent(modelLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20)
                        .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(priceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(quantityTextField)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                        .addGap(20, 20, 20)
                        .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                            .addComponent(dateOfManufacture, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20)
                        .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(offersTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(102, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(base, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(base, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        new AdminMainPage().setVisible(true);
                try{
            this.dispose();
            }
            catch(NullPointerException e)
            {
                System.out.println(e.getMessage());
            }
    }//GEN-LAST:event_BackActionPerformed

    private void priceTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceTextFieldActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed

        itemDatabase.updateItemDatabaseByProductId(productList.get(index).getName(),Integer.parseInt(priceTextField.getText()),Integer.parseInt(quantityTextField.getText()),productList.get(index).getBrand(),productList.get(index).getCategory(),productList.get(index).getDescription(),productList.get(index).getImagePath(),productList.get(index).getProductId(),Double.parseDouble(offersTextField.getText()),productList.get(index).getDateOfManufacture());
        JOptionPane.showMessageDialog(null, "Update successful!");
    }//GEN-LAST:event_submitButtonActionPerformed

    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JPanel base;
    private javax.swing.JLabel brandLabel;
    private javax.swing.JLabel dateOfManufacture;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jlabel4;
    private javax.swing.JLabel modelLabel;
    private javax.swing.JTextField offersTextField;
    private javax.swing.JTextField priceTextField;
    private javax.swing.JLabel productIdLabel;
    private javax.swing.JTextField quantityTextField;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}
