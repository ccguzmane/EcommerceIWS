/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.watson;

import com.ibm.watson.developer_cloud.language_translator.v2.model.Language;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneAnalysis;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Sala204
 */
public class watson extends javax.swing.JFrame {

    /**
     * Creates new form watson
     */
    public watson() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 310, 100));

        jButton1.setText("Enviar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, 70, -1));

        jLabel2.setText(" INGRESE A CONTINUACIÓN SUS COMENTARIOS  ACERCA DEL SERVICIO PRESTADO ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 420, -1));

        jLabel3.setText("SATISFACCIÓN DEL SERVICIO");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, -1, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Aqui es: 
        String entrada = jTextField1.getText();
        WatsonServices watsonServices = new WatsonServices();
        ToneAnalysis analisis = watsonServices.toneAnalyzer(entrada);
        try {
            JSONObject json = new JSONObject(analisis.toString());
            JOptionPane.showMessageDialog(null,analisis);
//        System.out.println(watsonServices.naturalLanguageUnderstanding(entrada).getSentiment());
//        System.out.println(watsonServices.naturalLanguageUnderstanding(entrada).getKeywords());
//        System.out.println(watsonServices.naturalLanguageUnderstanding(entrada).getSemanticRoles());
        } catch (JSONException ex) {
            Logger.getLogger(watson.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTextField1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new watson().setVisible(true);
            }
        });
        
        //Creación de la instancia de la clase de servicios watson
//        WatsonServices watsonServices = new WatsonServices();
//
//        //Servicio de traducción
//        System.out.println("----SERVICIO DE TRADUCCIÓN----");
//        String texto = "Buenas tardes, esto es una prueba para la traducción de texto.";
//        String texto2 = "This is a Watson test.";
//        String traduccion = watsonServices.translate(texto, Language.SPANISH, Language.ENGLISH);
//        String traduccion2 = watsonServices.translate(texto2, Language.ENGLISH, Language.SPANISH);
//        //System.out.println(traduccion);
//        //System.out.println(traduccion2);
//
//        WatsonServices watsonServices = new WatsonServices();
//
//        //Servicio de analisis de lenguaje natural
//        System.out.println("----SERVICIO DE PLN----");
//        String textoPLN = "Joseph is really concerned, because he has to pay his debts.";
//        String textoPLN2 = "I like the product because the service was really really good and I'm in love with that";
//        
//        System.out.println(watsonServices.naturalLanguageUnderstanding(textoPLN2));
//        
//
//        //Servicio de analisis de voz a texto
//        System.out.println("----SERVICIO DE VOZ A TEXTO----");
//        //System.out.println(watsonServices.speachToText("src/calor.ogg"));
//
//        //Servicio de tone analyzer
//        System.out.println("----SERVICIO ANALISIS DE MATICES (TONE)----");
//        String toneText
//                = "I know the times are difficult! Our sales have been "
//                + "disappointing for the past three quarters for our data analytics "
//                + "product suite. We have a competitive data analytics product "
//                + "suite in the industry. But we need to do our job selling it! "
//                + "We need to acknowledge and fix our sales challenges. "
//                + "We can’t blame the economy for our lack of execution! "
//                + "We are missing critical sales opportunities. "
//                + "Our product is in no way inferior to the competitor products. "
//                + "Our clients are hungry for analytical tools to improve their "
//                + "business outcomes. Economy has nothing to do with it.";
//        System.out.println(watsonServices.toneAnalyzer(toneText));
//
//        //Servicio de ideas personales
//        System.out.println("----SERVICIO PERSONALIDAD----");
//        String imagen = "src/cocacola.jpg";
////        try {
////            System.out.println(watsonServices.visualRecognition(imagen));
////        } catch (FileNotFoundException ex) {
////            Logger.getLogger(watson.class.getName()).log(Level.SEVERE, null, ex);
////        }
//
//        //Servicio de reconocimiento visual
//        System.out.println("----SERVICIO RECONOCIMIENTO VISUAL----");
//        String personalityText = "Call me Ishmael. Some years ago-never mind how long precisely-having "
//                + "little or no money in my purse, and nothing particular to interest me on shore, "
//                + "I thought I would sail about a little and see the watery part of the world. "
//                + "It is a way I have of driving off the spleen and regulating the circulation. "
//                + "Whenever I find myself growing grim about the mouth; whenever it is a damp, "
//                + "drizzly November in my soul; whenever I find myself involuntarily pausing before "
//                + "coffin warehouses, and bringing up the rear of every funeral I meet; and especially "
//                + "whenever my hypos get such an upper hand of me, that it requires a strong moral "
//                + "principle to prevent me from deliberately stepping into the street, and methodically "
//                + "knocking people's hats off-then, I account it high time to get to sea as soon as I can. "
//                + "This is my substitute for pistol and ball. With a philosophical flourish Cato throws himself "
//                + "upon his sword; I quietly take to the ship. There is nothing surprising in this. "
//                + "If they but knew it, almost all men in their degree, some time or other, cherish "
//                + "very nearly the same feelings towards the ocean with me. There now is your insular "
//                + "city of the Manhattoes, belted round by wharves as Indian isles by coral reefs-commerce surrounds ";
        //System.out.println(watsonServices.personalInsights(personalityText));
        
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
            java.util.logging.Logger.getLogger(watson.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(watson.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(watson.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(watson.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
