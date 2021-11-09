package cliente.test;

import cliente.servicios.AdministradorServices;
import javax.swing.UIManager;
import cliente.vista.vtnIniciarSesion;


public class Test {

    public static void main(String[] args) {
        AdministradorServices objAdministradorServices= new AdministradorServices("localhost",5010);
        seleccionarLookAndField();
        vtnIniciarSesion objVtnIniciarSesion= new vtnIniciarSesion();
        //a la ventana principal le pasamos objEmpresa services
        objVtnIniciarSesion.asociarAdministrador(objAdministradorServices);
        objVtnIniciarSesion.setVisible(true);
    }
    
    private static void seleccionarLookAndField(){
        for(UIManager.LookAndFeelInfo laf:UIManager.getInstalledLookAndFeels()){
            if("Nimbus".equals(laf.getName()))
                try {
                UIManager.setLookAndFeel(laf.getClassName());
                 } catch (Exception ex) {
            }
        }
    }       
}
