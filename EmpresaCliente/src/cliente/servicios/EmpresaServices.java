package cliente.servicios;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.LinkedList;
import cliente.modelo.dominio.Empleado;
import cliente.modelo.dominio.TipoEmpleado;
import cliente.modelo.peticion.PeticionDTO;

public class EmpresaServices {

    private final cliente objCliente;
    private final Gson objConvertidor;
    
    public EmpresaServices(String direccionIpServidor, int puertoServidor)
    {
        this.objCliente=new cliente(direccionIpServidor, puertoServidor);
        this.objConvertidor= new Gson();
    }
   
    public boolean registrarEmpleado(Empleado objEmpleado) {
        System.out.println("invocando a registrar Empleado del lado del cliente");
        String resultado="";
        try {
            this.objCliente.crearConexion();           
            PeticionDTO objPeticion= new PeticionDTO();              
            String JSONLibro=objConvertidor.toJson(objEmpleado);
            objPeticion.setNombrePetición("RegistrarEmpleado");
            objPeticion.setArgumentosPetición(JSONLibro);
            String JSONPeticion=objConvertidor.toJson(objPeticion);
            resultado=objCliente.enviarPeticion(JSONPeticion);            
            objCliente.cerrarConexion();
        } catch (IOException ex) {
            resultado=ex.getMessage();
        }
        return Boolean.parseBoolean(resultado);
    }

    public boolean ConsultarSiExisteEmpleado() {
       System.out.println("Invocando a consultar si existe Empleado del lado del cliente");
       String resultado="";
       
        try {
            objCliente.crearConexion();
            PeticionDTO objPeticion= new PeticionDTO();                    
            objPeticion.setNombrePetición("ConsultarSiExisteEmpleado");
            //objPeticion.setArgumentosPetición(codigo);            
            String JSON = objConvertidor.toJson(objPeticion);            
            resultado=objCliente.enviarPeticion(JSON);
            objCliente.cerrarConexion();
        } 
        catch (IOException ex) {
            resultado=ex.getMessage();
        }
            
        return Boolean.parseBoolean(resultado);
    }

    public LinkedList<Empleado> listarEmpleados() {
        System.out.println("invocando a listar Empleados del lado del cliente");
        LinkedList<Empleado> listadoEmpleados;        
        try {
            objCliente.crearConexion();
        
            PeticionDTO objPeticion= new PeticionDTO();            
            objPeticion.setNombrePetición("ListarEmpleados");            
            String JSON = objConvertidor.toJson(objPeticion);
            String respuesta=objCliente.enviarPeticion(JSON);//el cliente se queda bloqueado 
            Type listType = new TypeToken<LinkedList<Empleado>>(){}.getType();
            listadoEmpleados = objConvertidor.fromJson(respuesta, listType);
            
            objCliente.cerrarConexion();
        
        } 
        catch (IOException ex) {
            listadoEmpleados=null;
        }
        
        return listadoEmpleados;
    }
    
    public boolean eliminarLibro(String codigo) {
       System.out.println("Invocando a eliminar Empleado del lado del cliente");
       String resultado="";
       
        try {
            objCliente.crearConexion();
            PeticionDTO objPeticion= new PeticionDTO();                    
            objPeticion.setNombrePetición("EliminarEmpleado");
            objPeticion.setArgumentosPetición(codigo);            
            String JSON = objConvertidor.toJson(objPeticion);            
            resultado=objCliente.enviarPeticion(JSON);
            objCliente.cerrarConexion();
        } 
        catch (IOException ex) {
            resultado=ex.getMessage();
        }
            
        return Boolean.parseBoolean(resultado);
    }
    
    public LinkedList<TipoEmpleado> listarTiposDeEmpleados() {
        System.out.println("invocando a listar tipos de Empleados del lado del cliente");
        LinkedList<TipoEmpleado> listadoTiposEmpleados;        
        try {
            objCliente.crearConexion();
        
            PeticionDTO objPeticion= new PeticionDTO();            
            objPeticion.setNombrePetición("ListarTiposDeLibro");            
            String JSON = objConvertidor.toJson(objPeticion);
            String respuesta=objCliente.enviarPeticion(JSON);//el cliente se queda bloqueado 
            Type listType = new TypeToken<LinkedList<TipoEmpleado>>(){}.getType();
            listadoTiposEmpleados = objConvertidor.fromJson(respuesta, listType);
            
            objCliente.cerrarConexion();
        
        } 
        catch (IOException ex) {
            listadoTiposEmpleados=null;
        }
        
        return listadoTiposEmpleados;
    }
    
}
