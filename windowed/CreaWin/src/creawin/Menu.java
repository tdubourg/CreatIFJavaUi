/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Menu.java
 *
 * Created on 27 févr. 2012, 16:22:10
 */

package creawin;

import javax.swing.JOptionPane;

/**
 *
 * @author Administrateur
 */
public class Menu extends javax.swing.JFrame {

    /** Creates new form Menu */
    public Menu() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addOeuvreBtn = new javax.swing.JButton();
        addOeuvreLbl = new java.awt.Label();
        seeCatalogBtn = new javax.swing.JButton();
        seeCatalogLbl = new java.awt.Label();
        helpBtn = new javax.swing.JButton();
        helpLbl = new java.awt.Label();
        quitBtn = new javax.swing.JButton();
        quitLbl = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Créat'If - Accueil");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(new java.awt.Color(255, 255, 255));
        setIconImages(null);

        addOeuvreBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/creawin/add.png"))); // NOI18N
        addOeuvreBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        addOeuvreBtn.setBorderPainted(false);
        addOeuvreBtn.setContentAreaFilled(false);
        addOeuvreBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addOeuvreBtnMouseClicked(evt);
            }
        });
        addOeuvreBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addOeuvreBtnActionPerformed(evt);
            }
        });

        addOeuvreLbl.setText("Ajouter Oeuvre");

        seeCatalogBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/creawin/eye.png"))); // NOI18N
        seeCatalogBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        seeCatalogBtn.setBorderPainted(false);
        seeCatalogBtn.setContentAreaFilled(false);
        seeCatalogBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seeCatalogBtnMouseClicked(evt);
            }
        });
        seeCatalogBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seeCatalogBtnActionPerformed(evt);
            }
        });

        seeCatalogLbl.setText("Voir Catalogue");

        helpBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/creawin/help.png"))); // NOI18N
        helpBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        helpBtn.setBorderPainted(false);
        helpBtn.setContentAreaFilled(false);
        helpBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                helpBtnMouseClicked(evt);
            }
        });
        helpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpBtnActionPerformed(evt);
            }
        });

        helpLbl.setAlignment(java.awt.Label.CENTER);
        helpLbl.setText("Aide");

        quitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/creawin/Cross.png"))); // NOI18N
        quitBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        quitBtn.setBorderPainted(false);
        quitBtn.setContentAreaFilled(false);
        quitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quitBtnMouseClicked(evt);
            }
        });
        quitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitBtnActionPerformed(evt);
            }
        });

        quitLbl.setAlignment(java.awt.Label.CENTER);
        quitLbl.setText("Quitter");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(addOeuvreLbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(seeCatalogLbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(helpLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(addOeuvreBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(seeCatalogBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(helpBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 34, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(quitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(quitLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(27, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addOeuvreLbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 28, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(quitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(seeCatalogBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(helpBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addOeuvreBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(quitLbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(helpLbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(seeCatalogLbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addOeuvreBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addOeuvreBtnActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_addOeuvreBtnActionPerformed

    private void seeCatalogBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seeCatalogBtnActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_seeCatalogBtnActionPerformed

    private void helpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpBtnActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_helpBtnActionPerformed

    private void quitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitBtnActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_quitBtnActionPerformed

    private void quitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quitBtnMouseClicked
        System.exit(0);
    }//GEN-LAST:event_quitBtnMouseClicked

    private void helpBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpBtnMouseClicked
        JOptionPane.showMessageDialog(this, "\"Ajouter Oeuvre\" vous permettra d'entrer toutes les informations necessaires à la création d'une oeuvre.\n \"Catalogue\" vous permettra de voir la liste de toutes les oeuvres enregistrées.");
    }//GEN-LAST:event_helpBtnMouseClicked

    private void seeCatalogBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seeCatalogBtnMouseClicked
        CatalogMgr c = new CatalogMgr();
        c.show();
    }//GEN-LAST:event_seeCatalogBtnMouseClicked

    private void addOeuvreBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addOeuvreBtnMouseClicked
	AjoutOeuvre a = new AjoutOeuvre();
	a.show();
    }//GEN-LAST:event_addOeuvreBtnMouseClicked

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addOeuvreBtn;
    private java.awt.Label addOeuvreLbl;
    private javax.swing.JButton helpBtn;
    private java.awt.Label helpLbl;
    private javax.swing.JButton quitBtn;
    private java.awt.Label quitLbl;
    private javax.swing.JButton seeCatalogBtn;
    private java.awt.Label seeCatalogLbl;
    // End of variables declaration//GEN-END:variables

}
