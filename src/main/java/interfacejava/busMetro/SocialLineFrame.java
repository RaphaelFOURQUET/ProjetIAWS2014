package interfacejava.busMetro;

import busMetro.SocialLine;
import busMetro.service.ChoixLigneService;

/**
*
* @author Raphaël
*/
@SuppressWarnings("serial")
public class SocialLineFrame extends javax.swing.JFrame {
	
	private SocialLine currentChoice = null;

   /**
    * Creates new form ChooseLineDestFrame
    */
   public SocialLineFrame() {
       initComponents();
   }

   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   
   // <editor-fold defaultstate="collapsed" desc="Generated Code">
   private void initComponents() {

       jPanel1 = new javax.swing.JPanel();
       jScrollPane1 = new javax.swing.JScrollPane();
       jTextPane1 = new javax.swing.JTextPane();
       lineDestScrollPane = new javax.swing.JScrollPane();
       SocialLineTable = new javax.swing.JTable();
       likeButton = new javax.swing.JButton();
       jScrollPane2 = new javax.swing.JScrollPane();
       triTextPane = new javax.swing.JTextPane();
       numeroLigneTextField = new javax.swing.JTextField();
       unlikeButton = new javax.swing.JButton();

       setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

       jTextPane1.setText("Votez pour une ligne.");
       jTextPane1.setEditable(false);
       jScrollPane1.setViewportView(jTextPane1);

       SocialLineTable.setModel(new ModeleDynamiqueSocialLine());
       SocialLineTable.addMouseListener(new java.awt.event.MouseAdapter() {
           public void mouseClicked(java.awt.event.MouseEvent evt) {
               SocialLineTableMouseClicked(evt);
           }
       });
       lineDestScrollPane.setViewportView(SocialLineTable);

       likeButton.setText("Like");
       likeButton.setEnabled(false);
       likeButton.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               likeButtonActionPerformed(evt);
           }
       });

       triTextPane.setEditable(false);
       triTextPane.setText("Filtrer selon numero de ligne :");
       jScrollPane2.setViewportView(triTextPane);

       numeroLigneTextField.addKeyListener(new java.awt.event.KeyAdapter() {
           public void keyReleased(java.awt.event.KeyEvent evt) {
               numeroLigneTextFieldKeyReleased(evt);
           }
       });

       unlikeButton.setText("Unlike");
       unlikeButton.setEnabled(false);
       unlikeButton.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               unlikeButtonActionPerformed(evt);
           }
       });

       javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
       jPanel1.setLayout(jPanel1Layout);
       jPanel1Layout.setHorizontalGroup(
           jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(jPanel1Layout.createSequentialGroup()
               .addContainerGap()
               .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                   .addComponent(jScrollPane1)
                   .addComponent(lineDestScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                   .addGroup(jPanel1Layout.createSequentialGroup()
                       .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addGap(18, 18, 18)
                       .addComponent(numeroLigneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addGap(0, 105, Short.MAX_VALUE))
                   .addGroup(jPanel1Layout.createSequentialGroup()
                       .addComponent(likeButton)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                       .addComponent(unlikeButton)))
               .addContainerGap())
       );
       jPanel1Layout.setVerticalGroup(
           jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(jPanel1Layout.createSequentialGroup()
               .addContainerGap()
               .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGap(18, 18, 18)
               .addComponent(lineDestScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
               .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                   .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                   .addComponent(numeroLigneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
               .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                   .addComponent(likeButton)
                   .addComponent(unlikeButton)))
       );

       javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
       getContentPane().setLayout(layout);
       layout.setHorizontalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
       );
       layout.setVerticalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(layout.createSequentialGroup()
               .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGap(0, 14, Short.MAX_VALUE))
       );

       pack();
   }// </editor-fold>

   private void SocialLineTableMouseClicked(java.awt.event.MouseEvent evt) {                                           
	   int ligne;
       ligne = SocialLineTable.getSelectedRow();
       currentChoice = lineToChoice(ligne);
       setButtonsEnabled(true);
   }
   
   private SocialLine lineToChoice(int ligne) {
 	  
      SocialLine res = new SocialLine();
      res.setLineId((String) SocialLineTable.getValueAt(ligne, 0));
      res.setLineName((String) SocialLineTable.getValueAt(ligne, 1));
      res.setShortName((String) SocialLineTable.getValueAt(ligne, 2));
      res.setCptLike((Integer) SocialLineTable.getValueAt(ligne, 3));
      res.setCptUnlike((Integer) SocialLineTable.getValueAt(ligne, 4));

      return res;
   }

   private void likeButtonActionPerformed(java.awt.event.ActionEvent evt) {
	   setButtonsEnabled(false);
	   //MAJ BD
	   ChoixLigneService cls = new ChoixLigneService();
	   cls.majLike(currentChoice);
	   //mettre le modele à jour
	   SocialLineTable.setModel(new ModeleDynamiqueSocialLine(numeroLigneTextField.getText()));
   }                                               

   private void numeroLigneTextFieldKeyReleased(java.awt.event.KeyEvent evt) {
	   setButtonsEnabled(false);
       SocialLineTable.setModel(new ModeleDynamiqueSocialLine(numeroLigneTextField.getText()));
   }                                                

   private void unlikeButtonActionPerformed(java.awt.event.ActionEvent evt) {
	   setButtonsEnabled(false);
	   //MAJ BD
	   ChoixLigneService cls = new ChoixLigneService();
	   cls.majUnlike(currentChoice);
	   //mettre le modele à jour
	   SocialLineTable.setModel(new ModeleDynamiqueSocialLine(numeroLigneTextField.getText()));
   }

   private void setButtonsEnabled(boolean b) {
       likeButton.setEnabled(b);
       unlikeButton.setEnabled(b);
   }
   
   /**
    * @param args the command line arguments
    */
   public static void main(String args[]) {
       /*
        * Set the Nimbus look and feel
        */
       //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
       /*
        * If Nimbus (introduced in Java SE 6) is not available, stay with the
        * default look and feel. For details see
        * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
        */
       try {
           for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
               if ("Nimbus".equals(info.getName())) {
                   javax.swing.UIManager.setLookAndFeel(info.getClassName());
                   break;
               }
           }
       } catch (ClassNotFoundException ex) {
           java.util.logging.Logger.getLogger(SocialLineFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (InstantiationException ex) {
           java.util.logging.Logger.getLogger(SocialLineFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (IllegalAccessException ex) {
           java.util.logging.Logger.getLogger(SocialLineFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (javax.swing.UnsupportedLookAndFeelException ex) {
           java.util.logging.Logger.getLogger(SocialLineFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       }
       //</editor-fold>

       /*
        * Create and display the form
        */
       java.awt.EventQueue.invokeLater(new Runnable() {

           public void run() {
               new SocialLineFrame().setVisible(true);
           }
       });
   }
   // Variables declaration - do not modify
   private javax.swing.JTable SocialLineTable;
   private javax.swing.JPanel jPanel1;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JScrollPane jScrollPane2;
   private javax.swing.JTextPane jTextPane1;
   private javax.swing.JButton likeButton;
   private javax.swing.JScrollPane lineDestScrollPane;
   private javax.swing.JTextField numeroLigneTextField;
   private javax.swing.JTextPane triTextPane;
   private javax.swing.JButton unlikeButton;
   // End of variables declaration
}
