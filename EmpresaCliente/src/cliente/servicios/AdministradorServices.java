package cliente.servicios;

import cliente.modelo.dominio.Administrador;
import cliente.modelo.dominio.Empleado;
import cliente.modelo.peticion.PeticionDTO;
import cliente.servicios.cliente;
import com.google.gson.Gson;
import java.io.IOException;


public class AdministradorServices {
    
    private final cliente objCliente;
    private final Gson objConvertidor;
    
    public AdministradorServices(String direccionIpServidor, int puertoServidor)
    {
        this.objCliente=new cliente(direccionIpServidor, puertoServidor);
        this.objConvertidor= new Gson();
    }
   
    public boolean iniciarSesion(Administrador objAdministrador) {
        System.out.println("invocando a iniciarSesion del lado del cliente");
        String resultado="";
        try {
            this.objCliente.crearConexion();           
            PeticionDTO objPeticion= new PeticionDTO();              
            String JSONAdministrador=objConvertidor.toJson(objAdministrador);
            objPeticion.setNombrePetición("IniciarSesion");
            objPeticion.setArgumentosPetición(JSONAdministrador);
            String JSONPeticion=objConvertidor.toJson(objPeticion);
            resultado=objCliente.enviarPeticion(JSONPeticion);            
            objCliente.cerrarConexion();
        } catch (IOException ex) {
            resultado=ex.getMessage();
        }
        return Boolean.parseBoolean(resultado);
    }
}
