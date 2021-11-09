/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.vista;

import cliente.servicios.EmpresaServices;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class vtnPrincipal extends javax.swing.JFrame {
 
    private EmpresaServices objEmpresaServices;
    private vtnGestionarEmpleados objVtnGestionarEmpleado;
    private vtnVerPrestamos objVtnVerPrestamos;
    private vtnVerEstadisticas objVtnVerEstadisticas;
    
    FondoPanel fondo = new FondoPanel();
    
    public vtnPrincipal() {

        initComponents();
        //posicion de la ventana
        this.setLocationRelativeTo(null);
        
        
        
        //Cambiamos icono al formulario
        setIconImage(new ImageIcon(getClass().getResource("/recursos/linux.png")).getImage());
        
        //imagen empresa
        Image img1 = new ImageIcon(getClass().getResource("/recursos/github_1.png")).getImage();
        ImageIcon img2 = new ImageIcon(img1.getScaledInstance(80, 80, Image.SCALE_SMOOTH));
        this.jLabelImagenOrganizacion.setIcon(img2);
        this.jLabelImagenOrganizacion.setText("");
        
        //imagen facebook
        Image img3 = new ImageIcon(getClass().getResource("/recursos/facebook.png")).getImage();
        ImageIcon img4 = new ImageIcon(img3.getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        this.jLabelFacebook.setIcon(img4);
        this.jLabelFacebook.setText("");
        
        //imagen instagram
        Image img5 = new ImageIcon(getClass().getResource("/recursos/instagram.png")).getImage();
        ImageIcon img6 = new ImageIcon(img5.getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        this.jLabelInstagram.setIcon(img6);
        this.jLabelInstagram.setText("");
        
        //imagen Twitter
        Image img7 = new ImageIcon(getClass().getResource("/recursos/gorjeo.png")).getImage();
        ImageIcon img8 = new ImageIcon(img7.getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        this.jLabelTwiter.setIcon(img8);
        this.jLabelTwiter.setText("");
        
        //Imagen google
        Image img9 = new ImageIcon(getClass().getResource("/recursos/google.png")).getImage();
        ImageIcon img10 = new ImageIcon(img9.getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        this.jLabelGoogle.setIcon(img10);
        this.jLabelGoogle.setText("");
        
    }
    //aqui asociamos objEmpresaServices con la ventana principal
    public void asociarEmpresa(EmpresaServices objEmpresaServices){
        this.objEmpresaServices=objEmpresaServices;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelInferior = new javax.swing.JPanel();
        jLabelInstagram = new javax.swing.JLabel();
        jLabelGoogle = new javax.swing.JLabel();
        jLabelTwiter = new javax.swing.JLabel();
        jLabelFacebook = new javax.swing.JLabel();
        jPanelCentral = new FondoPanel();
        ImageIcon icon = new ImageIcon(getClass().getResource("/recursos/debian-Fondo.jpg"));
        Image image = icon.getImage();
        jDesktopPanelPrincipal = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };
        jPanelSuperior = new javax.swing.JPanel();
        jLabelImagenOrganizacion = new javax.swing.JLabel();
        jButtonMenuGestionarLibro = new javax.swing.JButton();
        jButtonVerPrestamos = new javax.swing.JButton();
        jButtonVerEstadisticas = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanelInferior.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelInstagram.setText("Instagram");

        jLabelGoogle.setText("Google");

        jLabelTwiter.setText("Twitter");

        jLabelFacebook.setText("Face");

        javax.swing.GroupLayout jPanelInferiorLayout = new javax.swing.GroupLayout(jPanelInferior);
        jPanelInferior.setLayout(jPanelInferiorLayout);
        jPanelInferiorLayout.setHorizontalGroup(
            jPanelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInferiorLayout.createSequentialGroup()
                .addContainerGap(495, Short.MAX_VALUE)
                .addComponent(jLabelInstagram)
                .addGap(18, 18, 18)
                .addComponent(jLabelGoogle)
                .addGap(26, 26, 26)
                .addComponent(jLabelTwiter)
                .addGap(17, 17, 17)
                .addComponent(jLabelFacebook)
                .addContainerGap())
        );
        jPanelInferiorLayout.setVerticalGroup(
            jPanelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInferiorLayout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(jPanelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelGoogle)
                    .addComponent(jLabelTwiter)
                    .addComponent(jLabelFacebook)
                    .addComponent(jLabelInstagram))
                .addGap(39, 39, 39))
        );

        getContentPane().add(jPanelInferior, java.awt.BorderLayout.PAGE_END);

        jPanelCentral.setBackground(new java.awt.Color(51, 51, 51));
        jPanelCentral.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jDesktopPanelPrincipal.setBackground(new java.awt.Color(153, 153, 153));
        jDesktopPanelPrincipal.setForeground(new java.awt.Color(255, 0, 153));

        javax.swing.GroupLayout jDesktopPanelPrincipalLayout = new javax.swing.GroupLayout(jDesktopPanelPrincipal);
        jDesktopPanelPrincipal.setLayout(jDesktopPanelPrincipalLayout);
        jDesktopPanelPrincipalLayout.setHorizontalGroup(
            jDesktopPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 548, Short.MAX_VALUE)
        );
        jDesktopPanelPrincipalLayout.setVerticalGroup(
            jDesktopPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 419, Short.MAX_VALUE)
        );

        jPanelSuperior.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSuperior.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelImagenOrganizacion.setText("Imagen");
        jPanelSuperior.add(jLabelImagenOrganizacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jButtonMenuGestionarLibro.setText("Gestionar Empleados");
        jButtonMenuGestionarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenuGestionarLibroActionPerformed(evt);
            }
        });
        jPanelSuperior.add(jButtonMenuGestionarLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 160, 40));

        jButtonVerPrestamos.setText("Ver prestamos");
        jButtonVerPrestamos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerPrestamosActionPerformed(evt);
            }
        });
        jPanelSuperior.add(jButtonVerPrestamos, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 120, 40));

        jButtonVerEstadisticas.setText("Ver estadisticas");
        jButtonVerEstadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerEstadisticasActionPerformed(evt);
            }
        });
        jPanelSuperior.add(jButtonVerEstadisticas, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 130, 40));

        jLabel1.setFont(new java.awt.Font("Lato Black", 0, 24)); // NOI18N
        jLabel1.setText("Si SE PUEDE IMAGINAR, SE PUEDE PROGAMAR");
        jPanelSuperior.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        javax.swing.GroupLayout jPanelCentralLayout = new javax.swing.GroupLayout(jPanelCentral);
        jPanelCentral.setLayout(jPanelCentralLayout);
        jPanelCentralLayout.setHorizontalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCentralLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jDesktopPanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanelSuperior, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
        );
        jPanelCentralLayout.setVerticalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCentralLayout.createSequentialGroup()
                .addComponent(jPanelSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        getContentPane().add(jPanelCentral, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVerEstadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerEstadisticasActionPerformed

        if(this.objVtnVerPrestamos!=null){
            this.objVtnVerPrestamos.setVisible(false);
            this.objVtnVerPrestamos=null;
        }

        if(this.objVtnGestionarEmpleado!=null){
            this.objVtnGestionarEmpleado.setVisible(false);
            this.objVtnGestionarEmpleado=null;
        }
        
        if(this.objVtnVerEstadisticas!=null){
            this.objVtnVerEstadisticas.setVisible(false);
            this.objVtnVerEstadisticas=null;
        }

        this.objVtnVerEstadisticas= new vtnVerEstadisticas();
        objVtnVerEstadisticas.setVisible(true);
        this.jDesktopPanelPrincipal.add(objVtnVerEstadisticas);
    }//GEN-LAST:event_jButtonVerEstadisticasActionPerformed

    private void jButtonVerPrestamosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerPrestamosActionPerformed

        if(this.objVtnVerEstadisticas!=null){
            this.objVtnVerEstadisticas.setVisible(false);
            this.objVtnVerEstadisticas=null;
        }

        if(this.objVtnGestionarEmpleado!=null){
            this.objVtnGestionarEmpleado.setVisible(false);
            this.objVtnGestionarEmpleado=null;
        }
        
        if(this.objVtnVerPrestamos!=null){
            this.objVtnVerPrestamos.setVisible(false);
            this.objVtnVerPrestamos=null;
        }
        
        this.objVtnVerPrestamos= new vtnVerPrestamos();
        objVtnVerPrestamos.setVisible(true);
        this.jDesktopPanelPrincipal.add(objVtnVerPrestamos);
    }//GEN-LAST:event_jButtonVerPrestamosActionPerformed

    private void jButtonMenuGestionarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenuGestionarLibroActionPerformed

        if(this.objVtnVerEstadisticas!=null){
            this.objVtnVerEstadisticas.setVisible(false);
            this.objVtnVerEstadisticas=null;
        }

        if(this.objVtnVerPrestamos!=null){
            this.objVtnVerPrestamos.setVisible(false);
            this.objVtnVerPrestamos=null;
        }
        
        if(this.objVtnGestionarEmpleado!=null){
            this.objVtnGestionarEmpleado.setVisible(false);
            this.objVtnGestionarEmpleado=null;
        }
        
        this.objVtnGestionarEmpleado= new vtnGestionarEmpleados();
        //Y aqui le pasamos objEmpresaService a la ventana de GestionarEmpleado
        this.objVtnGestionarEmpleado.asociarEmpresaServices(objEmpresaServices);
        objVtnGestionarEmpleado.setVisible(true);
        this.jDesktopPanelPrincipal.add(objVtnGestionarEmpleado);
    }//GEN-LAST:event_jButtonMenuGestionarLibroActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonMenuGestionarLibro;
    private javax.swing.JButton jButtonVerEstadisticas;
    private javax.swing.JButton jButtonVerPrestamos;
    private javax.swing.JDesktopPane jDesktopPanelPrincipal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelFacebook;
    private javax.swing.JLabel jLabelGoogle;
    private javax.swing.JLabel jLabelImagenOrganizacion;
    private javax.swing.JLabel jLabelInstagram;
    private javax.swing.JLabel jLabelTwiter;
    private javax.swing.JPanel jPanelCentral;
    private javax.swing.JPanel jPanelInferior;
    private javax.swing.JPanel jPanelSuperior;
    // End of variables declaration//GEN-END:variables
    
    class FondoPanel extends JPanel{
        
        private Image imagen;
        
        @Override
        public void paint(Graphics g){
            imagen = new ImageIcon(getClass().getResource("/recursos/fondo-binario.jpg")).getImage();
            
            g.drawImage(imagen,0,0,getWidth(),getHeight(),this);
            setOpaque(false);
            super.paint(g);
        }
    }

}
