package kdk10_lab4;

import com.spire.doc.Document;
import com.spire.doc.FileFormat;
import java.awt.Cursor;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.hwpf.HWPFDocument;

public class ReceiptWord extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

    class TThread1 extends Thread {

        public void run() {
            String dir = new File(".").getAbsoluteFile().getParentFile().getAbsolutePath()
                    + System.getProperty("file.separator");

            // Чтение из файла-шаблона в переменную doc
            HWPFDocument doc = null;
            try ( FileInputStream fis = new FileInputStream(dir + "receipt_template.doc")) {
                doc = new HWPFDocument(fis);
                fis.close();
            } catch (Exception ex) {
                System.err.println("Error template!");
            }

            // Замена в переменной doc данных
            try {
                doc.getRange().replaceText("$ФИОпокупателя", jTextField_FIO.getText());
                doc.getRange().replaceText("$АДРЕСпоставщика", jTextField_Adres.getText());
            } catch (Exception ex) {
                System.err.println("Error replaceText!");
            }

            // Сохранение переменной doc в новый файл
            try ( FileOutputStream fos = new FileOutputStream(dir + "receipt.doc")) {
                doc.write(fos);
                fos.close();

                Document document = new Document();
                document.loadFromFile("receipt.doc");

                //Сохранить как PDF
                document.saveToFile("outedDoc.pdf", FileFormat.PDF);

                // Открытие файла внешней программой
                if (System.getProperty("os.name").equals("Linux")
                        && System.getProperty("java.vendor").startsWith("Red Hat")) {
                    new ProcessBuilder("xdg-open", dir + "receipt.doc").start();
                } else {
                    Desktop.getDesktop().open(new File(dir + "outedDoc.pdf"));
                }
            } catch (Exception ex) {
                System.err.println("Error getDesktop!");
            }
            setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        }
    }

    class TThread2 extends Thread {

        public void run() {
            String dir = new File(".").getAbsoluteFile().getParentFile().getAbsolutePath()
                    + System.getProperty("file.separator");

            // Чтение из файла-шаблона в переменную doc
            HWPFDocument doc = null;
            try ( FileInputStream fis = new FileInputStream(dir + "receipt_template.doc")) {
                doc = new HWPFDocument(fis);
                fis.close();
            } catch (Exception ex) {
                System.err.println("Error template!");
            }

            // Замена в переменной doc данных
            try {
                doc.getRange().replaceText("$ФИОпокупателя", jTextField_FIO.getText());
                doc.getRange().replaceText("$АДРЕСпоставщика", jTextField_Adres.getText());
            } catch (Exception ex) {
                System.err.println("Error replaceText!");
            }

            // Сохранение переменной doc в новый файл
            try ( FileOutputStream fos = new FileOutputStream(dir + "receipt.doc")) {
                doc.write(fos);
                fos.close();

                // Открытие файла внешней программой
                if (System.getProperty("os.name").equals("Linux")
                        && System.getProperty("java.vendor").startsWith("Red Hat")) {
                    new ProcessBuilder("xdg-open", dir + "receipt.doc").start();
                } else {
                    Desktop.getDesktop().open(new File(dir + "receipt.doc"));
                }
            } catch (Exception ex) {
                System.err.println("Error getDesktop!");
            }
            setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        }
    }

    class TThread3 extends Thread {

        public void run() {
            String dir = new File(".").getAbsoluteFile().getParentFile().getAbsolutePath()
                    + System.getProperty("file.separator");

            // Чтение из файла-шаблона в переменную doc
            HWPFDocument doc = null;
            try ( FileInputStream fis = new FileInputStream(dir + "receipt_template.doc")) {
                doc = new HWPFDocument(fis);
                fis.close();
            } catch (Exception ex) {
                System.err.println("Error template!");
            }

            // Замена в переменной doc данных
            try {
                doc.getRange().replaceText("$ФИОпокупателя", jTextField_FIO.getText());
                doc.getRange().replaceText("$АДРЕСпоставщика", jTextField_Adres.getText());
            } catch (Exception ex) {
                System.err.println("Error replaceText!");
            }

            // Сохранение переменной doc в новый файл
            try ( FileOutputStream fos = new FileOutputStream(dir + "receipt.docx")) {
                doc.write(fos);
                fos.close();

                // Открытие файла внешней программой
                if (System.getProperty("os.name").equals("Linux")
                        && System.getProperty("java.vendor").startsWith("Red Hat")) {
                    new ProcessBuilder("xdg-open", dir + "receipt.docx").start();
                } else {
                    Desktop.getDesktop().open(new File(dir + "receipt.docx"));
                }
            } catch (Exception ex) {
                System.err.println("Error getDesktop!");
            }
            setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        }
    }

    public ReceiptWord() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton_Save_DOCX = new javax.swing.JButton();
        jButton_Save = new javax.swing.JButton();
        jButton_Save_DOC = new javax.swing.JButton();
        jTextField_FIO = new javax.swing.JTextField();
        jTextField_Adres = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Квитанция в MS Word");
        setResizable(false);
        getContentPane().setLayout(null);

        jButton_Save_DOCX.setText("в DOCX");
        jButton_Save_DOCX.setToolTipText("");
        jButton_Save_DOCX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Save_DOCXActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Save_DOCX);
        jButton_Save_DOCX.setBounds(410, 320, 80, 22);

        jButton_Save.setText("в PDF");
        jButton_Save.setToolTipText("");
        jButton_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SaveActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Save);
        jButton_Save.setBounds(590, 320, 80, 22);

        jButton_Save_DOC.setText("в DOC");
        jButton_Save_DOC.setToolTipText("");
        jButton_Save_DOC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Save_DOCActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Save_DOC);
        jButton_Save_DOC.setBounds(500, 320, 80, 22);

        jTextField_FIO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTextField_FIO);
        jTextField_FIO.setBounds(370, 170, 260, 24);

        jTextField_Adres.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTextField_Adres);
        jTextField_Adres.setBounds(370, 200, 260, 24);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kdk10_lab4/receipt.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 0, 700, 320);

        setSize(new java.awt.Dimension(727, 386));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SaveActionPerformed
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        new TThread1().start();
    }//GEN-LAST:event_jButton_SaveActionPerformed

    private void jButton_Save_DOCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Save_DOCActionPerformed
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        new TThread2().start();
    }//GEN-LAST:event_jButton_Save_DOCActionPerformed

    private void jButton_Save_DOCXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Save_DOCXActionPerformed
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        new TThread3().start();
    }//GEN-LAST:event_jButton_Save_DOCXActionPerformed

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
            java.util.logging.Logger.getLogger(ReceiptWord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReceiptWord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReceiptWord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReceiptWord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReceiptWord().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Save;
    private javax.swing.JButton jButton_Save_DOC;
    private javax.swing.JButton jButton_Save_DOCX;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField_Adres;
    private javax.swing.JTextField jTextField_FIO;
    // End of variables declaration//GEN-END:variables
}
