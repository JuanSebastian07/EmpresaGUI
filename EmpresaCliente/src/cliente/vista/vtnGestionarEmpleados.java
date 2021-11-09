package cliente.vista;

import cliente.modelo.dominio.Empleado;
import cliente.servicios.EmpresaServices;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import cliente.utilidades.Utilidades;
import javax.swing.JButton;


public class vtnGestionarEmpleados extends javax.swing.JInternalFrame {
    
    //    
    private EmpresaServices objEmpresaServices;
    
    //constructor
    public vtnGestionarEmpleados() {
        initComponents();
        inicializarrTabla();
        this.jTableMostrarEmpleados.setDefaultRenderer(Object.class, new Render());
    }
    //Aqui ya asociamos el objEmpresaServices a la ventana de gestionar
    public void asociarEmpresaServices(EmpresaServices objEmpresaServices){
        this.objEmpresaServices=objEmpresaServices;
    } 
    
    private void inicializarrTabla(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Codigo");
        model.addColumn("Nombre");
        model.addColumn("Salario");
        model.addColumn("Hijos");
        model.addColumn("Tipo");
        model.addColumn("Eliminar");
        this.jTableMostrarEmpleados.setModel(model);
    }
    
    public void limpiarTabla(){
        DefaultTableModel modelo = (DefaultTableModel) this.jTableMostrarEmpleados.getModel();
        int filas = this.jTableMostrarEmpleados.getRowCount();
        for (int i = 0; i < filas; i++) {
            modelo.removeRow(0);
        }
    }
    
    //
    private void llenarTabla(){
        DefaultTableModel model = (DefaultTableModel) this.jTableMostrarEmpleados.getModel();
        limpiarTabla();
        LinkedList<Empleado> lista=this.objEmpresaServices.listarEmpleados();
        for (int i = 0; i < lista.size(); i++) {
            
            JButton JButtonEliminarUsuario= new JButton();
            JButtonEliminarUsuario.setName("Eliminar");
            JButtonEliminarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/boton-eliminar.png")));
            
            Object [] fila = {lista.get(i).getCodigo(),lista.get(i).getNombre(),lista.get(i).getSalario()+"",lista.get(i).getCantidadHijos()+"",lista.get(i).getObjTipoEmpleado().getNombre(),JButtonEliminarUsuario};
            model.addRow(fila);
                                                        
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelSuperior = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanelInferior = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanelCentral = new javax.swing.JPanel();
        jButtonActualizar = new javax.swing.JButton();
        jButtonRegistrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMostrarEmpleados = new javax.swing.JTable();

        setTitle("Gestionar Empleados\n");

        jPanelSuperior.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Lato Black", 0, 24)); // NOI18N
        jLabel1.setText("Registrar Empleado");

        javax.swing.GroupLayout jPanelSuperiorLayout = new javax.swing.GroupLayout(jPanelSuperior);
        jPanelSuperior.setLayout(jPanelSuperiorLayout);
        jPanelSuperiorLayout.setHorizontalGroup(
            jPanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 533, Short.MAX_VALUE)
            .addGroup(jPanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelSuperiorLayout.createSequentialGroup()
                    .addGap(157, 157, 157)
                    .addComponent(jLabel1)
                    .addContainerGap(158, Short.MAX_VALUE)))
        );
        jPanelSuperiorLayout.setVerticalGroup(
            jPanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
            .addGroup(jPanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelSuperiorLayout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addComponent(jLabel1)
                    .addContainerGap(29, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanelSuperior, java.awt.BorderLayout.PAGE_START);

        jPanelInferior.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jLabel2.setText("Desarrollado Por Sebastian Tobar");

        javax.swing.GroupLayout jPanelInferiorLayout = new javax.swing.GroupLayout(jPanelInferior);
        jPanelInferior.setLayout(jPanelInferiorLayout);
        jPanelInferiorLayout.setHorizontalGroup(
            jPanelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInferiorLayout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(jLabel2)
                .addContainerGap(143, Short.MAX_VALUE))
        );
        jPanelInferiorLayout.setVerticalGroup(
            jPanelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInferiorLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelInferior, java.awt.BorderLayout.PAGE_END);

        jPanelCentral.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButtonActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/update.png"))); // NOI18N
        jButtonActualizar.setText("Actualizar");
        jButtonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarActionPerformed(evt);
            }
        });

        jButtonRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/registros-medicos.png"))); // NOI18N
        jButtonRegistrar.setText(" Registrar");
        jButtonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarActionPerformed(evt);
            }
        });

        jTableMostrarEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableMostrarEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMostrarEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableMostrarEmpleados);

        javax.swing.GroupLayout jPanelCentralLayout = new javax.swing.GroupLayout(jPanelCentral);
        jPanelCentral.setLayout(jPanelCentralLayout);
        jPanelCentralLayout.setHorizontalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCentralLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                    .addGroup(jPanelCentralLayout.createSequentialGroup()
                        .addComponent(jButtonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonRegistrar)))
                .addGap(32, 32, 32))
        );
        jPanelCentralLayout.setVerticalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCentralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelCentral, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarActionPerformed
        //Aqui abrimos el otro formulario 
        vtnRegistrarEmpleado objVtnRegistrarEmpleado = new vtnRegistrarEmpleado();
        //A la ventana registrar le pasamos el objEmpresaServices
        objVtnRegistrarEmpleado.asociarEmpresa(this.objEmpresaServices);
        objVtnRegistrarEmpleado.cargarTiposEmpleado();
        //
        objVtnRegistrarEmpleado.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        objVtnRegistrarEmpleado.setVisible(true);
    }//GEN-LAST:event_jButtonRegistrarActionPerformed

    private void jButtonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarActionPerformed

        
        boolean banderaExisteEmpleados = this.objEmpresaServices.ConsultarSiExisteEmpleado();
        //.ConsultarSiExisteEmpleadoRegistrados();
        System.out.println(banderaExisteEmpleados);
        if(banderaExisteEmpleados != false){
            Utilidades.mensajeAdvertencia("No hay Empleados registrados", "Gestion de Empleados");
        }else{
            llenarTabla();
        }
    }//GEN-LAST:event_jButtonActualizarActionPerformed

    private void jTableMostrarEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMostrarEmpleadosMouseClicked
        int column = this.jTableMostrarEmpleados.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/jTableMostrarEmpleados.getRowHeight();
        
        if(row < jTableMostrarEmpleados.getRowCount() && row >= 0 && column < jTableMostrarEmpleados.getColumnCount() && column >= 0){
            Object value = jTableMostrarEmpleados.getValueAt(row, column);
            
            if(value instanceof JButton){
                
                ((JButton)value).doClick();
                JButton boton = (JButton) value;
                
                String codigo = jTableMostrarEmpleados.getValueAt(row, 0).toString();
               
                if(boton.getName().equals("Eliminar")){
                    try{  
                        if(Utilidades.mensajeConfirmacion("¿ Estás seguro de que quieres eliminar al Empleado con codigo " + codigo + " " 
                            +" ?", "Confirmación") == 0){
                           boolean bandera=this.objEmpresaServices.eliminarLibro(codigo);
                           if(bandera==true)
                           {
                               Utilidades.mensajeExito("El libro con codigo " + codigo + " fue eliminado exitosamente", "Libro eliminado");
                               llenarTabla();
                           }
                           else
                           {
                               Utilidades.mensajeAdvertencia("El libro con codigo " + codigo + " no fue eliminado", "Error al eliminar");
                        
                           }
                        }
                    }catch(Exception ex){
                        Utilidades.mensajeError("Error al eliminar usuario. Intentelo de nuevo más tarde", "Error");
                    }  
                }
            }
        }
    }//GEN-LAST:event_jTableMostrarEmpleadosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanelCentral;
    private javax.swing.JPanel jPanelInferior;
    private javax.swing.JPanel jPanelSuperior;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMostrarEmpleados;
    // End of variables declaration//GEN-END:variables
}
