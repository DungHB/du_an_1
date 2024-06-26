package view;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.NguoiDung;
import service.Impl.NguoiDungServiceImpl;
import service.NguoiDungService;

public class QuenMKView extends javax.swing.JFrame {

    ArrayList<NguoiDung> list = new ArrayList<>();
    NguoiDungService qlnd = new NguoiDungServiceImpl();

    public QuenMKView() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnLayPass = new javax.swing.JButton();
        txtTenDN = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        lblQuayLai = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Source Code Pro", 0, 18)); // NOI18N
        jLabel1.setText("Forgot password");

        jLabel2.setText("Tên đăng nhập");

        jLabel3.setText("Số điện thoại");

        btnLayPass.setBackground(new java.awt.Color(0, 204, 255));
        btnLayPass.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLayPass.setForeground(new java.awt.Color(255, 255, 255));
        btnLayPass.setText("Lấy lại mật khẩu");
        btnLayPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLayPassActionPerformed(evt);
            }
        });

        lblQuayLai.setText("Quay lại đăng nhập");
        lblQuayLai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQuayLaiMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSDT, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                            .addComponent(txtTenDN))))
                .addGap(78, 78, 78))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblQuayLai)
                .addGap(16, 16, 16)
                .addComponent(btnLayPass)
                .addGap(90, 90, 90))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTenDN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLayPass)
                    .addComponent(lblQuayLai))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void btnLayPassActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        String tenDN = txtTenDN.getText().trim();
        String sdt = txtSDT.getText().trim();
        list = qlnd.fogotPassword(tenDN, sdt);
        System.out.println(list);
        if (list.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Sai Tên đăng nhập hoặc số điện thoại!");
        } else if (list.size() == 1 && list.get(0).getTenDN().equals(tenDN) && list.get(0).getSdt().equals(sdt)) {
            JOptionPane.showMessageDialog(this, "Mật khẩu của bạn là : " + list.get(0).getMatKhau());
        }
    }                                          

    private void lblQuayLaiMouseClicked(java.awt.event.MouseEvent evt) {                                        
        // TODO add your handling code here:
        LoginView lgv = new LoginView();
        this.setVisible(false);
        lgv.setVisible(true);
    }                                       

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuenMKView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuenMKView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuenMKView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuenMKView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuenMKView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnLayPass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblQuayLai;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenDN;
    // End of variables declaration                   
}
