package cliente.servicios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

 
public class cliente {
 
    private final String dirIpServidor;
    private final int puertoServidor;
    private DataInputStream objFlujoDeEntrada;// leer del canal la respuesta
    private DataOutputStream objFlujoDeSalida;// escribir en el canal los numeros a sumar
    private Socket objSocket;
    
    public cliente(String dirIpServidor, int puertoServidor) {
        this.dirIpServidor = dirIpServidor;
        this.puertoServidor = puertoServidor;
    }    
    
    public void crearConexion() throws IOException
    {
        //Creo el socket para conectarme con el servidor
        objSocket = new Socket(dirIpServidor, puertoServidor); //el cliente solicita una conexión con el servidor
        objFlujoDeEntrada = new DataInputStream(objSocket.getInputStream());
        objFlujoDeSalida = new DataOutputStream(objSocket.getOutputStream());
    }
    
    public void cerrarConexion() throws IOException
    {
        //Cierro el socket
        objSocket.close();// cierra el canal bidireccional
    }
    
    public  String enviarPeticion(String JSONPeticion) {
        
        String respuesta="";
        
        try {            
            objFlujoDeSalida.writeUTF(JSONPeticion);
            respuesta = objFlujoDeEntrada.readUTF(); 
        } catch (IOException ex) {
            System.out.println("" + ex.getMessage());
            System.out.println("Error al realizar la conexión");
        }
        
        return respuesta;
    }
 
}