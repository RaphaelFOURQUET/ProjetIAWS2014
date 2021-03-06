/**
 * 
 */
package interfacejava.busMetro;

import javax.swing.JOptionPane;

import busMetro.Destination;
import busMetro.Ligne;
import busMetro.LineDestArret;
import busMetro.service.ChoixLigneService;
import busMetro.service.HoraireDepartService;

/**
 *
 * @author Raphaël
 */
@SuppressWarnings("serial")
public class ChooseLineDestFrame extends javax.swing.JFrame {
	
	private LineDestArret currentChoice = null;

    /**
     * Creates new form ChooseLineDestFrame
     */
    public ChooseLineDestFrame() {
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
        lineDestTable = new javax.swing.JTable();
        rechercheButton = new javax.swing.JButton();
        //
        jScrollPane2 = new javax.swing.JScrollPane();
        triTextPane = new javax.swing.JTextPane();
        numeroLigneTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTextPane1.setEditable(false);
        jTextPane1.setText("Choisissez un départ/ligne/destination.");
        jScrollPane1.setViewportView(jTextPane1);

        lineDestTable.setModel(new ModeleDynamiqueLineDest());
        lineDestTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lineDestTableMouseClicked(evt);
            }
        });
        lineDestScrollPane.setViewportView(lineDestTable);

        rechercheButton.setText("Rechercher le prochain départ.");
        rechercheButton.setEnabled(false);
        rechercheButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rechercheButtonActionPerformed(evt);
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

//        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
//        jPanel1.setLayout(jPanel1Layout);
//        jPanel1Layout.setHorizontalGroup(
//            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(jPanel1Layout.createSequentialGroup()
//                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                    .addGroup(jPanel1Layout.createSequentialGroup()
//                        .addContainerGap()
//                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                            .addComponent(jScrollPane1)
//                            .addComponent(lineDestScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
//                    .addGroup(jPanel1Layout.createSequentialGroup()
//                        .addGap(98, 98, 98)
//                        .addComponent(rechercheButton)
//                        .addGap(0, 111, Short.MAX_VALUE)))
//                .addContainerGap())
//        );
//        jPanel1Layout.setVerticalGroup(
//            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(jPanel1Layout.createSequentialGroup()
//                .addContainerGap()
//                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addGap(18, 18, 18)
//                .addComponent(lineDestScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
//                .addGap(18, 18, 18)
//                .addComponent(rechercheButton)
//                .addContainerGap())
//        );

//        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
//        getContentPane().setLayout(layout);
//        layout.setHorizontalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//        );
//        layout.setVerticalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(layout.createSequentialGroup()
//                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addGap(0, 0, Short.MAX_VALUE))
//        );
//
//        pack();
        
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rechercheButton)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(numeroLigneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 111, Short.MAX_VALUE)))
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
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rechercheButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(numeroLigneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void lineDestTableMouseClicked(java.awt.event.MouseEvent evt) {
        int ligne;
        ligne = lineDestTable.getSelectedRow();
        currentChoice = lineToChoice(ligne);
        setRechercheEnabled(true);
    }

    private void rechercheButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	//recuperer l'horaire depart
    	HoraireDepartService hds = new HoraireDepartService();
    	String horaire = hds.getHoraireDepart(currentChoice.getArretId(), currentChoice.getLine().getLineId(), currentChoice.getDest().getDestinationName());
    	
    	if(!isMetroLine(currentChoice.getLine().getLineId()))
    	{
    		JOptionPane.showMessageDialog( this,
        		"Le prochain départ pour l'arret "+currentChoice.getArretName()+" (ligne "+currentChoice.getLine().getShortName()+") vers "+currentChoice.getDest().getDestinationName()+" est à : "+horaire+" !"
        		, "Prochain départ", JOptionPane.INFORMATION_MESSAGE);
    	}
    	else {//isMetro
    		JOptionPane.showMessageDialog( this,
            		"Le prochain départ pour l'arret "+currentChoice.getArretName()+" (ligne "+currentChoice.getLine().getShortName()+") vers "+currentChoice.getDest().getDestinationName()+" est à :\n" +
            		"Information non disponible pour les métros : en fonctionnement de 5h00 à 00h00 (1h00 le vendredi/samedi) avec des trames toutes les 1 à 10 minutes. !"
            		, "Prochain départ", JOptionPane.INFORMATION_MESSAGE);
    	}
    }

    private boolean isMetroLine(String lineId) {
    	ChoixLigneService cls = new ChoixLigneService();
    	boolean res = cls.isMetroLine(lineId);
		return res;
	}

	private void setRechercheEnabled(boolean b) {
        rechercheButton.setEnabled(b);
    }
     
     /**
      * Retourne le LineDestArret associee a la ligne selectionnee
      * @param ligne ligne jtable selectionnee
      * @return LineDestArret associe à la ligne
      */
      private LineDestArret lineToChoice(int ligne) {
    	  
    	  Destination dest = new Destination();
    	  dest.setDestinationId((String) lineDestTable.getValueAt(ligne, 2));
    	  dest.setDestinationName((String) lineDestTable.getValueAt(ligne, 3));
    	  
    	  Ligne line = new Ligne();
    	  line.setLineId((String) lineDestTable.getValueAt(ligne, 4));
    	  line.setLineName((String) lineDestTable.getValueAt(ligne, 5));
    	  line.setShortName((String) lineDestTable.getValueAt(ligne, 6));
    	  
         LineDestArret res = new LineDestArret(
        		 (String) lineDestTable.getValueAt(ligne, 0), 
        		 (String) lineDestTable.getValueAt(ligne, 1),
        		 dest, line);
         return res;
      }
      
      private void numeroLigneTextFieldKeyReleased(java.awt.event.KeyEvent evt) {
    	  setRechercheEnabled(false);
          lineDestTable.setModel(new ModeleDynamiqueLineDest(numeroLigneTextField.getText()));
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
            java.util.logging.Logger.getLogger(ChooseLineDestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChooseLineDestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChooseLineDestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChooseLineDestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ChooseLineDestFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JScrollPane lineDestScrollPane;
    private javax.swing.JTable lineDestTable;
    private javax.swing.JTextField numeroLigneTextField;
    private javax.swing.JButton rechercheButton;
    private javax.swing.JTextPane triTextPane;
    // End of variables declaration
}
