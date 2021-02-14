
package Principal;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Principal extends javax.swing.JFrame {
    
    String destinatario;
    String asunto;
    String servidorSMTP;
    String puertodeenvio;
    static File adjunto;
    static String cuerpo;
    
    public Principal() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Bienvenido");
        
        Image imagen = new ImageIcon(getClass().getResource("/Imagenes/imagen.jpg")).getImage();
        label_fondo.setIcon(new ImageIcon(imagen.getScaledInstance(label_fondo.getWidth(), 470, Image.SCALE_DEFAULT)));
    }
    
    public void EnviarMailSimple() {
        try {
            Login e = new Login();
            String gmail=e.migmail.trim();
            String password=e.mipassword.trim();

            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.auth", "true");
            props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

            Session session = Session.getDefaultInstance(props);

            BodyPart texto = new MimeBodyPart();
            texto.setText(cuerpo);

            MimeMultipart multi = new MimeMultipart();
            multi.addBodyPart(texto);

            MimeMessage msm = new MimeMessage(session);
            msm.setFrom(new InternetAddress(destinatario));
            msm.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            msm.setSubject(asunto);
            msm.setText(cuerpo);
            msm.setContent(multi);

            Transport t = session.getTransport("smtp");
            t.connect(gmail,password);
            t.sendMessage(msm, msm.getRecipients(Message.RecipientType.TO));
            t.close();

            JOptionPane.showMessageDialog(null, "Mensaje enviado");
        } catch (AddressException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void EnviarMailComplejo() {
        try {
            Login e = new Login();
            String gmail=e.migmail.trim();
            String password=e.mipassword.trim();
            
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.auth", "true");
            props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

            Session session = Session.getDefaultInstance(props);

            BodyPart archivo = new MimeBodyPart();
            archivo.setDataHandler(new DataHandler(new FileDataSource(adjunto)));
            archivo.setFileName("archivo.adjunto");

            BodyPart texto = new MimeBodyPart();
            texto.setText(cuerpo);

            MimeMultipart multi = new MimeMultipart();
            multi.addBodyPart(archivo);
            multi.addBodyPart(texto);

            MimeMessage msm = new MimeMessage(session);
            msm.setFrom(new InternetAddress(destinatario));
            msm.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            msm.setSubject(asunto);
            msm.setText(cuerpo);
            msm.setContent(multi);

            Transport t = session.getTransport("smtp");
            t.connect(gmail,password);
            t.sendMessage(msm, msm.getRecipients(Message.RecipientType.TO));
            t.close();

            JOptionPane.showMessageDialog(null, "Mensaje enviado");

        } catch (MessagingException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        field_1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        box = new javax.swing.JComboBox<>();
        guardarcontacto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton2_adjunto = new javax.swing.JButton();
        label_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusableWindowState(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Calibri Light", 3, 14)); // NOI18N
        jTextField1.setText("Correo ");
        jTextField1.setBorder(null);
        jTextField1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextField1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField1.setEnabled(false);
        jTextField1.setSelectionColor(new java.awt.Color(255, 255, 255));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 22, 50, 30));

        field_1.setBackground(new java.awt.Color(245, 255, 255));
        field_1.setFont(new java.awt.Font("Calibri Light", 3, 14)); // NOI18N
        field_1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 51, 51), new java.awt.Color(0, 153, 153), new java.awt.Color(0, 51, 153), new java.awt.Color(51, 255, 204)));
        getContentPane().add(field_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 23, 340, 30));

        jTextField3.setEditable(false);
        jTextField3.setFont(new java.awt.Font("Calibri Light", 3, 14)); // NOI18N
        jTextField3.setText("Asunto ");
        jTextField3.setBorder(null);
        jTextField3.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField3.setEnabled(false);
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 50, 30));

        jTextField2.setBackground(new java.awt.Color(245, 255, 255));
        jTextField2.setFont(new java.awt.Font("Calibri Light", 3, 14)); // NOI18N
        jTextField2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 255, 204), new java.awt.Color(51, 0, 153), new java.awt.Color(204, 0, 204)));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 340, 30));

        jButton1.setFont(new java.awt.Font("Calibri Light", 3, 18)); // NOI18N
        jButton1.setText("Enviar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 90, 40));

        box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Contactos", " " }));
        box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxActionPerformed(evt);
            }
        });
        getContentPane().add(box, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 100, 30));

        guardarcontacto.setText("Guardar Contacto");
        guardarcontacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarcontactoActionPerformed(evt);
            }
        });
        getContentPane().add(guardarcontacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, 130, 30));

        jTextArea1.setBackground(new java.awt.Color(245, 255, 255));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Calibri Light", 3, 14)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 153, 153), new java.awt.Color(0, 0, 153), new java.awt.Color(102, 0, 102)));
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 450, 140));

        jButton2_adjunto.setText("Archivo Adjunto");
        jButton2_adjunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2_adjuntoActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2_adjunto, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, 120, 30));
        getContentPane().add(label_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 374));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        destinatario = field_1.getText();
        cuerpo = jTextArea1.getText();
        asunto = jTextField2.getText();
        if (adjunto != null) {
            EnviarMailComplejo();
        } else {
            EnviarMailSimple();
        }
        jTextArea1.setText("");
        jTextField2.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxActionPerformed
        field_1.setText(box.getSelectedItem().toString());
    }//GEN-LAST:event_boxActionPerformed

    private void guardarcontactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarcontactoActionPerformed
        box.addItem(field_1.getText());
        field_1.setText("");
        JOptionPane.showMessageDialog(null, "Contacto guardado exitosamente ");
    }//GEN-LAST:event_guardarcontactoActionPerformed

    private void jButton2_adjuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2_adjuntoActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(this);
        adjunto = fc.getSelectedFile();
        cuerpo = jTextArea1.getText();
        cuerpo += " " + String.valueOf(adjunto.getName());
        jTextArea1.setText(cuerpo);
    }//GEN-LAST:event_jButton2_adjuntoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> box;
    private javax.swing.JTextField field_1;
    private javax.swing.JButton guardarcontacto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2_adjunto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel label_fondo;
    // End of variables declaration//GEN-END:variables
}
