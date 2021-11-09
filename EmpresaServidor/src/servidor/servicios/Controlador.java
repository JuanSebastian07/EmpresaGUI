/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.servicios;

import com.google.gson.Gson;
import java.util.LinkedList;
import servidor.capaAccesoDatos.AdministradorDAO;
import servidor.capaAccesoDatos.EmpleadoDAO;
import servidor.capaAccesoDatos.TipoEmpleadoDAO;
import servidor.modelo.dominio.Administrador;
import servidor.modelo.dominio.Empleado;
import servidor.modelo.dominio.Empresa;
import servidor.modelo.dominio.TipoEmpleado;
import servidor.modelo.peticion.PeticionDTO;

//esta clase se usa en servidor y en vistaPrincipal
public class Controlador {
        
    //Atributo de tipo Empresa
    private Empresa objEmpresa;
    private final EmpleadoDAO objEmpleadoDAO;
    private final AdministradorDAO objAdministradorDAO;
    private final TipoEmpleadoDAO objTipoEmpleadoDAO;
    private final Gson objConvertidor;
    
   //constructor
    public Controlador() {
        this.objEmpleadoDAO = new EmpleadoDAO(); 
        this.objAdministradorDAO = new AdministradorDAO();
        this.objTipoEmpleadoDAO = new TipoEmpleadoDAO();
        this.objConvertidor= new Gson();
    }
    
    //metodo llamado desde la clase servidor
    public String atenderPeticion(String JSON)
    {
        String resultado="";
        PeticionDTO objPeticion=this.objConvertidor.fromJson(JSON, PeticionDTO.class);
        
        String nombrePeticion=objPeticion.getNombrePetición();
        
        switch(nombrePeticion)
        {
            case "RegistrarEmpleado":
                String JSONArgumento=objPeticion.getArgumentosPetición();
                Empleado objEmpleadoARegistrar=this.objConvertidor.fromJson(JSONArgumento, Empleado.class);
                Boolean bandera1=this.objEmpleadoDAO.registrarEmpleado(objEmpleadoARegistrar);
                resultado=bandera1.toString();                
            break;
            case "ListarEmpleados":
                LinkedList<Empleado> listaEmpleados= this.objEmpleadoDAO.consultarEmpleados();
                resultado=this.objConvertidor.toJson(listaEmpleados);               
            break;
            case "ConsultarSiExisteEmpleado":
                String codigo1=objPeticion.getArgumentosPetición();
                Boolean bandera2=false;
                if(this.objEmpleadoDAO.consultarEmpleados().isEmpty())
                {
                    bandera2=true;
                }   
                resultado=bandera2.toString(); 
                
            break;
            case "EliminarEmpleado":
                String codigo2=objPeticion.getArgumentosPetición();
                Boolean bandera3=this.objEmpleadoDAO.eliminarEmpleado(codigo2);
                resultado=bandera3.toString(); 
            break;
             case "ListarTiposDeLibro":
                 System.out.println("listar tipos de libro");
                LinkedList<TipoEmpleado> listaTiposEmpleado= this.objTipoEmpleadoDAO.consultarTiposDeEmpleados();
                resultado=this.objConvertidor.toJson(listaTiposEmpleado);  
            break;
             case "IniciarSesion":
                //System.out.println("Entro exitosamente a iniciar sesion del lado del servidor");
                String JSONArgumentoAdministrador=objPeticion.getArgumentosPetición();
                Administrador objAdministrador=this.objConvertidor.fromJson(JSONArgumentoAdministrador, Administrador.class);
                Boolean bandera=this.objAdministradorDAO.consultarAdministrador(objAdministrador);
                resultado=bandera.toString();  
            break;
            default:
                resultado="Error, petición desconocida";
            
        }
        
       return resultado;
    }
}
