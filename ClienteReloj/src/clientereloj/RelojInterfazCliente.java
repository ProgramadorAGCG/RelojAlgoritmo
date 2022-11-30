package clientereloj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RelojInterfazCliente extends javax.swing.JFrame {

    private final SimpleDateFormat formato;
    private final Cliente cliente;

    public RelojInterfazCliente(Cliente cliente) {
        initComponents();
        formato = new SimpleDateFormat("hh: mm: ss aa");
        this.cliente = cliente;
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jtxtNombre = new javax.swing.JLabel();
        jlblHora = new javax.swing.JLabel();
        btnActualizarHora = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jtxtNombre.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jtxtNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jtxtNombre.setText("Nombre: ");
        jPanel1.add(jtxtNombre);
        jtxtNombre.setBounds(70, 70, 360, 32);

        jlblHora.setBackground(new java.awt.Color(255, 255, 255));
        jlblHora.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jlblHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jlblHora);
        jlblHora.setBounds(105, 140, 290, 180);
        jlblHora.getAccessibleContext().setAccessibleName("jlblHora");

        btnActualizarHora.setBackground(new java.awt.Color(0, 153, 51));
        btnActualizarHora.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizarHora.setText("Actualizar Hora");
        btnActualizarHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarHoraActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizarHora);
        btnActualizarHora.setBounds(175, 340, 150, 29);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 400, 500, 50);

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 0, 500, 50);

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5);
        jPanel5.setBounds(450, 50, 50, 350);

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel7);
        jPanel7.setBounds(0, 50, 50, 350);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jtxtNombre.setText(jtxtNombre.getText() + cliente.getNombre());
        new Thread(() -> {
            while (true) {
                jlblHora.setText(formato.format(cliente.aumentarTiempo()));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }).start();
    }//GEN-LAST:event_formWindowOpened

    private void btnActualizarHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarHoraActionPerformed
        try ( Socket socket = new Socket("192.168.1.38", 9090);  PrintWriter out = new PrintWriter(socket.getOutputStream(), true);  BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));) {
            Long tiempoCero, tiempoServidor, tiempoUno, tiempoFinal;

            /*System.currentTimeMillis(); imprime los milisegundos hasta la fecha actual*/
            tiempoCero = System.currentTimeMillis();
            /*Sirve para escribir un objeto y enviarlo*/
            out.println(tiempoCero);
            /*Obtiene el tiempo enviado por el servidor y lo conviere el long*/
            tiempoServidor = Long.parseLong(in.readLine());

            tiempoUno = System.currentTimeMillis();
            tiempoFinal = tiempoServidor + (tiempoUno - tiempoCero)/ 2;

            cliente.setHora(new Date(tiempoFinal));
            jlblHora.setText(formato.format(cliente.getHora()));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnActualizarHoraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarHora;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel jlblHora;
    private javax.swing.JLabel jtxtNombre;
    // End of variables declaration//GEN-END:variables
}
