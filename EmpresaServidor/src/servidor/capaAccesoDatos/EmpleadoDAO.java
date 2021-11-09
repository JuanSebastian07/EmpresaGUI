package servidor.capaAccesoDatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import servidor.modelo.dominio.Empleado;
import servidor.modelo.dominio.TipoEmpleado;

/**
 * la clase permite registrar, eliminar, actualizar, consultar y listar datos de los libros almacenados en el sistema
 * @author: Daniel Eduardo Paz Perafán
 * @version: 01/10/2021 * 
 */

public class EmpleadoDAO{
    private final ConexionBD conexionABaseDeDatos;
    
    public EmpleadoDAO()
    {
        this.conexionABaseDeDatos=new ConexionBD();
    }    

    public boolean registrarEmpleado(Empleado objEmpleado) 
    {        
        System.out.println("invocando a registrar Empleado del lado del servidor");
        conexionABaseDeDatos.conectar();
        int resultado=-1;
        try {            
            PreparedStatement sentencia = null;
            String consulta = "insert into empleados(codigo, nombre,hijos,salario,idtipo,idempresa) values(?,?,?,?,?,?)";
            sentencia = conexionABaseDeDatos.getConnection().prepareStatement(consulta);
            System.out.println("codigo del Empleado a registrar: " + objEmpleado.getCodigo());    
            sentencia.setString(1, objEmpleado.getCodigo());
            sentencia.setString(2, objEmpleado.getNombre());            
            sentencia.setInt(3, objEmpleado.getCantidadHijos());
            sentencia.setFloat(4, objEmpleado.getSalario());
            sentencia.setInt(5, objEmpleado.getObjTipoEmpleado().getIdTipo());
            sentencia.setInt(6, 1);
            
            resultado = sentencia.executeUpdate(); //ejecuto la sentencia contra la base de datos
            sentencia.close();
            conexionABaseDeDatos.desconectar();

        } catch (SQLException e) {
                  System.out.println("error en la inserción: "+e.getMessage());         
        }
              
        return resultado == 1;
    }
            
    public LinkedList<Empleado> consultarEmpleados(){
        
        System.out.println("invocando a listar Empleados del lado del servidor  \ud83d\udd25");
        LinkedList<Empleado> empleados = new LinkedList();
        
        conexionABaseDeDatos.conectar();        
        try {            
            PreparedStatement sentencia = null;
            String consulta = "select * from empleados inner join tipo_empleados on empleados.idTipo=tipo_empleados.idTipo";
            sentencia = conexionABaseDeDatos.getConnection().prepareStatement(consulta);            
            ResultSet res = sentencia.executeQuery();
            //con este while recorremos todos los registros
            while(res.next()){
                //Empleado objEmpleado= new Empleado();
                Empleado objEmpleado = new Empleado();
                //Aqui sacamos el codigo que esta en DB y lo fijamos en el objEmpleado y asi con todos 
                objEmpleado.setCodigo(res.getString("codigo"));
                objEmpleado.setNombre(res.getString("nombre"));  
                //objeto objTipoEMpleado
                TipoEmpleado objTipoEmpleado= new TipoEmpleado();
                objTipoEmpleado.setIdTipo(res.getInt("idtipo"));
                objTipoEmpleado.setNombre(res.getString("tipo_empleados.nombre"));
                objEmpleado.setSalario(res.getFloat("salario"));
                objEmpleado.setCantidadHijos(res.getInt("hijos"));
                //objTipoEmpleado.setNombre(res.getString("tiposDeEmpleados.nombre"));
                objEmpleado.setObjTipoEmpleado(objTipoEmpleado);
                empleados.add(objEmpleado);
            }
            sentencia.close();
            conexionABaseDeDatos.desconectar();

        } catch (SQLException e) {
                  System.out.println("error en la consulta de los Empledos: "+e.getMessage());         
        }
        
        return empleados;
    }
            
    public Empleado consultarEmpleado(String codigo)
    {
        System.out.println("invocando a consultar Empleado del lado del servidor");
        Empleado objEmpleado=null;
      
        conexionABaseDeDatos.conectar();        
        try {            
            PreparedStatement sentencia = null;
            String consulta = "select * from empleados inner join tipo_empleados on empleados.idTipo=tipo_empleados.idTipo where codigo=?";
            sentencia = conexionABaseDeDatos.getConnection().prepareStatement(consulta);            
            sentencia.setString(1, codigo);
            ResultSet res = sentencia.executeQuery();
            if(res.next()){
                objEmpleado= new Empleado();
                
                objEmpleado.setCodigo(res.getString("codigo"));
                
                objEmpleado.setNombre(res.getString("nombre"));
                //
                TipoEmpleado objTipoEmpleado= new TipoEmpleado();
                objTipoEmpleado.setIdTipo(res.getInt("idTipo"));
                
                objEmpleado.setSalario(res.getFloat("salario"));
                
                objEmpleado.setCantidadHijos(res.getInt("cantidad hijos"));
                
                objTipoEmpleado.setNombre(res.getString("tipo_empleados.nombre"));
                
                objEmpleado.setObjTipoEmpleado(objTipoEmpleado);                
            }
            sentencia.close();
            conexionABaseDeDatos.desconectar();

        } catch (SQLException e) {
                  System.out.println("error en la consulta de un Empleado: "+e.getMessage());         
        }
        
        return objEmpleado;
    }
    
    public boolean actualizarEmpleado(Empleado objEmpleado, String codigo)
    {        
        System.out.println("invocando a actualizar Empleado del lado del servidor");
        conexionABaseDeDatos.conectar();
        int resultado=-1;
        try {            
            PreparedStatement sentencia = null;
            String consulta = "update empleados set empleados.codigo=?,"
                                                 + "empleados.titulo=?,"
                                                 + "empleados.cantidad=? "
                                                 + "empleados.idTipo=?"
                                                 + "where empleados.codigo=?";
            sentencia = conexionABaseDeDatos.getConnection().prepareStatement(consulta);
            sentencia.setString(1, objEmpleado.getCodigo());
            sentencia.setString(2, objEmpleado.getNombre());
            sentencia.setInt(3, objEmpleado.getCantidadHijos());
            sentencia.setInt(4, objEmpleado.getObjTipoEmpleado().getIdTipo());
            sentencia.setString(5, codigo);
            resultado = sentencia.executeUpdate(); 
            sentencia.close();
            conexionABaseDeDatos.desconectar();

        } catch (SQLException e) {
                  System.out.println("error en la actualización: "+e.getMessage());         
        }
        
        return resultado == 1;
    }
        
    public boolean eliminarEmpleado(String codigo){
        System.out.println("invocando a eliminar Empleado del lado del servidor");
        conexionABaseDeDatos.conectar();
        int resultado=-1;
        try {            
            PreparedStatement sentencia = null;
            String consulta = "delete from empleados where codigo=?";
            sentencia = conexionABaseDeDatos.getConnection().prepareStatement(consulta);            
            sentencia.setString(1, codigo);
            resultado = sentencia.executeUpdate(); 
            sentencia.close();
            conexionABaseDeDatos.desconectar();

        } catch (SQLException e) {
                  System.out.println("error en la eliminación: "+e.getMessage());         
        }
        
        return resultado == 1;
    }
}
