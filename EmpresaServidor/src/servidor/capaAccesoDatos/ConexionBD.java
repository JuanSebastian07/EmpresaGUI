/**
 * Utiliza la API JDBC de java para conectarse a una base de datos MySQL
 * -----------------------------------------------------------------
 */
package servidor.capaAccesoDatos;
import java.sql.*;

/**
 * Esta clase permite crear una conexión con la base de datos relacional
 */
public class ConexionBD {
   
   private Connection objConexionBaseDatos;    
   private String nombreBaseDatos;
   private String login;
   private String password;
   private String url;
    
    public ConexionBD() {
        objConexionBaseDatos=null;
        nombreBaseDatos="db_empresa";
        login="root";
        password="01309";
        url = "jdbc:mysql://localhost/"+nombreBaseDatos;
    }
    /**Permite hacer la conexion con la base de datos    
     */
    public int conectar(){
        int bandera=-1;
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
           //crea una instancia de la controlador de la base de datos
            objConexionBaseDatos = DriverManager.getConnection(url,login,password);
            // gnera una conexión con la base de datos
             bandera=1;
             //System.out.println("Se conecto exito!!");
        }
        catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return bandera;
    }
    /**Cierra la conexion con la base de datos
     *
     */
   public void desconectar(){
       try{
            objConexionBaseDatos.close();
        }

        catch(Exception e){
            System.out.println("Error " + e.getMessage());
        }
   }
     /**Retorna un objeto que almacena la referencia a la conexion con la base de datos
     *
     */
    public Connection getConnection(){
      return objConexionBaseDatos;
   } 
}
