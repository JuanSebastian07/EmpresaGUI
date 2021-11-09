
package servidor.vista;

import java.io.IOException;
import servidor.modelo.dominio.Empresa;
import servidor.servicios.Controlador;
import servidor.servicios.Servidor;

public class vistaPrincipalServidor {

    
    public static void main(String[] args) {
        
        try {         
            
            //al controlador le pasamos como atributo el objEmpresa para usarlo en el controlador
            Controlador objControlador= new Controlador();
            //
            Servidor objServidor= new Servidor(5010,objControlador);
            objServidor.ejecutarServidor();
        } catch (IOException ex) {
            System.out.println("Error al ejecutar el servidor");
        }
        
    }
    
}
