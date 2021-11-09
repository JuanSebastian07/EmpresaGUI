
package servidor.capaAccesoDatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import servidor.modelo.dominio.TipoEmpleado;

public class TipoEmpleadoDAO {
    
    private final ConexionBD conexionABaseDeDatos;
       
    public TipoEmpleadoDAO()
    {
        this.conexionABaseDeDatos= new ConexionBD();
    } 
    
    public LinkedList<TipoEmpleado> consultarTiposDeEmpleados()
    {
        System.out.println("invocando a listar tipos de Empleados del lado del servidor");
        LinkedList<TipoEmpleado> tiposDeLibros = new LinkedList();
        
        conexionABaseDeDatos.conectar();        
        try {            
            PreparedStatement sentencia = null;
            String consulta = "select * from tipo_empleados";
            sentencia = conexionABaseDeDatos.getConnection().prepareStatement(consulta);            
            ResultSet res = sentencia.executeQuery();
            while(res.next())
            {
                TipoEmpleado objTipo= new TipoEmpleado();
                objTipo.setIdTipo(res.getInt("idTipo"));
                objTipo.setNombre(res.getString("nombre"));
                tiposDeLibros.add(objTipo);
            }
            sentencia.close();
            conexionABaseDeDatos.desconectar();

        } catch (SQLException e) {
                  System.out.println("error al listar los tipos de Empleados: "+e.getMessage());         
        }
        
        return tiposDeLibros;
    }
}
