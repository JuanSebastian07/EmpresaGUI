package servidor.capaAccesoDatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import servidor.modelo.dominio.Administrador;


public class AdministradorDAO {
    
    private final ConexionBD conexionABaseDeDatos;
       
    public AdministradorDAO()
    {
        this.conexionABaseDeDatos = new ConexionBD();
    }    
    
    public boolean consultarAdministrador(Administrador objAdministrador)
    {
        System.out.println("invocando a iniciar sesión del lado del servidor");
        boolean bandera=false;
        conexionABaseDeDatos.conectar();        
        try {            
            PreparedStatement sentencia = null;
            String consulta = "select login, clave from administrador";
            sentencia = conexionABaseDeDatos.getConnection().prepareStatement(consulta);            
            ResultSet res = sentencia.executeQuery();
            while(res.next())
            { 
                String login=res.getString("login");
                String clave=res.getString("clave");                
                if(login.equals(objAdministrador.getLogin()) && clave.equals(objAdministrador.getClave()))
                {
                    bandera=true;
                    break;
                }
            }
            sentencia.close();
            conexionABaseDeDatos.desconectar();

        } catch (SQLException e) {
                  System.out.println("error en la consulta del administrador: "+e.getMessage());         
        }
        
        return bandera;
    }
}
