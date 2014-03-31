/**
 * 
 */
package interfacejava.veloToulouse;

/**
*
* @author Raphaël
*/
@SuppressWarnings("serial")
public class ChooseVeloStationFrame extends javax.swing.JFrame {

   /**
    * Creates new form ChooseVeloStationFrame
    */
   public ChooseVeloStationFrame() {
       initComponents();
   }

   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
   private void initComponents() {

       jPanel1 = new javax.swing.JPanel();
       jScrollPane1 = new javax.swing.JScrollPane();
       jTextPane1 = new javax.swing.JTextPane();
       stationsUPSButton = new javax.swing.JButton();
       AllVeloStations = new javax.swing.JButton();

       setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

       jTextPane1.setText("Choisissez une station de départ.");
       jScrollPane1.setViewportView(jTextPane1);

       stationsUPSButton.setText("Stations Velos UPS");
       stationsUPSButton.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               stationsUPSButtonActionPerformed(evt);
           }
       });

       AllVeloStations.setText("Autres stations");
       AllVeloStations.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               AllVeloStationsActionPerformed(evt);
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
                   .addGroup(jPanel1Layout.createSequentialGroup()
                       .addComponent(stationsUPSButton)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                       .addComponent(AllVeloStations)))
               .addContainerGap())
       );
       jPanel1Layout.setVerticalGroup(
           jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(jPanel1Layout.createSequentialGroup()
               .addContainerGap()
               .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
               .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                   .addComponent(stationsUPSButton)
                   .addComponent(AllVeloStations))
               .addContainerGap())
       );

       javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
       getContentPane().setLayout(layout);
       layout.setHorizontalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
       );
       layout.setVerticalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
       );

       pack();
   }// </editor-fold>                        

   private void stationsUPSButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                  
       new VeloStationFrame().setVisible(true);
   }                                                 

   private void AllVeloStationsActionPerformed(java.awt.event.ActionEvent evt) {                                                
       new AllVeloStationFrame().setVisible(true);
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
           java.util.logging.Logger.getLogger(ChooseVeloStationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (InstantiationException ex) {
           java.util.logging.Logger.getLogger(ChooseVeloStationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (IllegalAccessException ex) {
           java.util.logging.Logger.getLogger(ChooseVeloStationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (javax.swing.UnsupportedLookAndFeelException ex) {
           java.util.logging.Logger.getLogger(ChooseVeloStationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       }
       //</editor-fold>

       /*
        * Create and display the form
        */
       java.awt.EventQueue.invokeLater(new Runnable() {

           public void run() {
               new ChooseVeloStationFrame().setVisible(true);
           }
       });
   }
   // Variables declaration - do not modify                     
   private javax.swing.JButton AllVeloStations;
   private javax.swing.JPanel jPanel1;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JTextPane jTextPane1;
   private javax.swing.JButton stationsUPSButton;
   // End of variables declaration                   
}