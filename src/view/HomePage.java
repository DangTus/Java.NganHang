package view;

import view.*;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JOptionPane;
import model.User;
import service.UserService;
import view.user.UserDrawMoney;
import view.user.UserEditPassword;
import view.user.UserInformation;

public class HomePage extends javax.swing.JFrame {

    private UserService userService = null;
    User user = null;

    public HomePage(User user) throws SQLException {

        userService = new UserService();
        this.user = user;

        initComponents();
        //hiển thị tên
        if (user.getRole() == 2) {
            roleLabel.setText("Xin chào người dùng");
        } else if (user.getRole() == 1) {
            roleLabel.setText("Xin chào quản trị");
        }
        nameLabel.setText(user.getName());
        //hiển thị số dư
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat vn = NumberFormat.getInstance(localeVN);
        String soDu = vn.format(user.getSoDu());
        soDuTextField.setText(soDu + " VNĐ");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logoutButton = new javax.swing.JButton();
        roleLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        editPasswordButton = new javax.swing.JButton();
        rutTienButton = new javax.swing.JButton();
        soDuTextField = new javax.swing.JTextField();
        editPasswordButton1 = new javax.swing.JButton();
        nameLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        logoutButton.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        logoutButton.setText("Đăng xuất");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        roleLabel.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        roleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        roleLabel.setText("Xin chào");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Số dư hiện tại");

        editPasswordButton.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        editPasswordButton.setText("Đổi mật khẩu");
        editPasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editPasswordButtonActionPerformed(evt);
            }
        });

        rutTienButton.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        rutTienButton.setText("Rút tiền");
        rutTienButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rutTienButtonActionPerformed(evt);
            }
        });

        soDuTextField.setEditable(false);
        soDuTextField.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        soDuTextField.setMargin(new java.awt.Insets(2, 5, 2, 5));

        editPasswordButton1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        editPasswordButton1.setText("Xem thông tin");
        editPasswordButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editPasswordButton1ActionPerformed(evt);
            }
        });

        nameLabel.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(255, 51, 51));
        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel.setText("name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(soDuTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(logoutButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(nameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(editPasswordButton1)
                        .addGap(29, 29, 29)
                        .addComponent(editPasswordButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rutTienButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(roleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(soDuTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rutTienButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editPasswordButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editPasswordButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muôn đăng xuất không?", "Thông báo", JOptionPane.YES_NO_OPTION);
        if (confirm == 0) {
            new Login().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void editPasswordButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editPasswordButton1ActionPerformed
        // TODO add your handling code here:
        new UserInformation(user).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_editPasswordButton1ActionPerformed

    private void editPasswordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editPasswordButtonActionPerformed
        // TODO add your handling code here:
        new UserEditPassword(user).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_editPasswordButtonActionPerformed

    private void rutTienButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rutTienButtonActionPerformed
        // TODO add your handling code here:
        new UserDrawMoney(user).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_rutTienButtonActionPerformed

    public static void main(String[] args) {
        new Login().setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton editPasswordButton;
    private javax.swing.JButton editPasswordButton1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton logoutButton;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel roleLabel;
    private javax.swing.JButton rutTienButton;
    private javax.swing.JTextField soDuTextField;
    // End of variables declaration//GEN-END:variables
}
