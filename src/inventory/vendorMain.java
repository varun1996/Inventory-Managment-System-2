package inventory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
//////////////////////////////////////////////////////////////////////////////////////////

public class vendorMain extends javax.swing.JFrame {
 String id;
 JOptionPane jp= new JOptionPane();
    /** Creates new form vendorMain */
    public vendorMain() {
        initComponents();
        int w1=getWidth();
        int h1=getHeight();
        int a=(1024/2)-w1/2;
        int b=(768/2)-h1/2;
        setBounds(a, b, w1, h1);
    }
     /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    ///////////////////////////////////////////////////////////////////////////
    public void vdel(){
       JOptionPane jp=new JOptionPane();
       try{
          Connection con =null;
          ResultSet rs;
          Statement st;
          Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
          con=DriverManager.getConnection("jdbc:odbc:mat");
          st=con.createStatement();
          String cid=jp.showInputDialog(this,"Enter Vendor's ID To Be Deleted.");
          rs=  st.executeQuery("select * from vendor where v_code='"+cid+"'");
          System.out.println("done");
          if(rs.next())
             {
              if(rs.getString("v_code").equals(cid))
                 {

                 int k=  jp.showConfirmDialog(this, "ARE YOU SURE","confirm",2);
                 if(k==0)
                    {
                     System.out.println("connection created successfully");
                     st.executeUpdate("delete from vendor where v_code='"+cid+"'");

                     jp.showMessageDialog(this,"Vendor  Deleted Successfully");

            } else if(k==2){}
               else{ jp.showMessageDialog(this, "request denied");
            }

         }

      }
     else jp.showMessageDialog(this,"Vendor ID does not exist");

    }catch(Exception e){JOptionPane jd=new JOptionPane();
    jd.showMessageDialog(this,"error occured");
    System.out.println(e.getMessage());}
    }
/////////////////////////////////////////////////////////////////////////////////

public void srchvndr_byId()
{


    String cid= jp.showInputDialog("Enter Vendor ID");

    if(cid.equals(""))
    {
    jp.showMessageDialog(this,"Enter Vendor ID to procede");

}
   else
    {
        id=cid;
        vid();
    }
    }
///////////////////////////////////////////////////////////////////////////////
    public void vid(){
       try{
        Connection con =null;

    ResultSet rs;
         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
         con=DriverManager.getConnection("jdbc:odbc:mat");
         Statement st=con.createStatement();
         System.out.println("connection created successfully");
         rs=st.executeQuery("select * from vendor where  v_code='"+id+"'");

         System.out.println("done");


         if(rs.next())
           {
                 System.out.println("enabled");


                 fname.setText(rs.getString("f_name"));
                 lname.setText(rs.getString("l_name"));
                 city.setText(rs.getString("city"));
                 address.setText(rs.getString("address"));
                 phno.setText(rs.getString("phone"));
                 pin.setText(rs.getString("pin"));
                 v_code.setText(rs.getString("v_code"));

              jTextField1.setText(rs.getString("state"));

              }
              else
                {
                   jp.showMessageDialog(this,"NO SUCH VENDOR EXIST");
              hide();
                }

} catch(Exception e){System.out.println(e.getMessage());}
    }

////////////////////////////////////////////////////////////////////////////////
 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        savebtn = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        address = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        pin = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        city = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        phno = new javax.swing.JTextField();
        lname = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        v_code = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Vendor Maintenance-Inventory Management System");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(153, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 51, 0)));

        savebtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/OK.gif"))); // NOI18N
        savebtn.setText("SAVE CHANGES");
        savebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebtnActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/close.gif"))); // NOI18N
        jButton3.setText("CANCEL");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("NEW"); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton6.setText("DELETE");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/search-16[1].gif"))); // NOI18N
        jButton5.setText("SEARCH");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .add(jButton4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 86, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jButton5)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jButton6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 86, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 39, Short.MAX_VALUE)
                .add(savebtn)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jButton3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 127, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 26, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jButton5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 26, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jButton3)
                    .add(jButton6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 28, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(savebtn, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 28, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 51, 0)));
        jPanel1.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Algerian", 1, 36));
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setText("VENDOr Maintenance");

        jLabel5.setFont(new java.awt.Font("Bookman Old Style", 1, 14));
        jLabel5.setForeground(new java.awt.Color(255, 51, 0));
        jLabel5.setText("VENDOR INFORMATION");
        jLabel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(255, 51, 255), null, null));

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(95, 95, 95)
                        .add(jLabel1))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(204, 204, 204)
                        .add(jLabel5)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(13, 13, 13)
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel5)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(153, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 51, 0)));
        jPanel2.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Bookman Old Style", 1, 14));
        jLabel6.setText("FIRST NAME");

        fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnameActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Bookman Old Style", 1, 14));
        jLabel8.setText("ADDRESS");

        address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Bookman Old Style", 1, 14));
        jLabel9.setText("PIN");

        pin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pinActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Bookman Old Style", 1, 14));
        jLabel10.setText("CITY");

        city.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cityActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Bookman Old Style", 1, 14));
        jLabel13.setText("PHONE NO.");

        phno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phnoActionPerformed(evt);
            }
        });

        lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Bookman Old Style", 1, 14));
        jLabel7.setText("LAST NAME");

        v_code.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                v_codeActionPerformed(evt);
            }
        });
        v_code.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                v_codeFocusLost(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Bookman Old Style", 1, 14));
        jLabel3.setText("VENDOR CODE");

        jLabel11.setFont(new java.awt.Font("Bookman Old Style", 1, 14));
        jLabel11.setText("STATE");

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(65, 65, 65)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel10)
                    .add(jLabel7)
                    .add(jLabel6)
                    .add(jLabel8)
                    .add(jLabel3))
                .add(30, 30, 30)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, pin)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, city, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                        .add(18, 18, 18)
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel2Layout.createSequentialGroup()
                                .add(jLabel11)
                                .add(44, 44, 44)
                                .add(jTextField1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
                            .add(jPanel2Layout.createSequentialGroup()
                                .add(jLabel13)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(phno, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 109, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                    .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, lname)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, fname)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, v_code, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
                    .add(address, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE))
                .add(70, 70, 70))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(v_code, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3))
                .add(20, 20, 20)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel6)
                    .add(fname, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel7)
                    .add(lname, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel8)
                    .add(address, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(city, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel11))
                        .add(18, 18, 18)
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(pin, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel13)
                            .add(phno, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jLabel10)
                        .add(18, 18, 18)
                        .add(jLabel9))
                    .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(68, 68, 68))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(jPanel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 238, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
// TODO add your handling code here:
    NewVendor vn=new NewVendor();
    vn.setVisible(true);
    setVisible(false);
    
}//GEN-LAST:event_jButton4ActionPerformed

private void savebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebtnActionPerformed
  try{
         Connection con =null;


         String cid=v_code.getText();
         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
         con=DriverManager.getConnection("jdbc:odbc:mat");
         Statement st= con.createStatement();
         System.out.println("connection created successfully");
         String v_id,fnames,lnames,addresss,citys,pins,phones,sta;
         v_id=v_code.getText();
         fnames=fname.getText();
         lnames=lname.getText();
         addresss=address.getText();
         citys=city.getText();
         pins=pin.getText();
         phones=phno.getText();
         sta=jTextField1.getText();
         System.out.println("done");
      
         st.executeUpdate("update vendor set v_code='"+v_id+"',f_name='"+fnames+"',l_name='"+lnames+"',address='"+addresss+"',city='"+citys+"',phone='"+phones+"',state='"+sta+"'where v_code='"+cid+"'");
               
         JOptionPane jp=new JOptionPane();
         jp.showMessageDialog(this,"updated successfully");
          int y=jp.showConfirmDialog(this,"Do u want to modify any other vendor details","Message",jp.YES_NO_OPTION);
      if(y==jp.YES_OPTION)
           {
          v_code.setRequestFocusEnabled(true);
         v_code.setText("");
         fname.setText("");
         lname.setText("");
         address.setText("");
         jTextField1.setText("");
         city.setText("");
         phno.setText("");
         pin.setText("");
      }
 else
      {
              dispose();
 }

    }catch(Exception e){JOptionPane jp=new JOptionPane();
    System.out.println(e.getMessage());
    jp.showMessageDialog(this,"error occured");}
  
}//GEN-LAST:event_savebtnActionPerformed

private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
// TODO add your handling code here:
    dispose();
    srchVndr srch=new srchVndr();
    srch.setVisible(true);
   
}//GEN-LAST:event_jButton5ActionPerformed

private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
// TODO add your handling code here:
   vdel();
}//GEN-LAST:event_jButton6ActionPerformed

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
// TODO add your handling code here:
    dispose();
}//GEN-LAST:event_jButton3ActionPerformed

private void fnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnameActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_fnameActionPerformed

private void addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_addressActionPerformed

private void pinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pinActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_pinActionPerformed

private void cityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cityActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_cityActionPerformed

private void phnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phnoActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_phnoActionPerformed

private void lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_lnameActionPerformed

private void v_codeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_v_codeActionPerformed
    // TODO add your handling code here:
    vid();
}//GEN-LAST:event_v_codeActionPerformed

private void v_codeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_v_codeFocusLost
    // TODO add your handling code here:

}
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    // TODO add your handling code here:

}//GEN-LAST:event_v_codeFocusLost

private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
    // TODO add your handling code here:
     String sp=jp.showInputDialog(this,"enter Vendor id:");
     if(sp.equals(""))
     {
         jp.showMessageDialog(this,"Enter Vendor ID to procede");
     }
    id=sp;
    vid();
}//GEN-LAST:event_formWindowOpened



    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vendorMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JTextField city;
    private javax.swing.JTextField fname;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField lname;
    private javax.swing.JTextField phno;
    private javax.swing.JTextField pin;
    private javax.swing.JButton savebtn;
    private javax.swing.JTextField v_code;
    // End of variables declaration//GEN-END:variables

}