/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import java.awt.Color;
import javax.swing.JOptionPane;
import server.Server;

/**
 *
 * @author Nadja
 */
public class FrmServer extends javax.swing.JFrame {

    Server server;

    /**
     * Creates new form FrmServer
     */
    public FrmServer() {
        initComponents();
        srediFormu();
        setLocationRelativeTo(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        btnPokreni = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        meni_korisnici = new javax.swing.JMenu();
        detalji = new javax.swing.JMenuItem();
        meni_server = new javax.swing.JMenu();
        detalji_porta = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Server - Iznajmljivanje ski opreme");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Server aplikacije");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Status servera: ");

        lblStatus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblStatus.setText("Nije pokrenut!");

        btnPokreni.setText("Pokreni server");
        btnPokreni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPokreniActionPerformed(evt);
            }
        });

        meni_korisnici.setText("Korisnici");

        detalji.setText("Detalji");
        detalji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detaljiActionPerformed(evt);
            }
        });
        meni_korisnici.add(detalji);

        jMenuBar1.add(meni_korisnici);

        meni_server.setText("Server");

        detalji_porta.setText("Detalji porta");
        detalji_porta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detalji_portaActionPerformed(evt);
            }
        });
        meni_server.add(detalji_porta);

        jMenuBar1.add(meni_server);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel2)
                        .addGap(55, 55, 55)
                        .addComponent(lblStatus))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(btnPokreni)))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(btnPokreni)
                .addGap(52, 52, 52))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPokreniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPokreniActionPerformed
        // TODO add your handling code here:
        if (!Server.isAktivan()) {
            server = new Server();
            server.start();
            Server.setAktivan(true);
            btnPokreni.setText("Zaustavi server");
            lblStatus.setText("Pokrenut");
            lblStatus.setForeground(Color.GREEN);
            meni_server.setVisible(false);
            meni_korisnici.setVisible(true);

        } else {
            server.prekiniNiti();
            Server.setAktivan(false);
            btnPokreni.setText("Pokreni server");
            lblStatus.setText("Nije pokrenut!");
            lblStatus.setForeground(Color.RED);
            meni_server.setVisible(true);
            meni_korisnici.setVisible(false);
        }
    }//GEN-LAST:event_btnPokreniActionPerformed

    private void detaljiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detaljiActionPerformed
        // TODO add your handling code here:
        FrmKorisnici fmk = new FrmKorisnici();
        fmk.setVisible(true);
    }//GEN-LAST:event_detaljiActionPerformed

    private void detalji_portaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detalji_portaActionPerformed
        // TODO add your handling code here:
        try{
        String brojPorta = JOptionPane.showInputDialog(rootPane, "Unesite broj porta!");
        Server.brPorta = Integer.parseInt(brojPorta);    
        }catch(Exception e){
            System.out.println("nije izmenjen port");
        }
    }//GEN-LAST:event_detalji_portaActionPerformed

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
            java.util.logging.Logger.getLogger(FrmServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmServer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPokreni;
    private javax.swing.JMenuItem detalji;
    private javax.swing.JMenuItem detalji_porta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JMenu meni_korisnici;
    private javax.swing.JMenu meni_server;
    // End of variables declaration//GEN-END:variables

    private void srediFormu() {
        lblStatus.setForeground(Color.red);
        meni_korisnici.setVisible(false);
    }

}
