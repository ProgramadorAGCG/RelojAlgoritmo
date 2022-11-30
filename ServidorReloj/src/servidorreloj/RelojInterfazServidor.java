package servidorreloj;


import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import util.PanelDibujado;


public class RelojInterfazServidor extends javax.swing.JFrame {

    private final Servidor servidor;
    private final SimpleDateFormat formato;

    public RelojInterfazServidor() {
        initComponents();
        servidor = new Servidor();
        formato = new SimpleDateFormat("hh: mm: ss aa");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new PanelDibujado("../img/fondoEspacial.jpg");
        jlblHora = new javax.swing.JLabel();
        jtxtNombre = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setLayout(null);

        jlblHora.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jlblHora.setForeground(new java.awt.Color(255, 255, 255));
        jlblHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jlblHora);
        jlblHora.setBounds(80, 129, 240, 146);
        jlblHora.getAccessibleContext().setAccessibleName("jlblHora");

        jtxtNombre.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jtxtNombre.setForeground(new java.awt.Color(255, 255, 255));
        jtxtNombre.setText("SERVIDOR");
        jPanel1.add(jtxtNombre);
        jtxtNombre.setBounds(140, 27, 120, 32);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void actualizandoHora() {
        new Thread(() -> {
            try {
                while (true) {
                    jlblHora.setText(formato.format(servidor.cambiarHoraActual()));
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }).start();
    }

    private void esperandoSolicitud() {
        new Thread(() -> {
            try ( ServerSocket serverSocket = new ServerSocket(9090)) {
                String inputLine;
                while (true) {
                    Socket clienteSocket = serverSocket.accept();
                    PrintWriter out = new PrintWriter(clienteSocket.getOutputStream(), true);
                    /*Escribe su propios milisegundos*/
                    out.println(System.currentTimeMillis());
                }
            } catch (Exception e) {
            }
        }).start();
    }

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        actualizandoHora();
        esperandoSolicitud();
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(RelojInterfazServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RelojInterfazServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RelojInterfazServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RelojInterfazServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new RelojInterfazServidor().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlblHora;
    private javax.swing.JLabel jtxtNombre;
    // End of variables declaration//GEN-END:variables
}
